(ns clojure.build.ci.generator
  (:require [clojure.java.io :as io]
            [clojure.xml :as xml]
            [clojure.zip :as zip]
            [clojure.data.zip.xml :as dzx])
  (:import (org.stringtemplate.v4 ST)))

(defn ci-root [] (io/file "hudson"))

(defn jobs-root [] (io/file (ci-root) "jobs"))

(defn job-dir [jname] (io/file (jobs-root) jname))

(defn job-config-file [jname] (io/file (job-dir jname) "config.xml"))

(defn ci-config [] (io/file (ci-root) "config.xml"))

(defn ci-config-zipper [] (zip/xml-zip (xml/parse (ci-config))))

(defn remove-jrockit [coll]
  (remove #(re-find #"(?i)jrockit" %) coll))

(defn jdk-names []
  (vec (remove-jrockit
        (dzx/xml-> (ci-config-zipper)
                   :jdks :jdk :name dzx/text))))

(defn default-jdk [] (first (jdk-names)))

(defn active-clojures []
  ["1.2.0" "1.2.1" "1.3.0-beta2"])

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
   (map? x) (reduce (fn [m [k v]]
                      (assoc m
                        (prepare-template-arg k)
                        (prepare-template-arg v)))
                    x)
   (sequential? x) (vec (map prepare-template-arg x))
   :else (str x)))

(defn render-template [tname args]
  (let [t (template tname)]
    (doseq [[k v] args]
      (.add t (name k) (prepare-template-arg v)))
    (.render t)))

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

(defn write-job-files []
  (doseq [lib (contrib-libs)]
    (write-release-job lib)
    (write-matrix-job lib)))

(defn -main []
  (write-job-files))

;; Local Variables:
;; eval: (setq inferior-lisp-program (concat default-directory "../../../../../script/repl.sh"))
;; End:
