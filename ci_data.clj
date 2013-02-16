;;; ci_data.clj

;; This is the configuration file for clojure.build.ci.generator.

{
 ;; The versions of Clojure against which we will test
 ;; contrib libraries
 :clojure-versions
 ["1.2.0" "1.2.1" "1.3.0" "1.4.0" "1.5.0-master-SNAPSHOT"]

 ;; Installed Java versions. If :enabled is true we will test contrib
 ;; libraries with that Java version.
 :jdks
 [{:name "Sun JDK 1.5"
   :enabled true
   :home "/var/lib/hudson/tools/Sun_JDK_1.5.0_22"
   :jdk-version "1.5"}
  {:name "Sun JDK 1.6"
   :enabled true
   :home "/usr/java/jdk1.6.0_20"
   :jdk-version "1.6"}
  {:name "Oracle JDK 1.7"
   :enabled true
   :home "/usr/java/jdk1.7.0-b147"
   :jdk-version "1.7"}
  {:name "IBM JDK 1.5"
   :enabled true
   :home "/usr/java/ibm-java2-x86_64-50"
   :jdk-version "1.5"}
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
   :home "/usr/java/java-1.6.0-openjdk-1.6.0.0.x86_64"
   :jdk-version "1.6"}
  ;; Some Clojure language tests fail on JRockit
  {:name "JRockit 1.5"
   :enabled false
   :home "/usr/java/jrockit-jdk1.5.0_28-R28.1.3-4.0.1"
   :jdk-version "1.5"}
  {:name "JRockit 1.6"
   :enabled false
   :home "/usr/java/jrockit-jdk1.6.0_24-R28.1.3-4.0.1"
   :jdk-version "1.6"}]

 ;; The contrib libraries. :owners are Hudson usernames of people with
 ;; permission to build and release each library.
 :contribs
 [{:name "algo.monads"        :owners ["konradhinsen"]}
  {:name "algo.generic"       :owners ["konradhinsen"]}
  {:name "core.incubator"     :owners []}
  {:name "core.logic"         :owners ["davidnolen"] :min-clojure "1.3.0"}
  {:name "core.match"         :owners ["davidnolen"] :min-clojure "1.3.0"}
  {:name "core.unify"         :owners ["fogus"]}
  {:name "core.memoize"       :owners ["fogus"]}
  {:name "core.cache"         :owners ["fogus"]}
  {:name "core.contracts"     :owners ["fogus"]}
  {:name "data.codec"         :owners ["ataggart"] :min-clojure "1.3.0"}
  {:name "data.csv"           :owners ["jonasenlund"]}
  {:name "data.finger-tree"   :owners ["Chouser"] :min-clojure "1.2.1"}
  {:name "data.generators"    :owners ["stuart.halloway"]}
  {:name "data.json"          :owners ["stuartsierra"] :min-clojure "1.3.0"}
  {:name "data.priority-map"  :owners ["markengelberg" "seancorfield"]}
  {:name "data.xml"           :owners ["ryansenior"] :exclude-jdk #{"Sun JDK 1.5" "IBM JDK 1.5" "IBM JDK 1.6"}}
  {:name "data.zip"           :owners []}
  {:name "java.classpath"     :owners ["stuartsierra"]}
  {:name "java.data"          :owners ["cosminstejerean"]}
  {:name "java.jdbc"          :owners ["seancorfield"]}
  {:name "java.jmx"           :owners ["nickbailey"]}
  {:name "math.combinatorics" :owners ["markengelberg" "seancorfield"]}
  {:name "math.numeric-tower" :owners ["markengelberg" "seancorfield"]}
  {:name "test.generative"    :owners ["stuart.halloway"]}
  {:name "tools.cli"          :owners ["garethjones"]}
  {:name "tools.logging"      :owners ["ataggart"]}
  {:name "tools.macro"        :owners ["konradhinsen"]}
  {:name "tools.namespace"    :owners ["stuartsierra"] :min-clojure "1.3.0"}
  {:name "tools.nrepl"        :owners ["cemerick"]}
  {:name "tools.reader"       :owners ["nicolamometto"]}
  {:name "tools.trace"        :owners ["lucprefontaine"]}]}
