(ns clojure.build.ci.generator
  (:use [clojure.java.io :only (file resource)])
  (:require [clojure.xml :as xml]
            [clojure.zip :as zip]
            [clojure.data.zip.xml :as dzx])
  (:import (org.stringtemplate.v4 ST)))

(defn ci-root [] (file "hudson"))

(defn jobs-root [] (file (ci-root) "jobs"))

(defn job-dir [jname] (file (jobs-root) jname))

(defn job-config-file [jname] (file (job-dir jname) "config.xml"))

(defn ci-config [] (file (ci-root) "config.xml"))

(defn ci-config-zipper [] (zip/xml-zip (xml/parse (ci-config))))

(defn jdk-names [xml-zipper]
  (dzx/xml-> xml-zipper :jdks :jdk :name dzx/text))

(defn default-jdk [] (first (jdk-names (ci-config-zipper))))

(defn active-clojures []
  ["1.2.0" "1.2.1" "1.3.0-beta2"])

(defn contrib-libs []
  ["data.json"])

(defn template [name]
  (ST. (slurp (resource (str "templates/" name ".st")))
       \$ \$))

(defn render-template [tname args]
  (let [t (template tname)]
    (doseq [[k v] args]
      (.add t (name k) (str v)))
    (.render t)))

(defn release-job-config [lib]
  (render-template "release_job"
                   {:name lib
                    :jdk (default-jdk)}))

(defn write-job-files []
  (doseq [lib (contrib-libs)]
    (.mkdirs (job-dir lib))
    (spit (job-config-file lib)
          (release-job-config lib))))

;; Local Variables:
;; eval: (setq inferior-lisp-program (concat default-directory "../../../../../script/repl.sh"))
;; End:
