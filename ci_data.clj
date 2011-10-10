;;; ci_data.clj

;; This is the configuration file for clojure.build.ci.generator.

{
 ;; The versions of Clojure against which we will test
 ;; contrib libraries
 :clojure-versions
 ["1.2.0" "1.2.1" "1.3.0" "1.4.0-master-SNAPSHOT"]

 ;; Installed Java versions. If :enabled is true we will test contrib
 ;; libraries with that Java version.
 :jdks
 [{:name "Sun JDK 1.5"
   :enabled true
   :home "/var/lib/hudson/tools/Sun_JDK_1.5.0_22"}
  {:name "Sun JDK 1.6"
   :enabled true
   :home "/usr/java/jdk1.6.0_20"}
  {:name "Oracle JDK 1.7"
   :enabled true
   :home "/usr/java/jdk1.7.0-b147"}
  {:name "IBM JDK 1.5"
   :enabled true
   :home "/usr/java/ibm-java2-x86_64-50"}
  {:name "IBM JDK 1.6"
   :enabled true
   :home "/usr/java/ibm-java-x86_64-sdk-6.0-9.2"}
  {:name "IBM JDK 1.7"
   :enabled false
   :home "/usr/java/ibm-java-x86_64-sdk-7.0-0.0"}
  {:name "OpenJDK 1.6"
   :enabled true
   :home "/usr/java/java-1.6.0-openjdk-1.6.0.0.x86_64"}
  ;; Some Clojure language tests fail on JRockit
  {:name "JRockit 1.5"
   :enabled false
   :home "/usr/java/jrockit-jdk1.5.0_28-R28.1.3-4.0.1"}
  {:name "JRockit 1.6"
   :enabled false
   :home "/usr/java/jrockit-jdk1.6.0_24-R28.1.3-4.0.1"}]

 ;; The contrib libraries. :owners are Hudson usernames of people with
 ;; permission to build and release each library.
 :contribs
 [{:name "algo.monads"
   :owners ["konradhinsen"]}
  {:name "algo.generic"
   :owners ["konradhinsen"]}
  {:name "core.incubator"
   :owners []}
  {:name "core.logic"
   :owners ["davidnolen"]}
  {:name "core.match"
   :owners ["davidnolen"]}
  {:name "core.unify"
   :owners []}
  {:name "data.csv"
   :owners []}
  {:name "data.finger-tree"
   :owners ["Chouser"]}
  {:name "data.json"
   :owners ["stuartsierra"]}
  {:name "data.priority-map"
   :owners ["markengelberg" "seancorfield"]}
  {:name "data.xml"
   :owners []}
  {:name "data.zip"
   :owners []}
  {:name "java.classpath"
   :owners []}
  {:name "java.data"
   :owners ["cosminstejerean"]}
  {:name "java.jdbc"
   :owners ["seancorfield"]}
  {:name "java.jmx"
   :owners []}
  {:name "math.combinatorics"
   :owners ["markengelberg" "seancorfield"]}
  {:name "math.numeric-tower"
   :owners ["markengelberg" "seancorfield"]}
  {:name "test.generative"
   :owners []}
  {:name "tools.cli"
   :owners ["garethjones"]}
  {:name "tools.logging"
   :owners []}
  {:name "tools.macro"
   :owners ["konradhinsen"]}
  {:name "tools.namespace"
   :owners []}
  {:name "tools.nrepl"
   :owners []}
  {:name "tools.trace"
   :owners ["lucprefontaine"]}]}
