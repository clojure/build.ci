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

(defn jdk-names []
  (vec (dzx/xml-> (ci-config-zipper) :jdks :jdk :name dzx/text)))

(defn default-jdk [] (first (jdk-names)))

(defn active-clojures []
  ["1.2.0" "1.2.1" "1.3.0-beta2"])

(defn contrib-libs-file []
  (io/file "projects.txt"))

(defn contrib-libs []
  (with-open [r (io/reader (contrib-libs-file))]
    (doall (map #(second (.split % "/")) (line-seq r)))))

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

(defn release-job-config [lib]
  (render-template "release_job"
                   {:name lib
                    :jdk (default-jdk)}))

(defn matrix-job-config [lib]
  (render-template "matrix_job"
                   {:name lib
                    :jdks (jdk-names)
                    :clojures (active-clojures)}))

(defn write-release-job [lib]
  (.mkdirs (job-dir lib))
  (spit (job-config-file lib)
        (release-job-config lib)))

(defn write-matrix-job [lib]
  (let [jobname (str lib "-test-matrix")]
    (.mkdirs (job-dir jobname))
    (spit (job-config-file jobname)
          (matrix-job-config lib))))

(defn write-job-files []
  (doseq [lib (contrib-libs)]
    (write-release-job lib)
    (write-matrix-job lib)))

;; Local Variables:
;; eval: (setq inferior-lisp-program (concat default-directory "../../../../../script/repl.sh"))
;; End:
