(ns clojure.build.ci.generator
  (:require [clojure.java.io :as io])
  (:import (org.stringtemplate.v4 ST)))

(defn ci-root [] (io/file "hudson"))

(defn jobs-root [] (io/file (ci-root) "jobs"))

(defn job-dir [jname] (io/file (jobs-root) jname))

(defn job-config-file [jname] (io/file (job-dir jname) "config.xml"))

(defn ci-config-file [] (io/file (ci-root) "config.xml"))

(defn jdks []
  [{:name "Sun JDK 1.5",
    :home "/var/lib/hudson/tools/Sun_JDK_1.5.0_22"}
   {:name "Sun JDK 1.6",
    :home "/usr/java/jdk1.6.0_20"}
   {:name "Oracle JDK 1.7",
    :home "/usr/java/jdk1.7.0-b147"}
   {:name "IBM JDK 5",
    :home "/usr/java/ibm-java2-x86_64-50"}
   {:name "OpenJDK 1.6",
    :home "/usr/java/java-1.6.0-openjdk-1.6.0.0.x86_64"}
   {:name "JRockit 1.5",
    :home "/usr/java/jrockit-jdk1.5.0_28-R28.1.3-4.0.1"}
   {:name "JRockit 1.6",
    :home "/usr/java/jrockit-jdk1.6.0_24-R28.1.3-4.0.1"}])

(defn remove-jrockit [coll]
  (remove #(re-find #"(?i)jrockit" (:name %)) coll))

(defn active-jdks []
  (remove-jrockit (jdks)))

(defn jdk-names []
  (map :name (active-jdks)))

(defn default-jdk [] (first (jdk-names)))

(defn active-clojures []
  ["1.2.0" "1.2.1" "1.3.0-RC0"])

(defn contrib-libs-url []
  (io/resource "libs.clj"))

(defn contrib-libs []
  (with-open [r (java.io.PushbackReader. (io/reader (contrib-libs-url)))]
    (read r)))

(defn template [name]
  (ST. (slurp (io/resource (str "templates/" name ".st")))
       \$ \$))

(defn prepare-template-arg [x]
  (cond 
   (string? x) x
   (symbol? x) (name x)
   (keyword? x) (name x)
   (map? x) (reduce (fn [m [k v]]
                      (assoc m
                        (prepare-template-arg k)
                        (prepare-template-arg v)))
                    {} x)
   (sequential? x) (vec (map prepare-template-arg x))
   :else (str x)))

(defn render-template [tname args]
  (let [t (template tname)]
    (doseq [[k v] args]
      (.add t (name k) (prepare-template-arg v)))
    (.render t)))

(defn libs-and-matrix-jobs []
  (interleave (map :name (contrib-libs))
              (map #(str (:name %) "-test-matrix") (contrib-libs))))

(defn release-job-defaults []
  {:jdk (default-jdk)})

(defn release-job-config [lib]
  (render-template "release_job"
                   (merge (release-job-defaults) lib)))

(defn matrix-job-defaults []
  {:jdks (jdk-names)
   :clojures (active-clojures)})

(defn matrix-job-config [lib]
  (render-template "matrix_job"
                   (merge (matrix-job-defaults) lib)))

(defn write-release-job [lib]
  (.mkdirs (job-dir (:name lib)))
  (spit (job-config-file (:name lib))
        (release-job-config lib)))

(defn write-matrix-job [lib]
  (let [jobname (str (:name lib) "-test-matrix")]
    (.mkdirs (job-dir jobname))
    (spit (job-config-file jobname)
          (matrix-job-config lib))))

(defn rebuild-libs-config []
  (render-template "rebuild_all_libs_job"
   {:libs (map :name (contrib-libs))}))

(defn write-rebuild-libs-job []
  (let [jobfile (job-config-file "rebuild-all-libraries")]
    (io/make-parents jobfile)
    (spit jobfile (rebuild-libs-config))))

(defn write-job-files []
  (doseq [lib (contrib-libs)]
    (write-release-job lib)
    (write-matrix-job lib)))

(defn ci-config []
  (render-template "ci_config"
                   {:libs (libs-and-matrix-jobs)
                    :jdks (jdks)}))

(defn write-ci-config []
  (io/make-parents (ci-config-file))
  (spit (ci-config-file) (ci-config)))

(defn -main []
  (write-job-files)
  (write-rebuild-libs-job)
  (write-ci-config))

;; Local Variables:
;; eval: (setq inferior-lisp-program (concat default-directory "../../../../../script/repl.sh"))
;; End:
