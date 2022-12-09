(ns clojure.build.ci.generator
  (:require [clojure.java.io :as io])
  (:import (org.stringtemplate.v4 ST)))

(defn input-data-url [] (io/resource "ci_data.clj"))

(defn input-data []
  (with-open [r (java.io.PushbackReader. (io/reader (input-data-url)))]
    (read r)))

(defn ci-root [] (io/file "jenkins"))

(defn jobs-root [] (io/file (ci-root) "jobs"))

(defn job-dir [jname] (io/file (jobs-root) jname))

(defn job-config-file [jname] (io/file (job-dir jname) "config.xml"))

(defn ci-config-file [] (io/file (ci-root) "config.xml"))

(defn jdks [] (:jdks (input-data)))

(defn active-jdks []
  (filter :enabled (jdks)))

(defn jdk-names []
  (map :name (active-jdks)))

(defn jdk-default-name [] (:jdk-default (input-data)))

(defn default-jdk [jdk-version]
  (if jdk-version
    (first (filter #(= jdk-version (:jdk-version %)) (active-jdks)))
    (first (filter #(= (jdk-default-name) (:name %)) (active-jdks)))))

(defn active-clojures []
  (:clojure-versions (input-data)))

(defn contrib-libs []
  (:contribs (input-data)))

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

(defn release-job-defaults [{:keys (jdk-version)}]
  {:jdk (:name (default-jdk jdk-version))
   :branch "master"})

(defn release-job-config [lib]
  (render-template "release_job"
                   (merge (release-job-defaults lib) lib)))

(defn matrix-job-defaults []
  {:jdks (jdk-names)
   :clojures (active-clojures)
   :branch "master"})

(defn update-min-clojure [lib]
  (if-let [version (:min-clojure lib)]
    (update-in lib [:clojures]
               (fn [versions] (drop-while #(not= version %) versions)))
    lib))

(defn update-exclude-jdk [lib]
  (if-let [exclusions (:exclude-jdk lib)]
    (update-in lib [:jdks]
               (fn [versions] (remove (set exclusions) versions)))
    lib))

(defn matrix-job-config [lib]
  (render-template "matrix_job"
                   (-> (matrix-job-defaults)
                       (merge lib)
                       (update-min-clojure)
                       (update-exclude-jdk))))

(defn write-release-job [lib]
  (println "Writing release job" (job-dir (:name lib)))
  (.mkdirs (job-dir (:name lib)))
  (spit (job-config-file (:name lib))
        (release-job-config lib)))

(defn write-matrix-job [lib]
  (println "Writing matrix job" (job-dir (:name lib)))
  (let [jobname (str (:name lib) "-test-matrix")]
    (.mkdirs (job-dir jobname))
    (spit (job-config-file jobname)
          (matrix-job-config lib))))

(defn rebuild-libs-config []
  (render-template "rebuild_all_libs_job"
   {:libs (map :name (contrib-libs))}))

(defn write-rebuild-libs-job []
  (println "Writing release-all-libraries job" (job-config-file "rebuild-all-libraries"))
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
  (println "Write config file" (ci-config-file))
  (io/make-parents (ci-config-file))
  (spit (ci-config-file) (ci-config)))

(defn -main []
  (write-job-files)
  (write-rebuild-libs-job)
  (write-ci-config))

;; Local Variables:
;; eval: (setq inferior-lisp-program (concat default-directory "../../../../../script/repl.sh"))
;; End:
