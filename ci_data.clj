;;; ci_data.clj

;; This is the configuration file for clojure.build.ci.generator.

{
 ;; The versions of Clojure against which we will test
 ;; contrib libraries
 :clojure-versions
 ["1.2.0" "1.2.1" "1.3.0" "1.4.0" "1.5.1" "1.6.0" "1.7.0" "1.8.0" "1.9.0-alpha9" "1.9.0-master-SNAPSHOT"]

 ;; Installed Java versions. If :enabled is true we will test contrib
 ;; libraries with that Java version.
 :jdks
 [{:name "Sun JDK 1.6"
   :enabled true
   :home "/usr/java/jdk1.6.0_20"
   :jdk-version "1.6"}
  {:name "Oracle JDK 1.7"
   :enabled true
   :home "/usr/java/jdk1.7.0-b147"
   :jdk-version "1.7"}
  {:name "Oracle JDK 1.8"
   :enabled true
   :home "/usr/java/jdk1.8.0_05"
   :jdk-version "1.8"}
  {:name "IBM JDK 1.6"
   :enabled true
   :home "/usr/java/ibm-java-x86_64-sdk-6.0-9.2"
   :jdk-version "1.6"}
  {:name "IBM JDK 1.7"
   :enabled false
   :home "/usr/java/ibm-java-x86_64-sdk-7.0-0.0"
   :jdk-version "1.7"}
  {:name "OpenJDK 1.6"
   :enabled true
   :home "/usr/lib/jvm/java-1.6.0-openjdk.x86_64"
   :jdk-version "1.6"}
  ;; Some Clojure language tests fail on JRockit
  {:name "JRockit 1.6"
   :enabled false
   :home "/usr/java/jrockit-jdk1.6.0_24-R28.1.3-4.0.1"
   :jdk-version "1.6"}]

 ;; The contrib libraries. :owners are Hudson usernames of people with
 ;; permission to build and release each library.
 :contribs
 [{:name "algo.monads"        :owners ["konradhinsen"]}
  {:name "algo.generic"       :owners ["konradhinsen"] :min-clojure "1.3.0"}
  {:name "algo.graph"         :owners ["halgari"]}
  {:name "core.incubator"     :owners []}
  {:name "core.logic"         :owners ["davidnolen"] :min-clojure "1.3.0"}
  {:name "core.match"         :owners ["davidnolen"] :min-clojure "1.4.0"}
  {:name "core.unify"         :owners ["fogus"]}
  {:name "core.memoize"       :owners ["fogus"] :min-clojure "1.3.0"}
  {:name "core.cache"         :owners ["fogus" "ambrosebs"] :min-clojure "1.3.0"}
  {:name "core.contracts"     :owners ["fogus"]}
  {:name "core.rrb-vector"    :owners ["michalmarczyk"] :min-clojure "1.5.1"}
  {:name "core.typed"         :owners ["ambrosebs"] :min-clojure "1.6.0" :exclude-jdk #{"Sun JDK 1.6" "IBM JDK 1.6" "OpenJDK 1.6"}
                              :jdk-version "1.7"}
  {:name "data.avl"           :owners ["michalmarczyk"] :min-clojure "1.5.1"}
  {:name "data.codec"         :owners ["ataggart"] :min-clojure "1.3.0"}
  {:name "data.csv"           :owners ["jonasenlund"]}
  {:name "data.finger-tree"   :owners ["Chouser"] :min-clojure "1.4.0"}
  {:name "data.fressian"      :owners ["stuart.halloway"] :min-clojure "1.5.1"}
  {:name "data.generators"    :owners ["stuart.halloway"] :min-clojure "1.4.0"}
  {:name "data.int-map"       :owners ["ztellman"] :min-clojure "1.6.0" :exclude-jdk #{"Sun JDK 1.6" "IBM JDK 1.6" "OpenJDK 1.6"}}
  {:name "data.json"          :owners ["stuartsierra"] :min-clojure "1.3.0"}
  {:name "data.priority-map"  :owners ["markengelberg" "seancorfield"]}
  {:name "data.xml"           :owners ["ryansenior"] :min-clojure "1.4.0" :exclude-jdk #{"IBM JDK 1.6"}}
  {:name "data.zip"           :owners []}
  {:name "java.classpath"     :owners ["stuartsierra"]}
  {:name "java.data"          :owners ["cosminstejerean"]}
  {:name "java.jdbc"          :owners ["seancorfield"] :min-clojure "1.4.0"}
  {:name "java.jmx"           :owners ["nickbailey"] :min-clojure "1.2.1"}
  {:name "jvm.tools.analyzer" :owners ["ambrosebs"]}
  {:name "math.combinatorics" :owners ["markengelberg" "seancorfield"]}
  {:name "math.numeric-tower" :owners ["markengelberg" "seancorfield"]}
  {:name "test.check"         :owners ["reiddraper" "gfredericks"] :min-clojure "1.7.0"}
  {:name "test.generative"    :owners ["stuart.halloway"] :min-clojure "1.4.0"}
  {:name "tools.analyzer"     :owners ["nicolamometto"] :min-clojure "1.5.1"}
  {:name "tools.analyzer.js"  :owners ["nicolamometto"] :min-clojure "1.6.0"}
  {:name "tools.analyzer.jvm" :owners ["nicolamometto"] :min-clojure "1.5.1"}
  {:name "tools.emitter.jvm"  :owners ["nicolamometto"] :min-clojure "1.5.1"}
  {:name "tools.cli"          :owners ["garethjones" "sungpae" "seancorfield"]}
  {:name "tools.logging"      :owners ["ataggart"] :min-clojure "1.3.0"}
  {:name "tools.macro"        :owners ["konradhinsen"]}
  {:name "tools.namespace"    :owners ["stuartsierra"] :min-clojure "1.7.0"}
  {:name "tools.nrepl"        :owners ["cemerick" "trptcolin"] :min-clojure "1.2.1"}
  {:name "tools.reader"       :owners ["nicolamometto"] :min-clojure "1.5.0"}
  {:name "tools.trace"        :owners ["lucprefontaine"]}]}
