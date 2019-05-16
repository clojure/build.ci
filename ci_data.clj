;;; ci_data.clj

;; This is the configuration file for clojure.build.ci.generator.

{
 ;; The versions of Clojure against which we will test
 ;; contrib libraries
 :clojure-versions
 ["1.6.0" "1.7.0" "1.8.0" "1.9.0" "1.10.0" "1.10.1-beta3" "1.11.0-master-SNAPSHOT"]
 ;; old versions: "1.2.0" "1.2.1" "1.3.0" "1.4.0" "1.5.1" 

 ;; Installed Java versions. If :enabled is true we will test contrib
 ;; libraries with that Java version.
 :jdks
 [{:name "Oracle JDK 1.7"
   :enabled false
   :home "/usr/java/jdk1.7.0-b147"
   :jdk-version "1.7"}
  {:name "IBM JDK 1.7"
   :enabled false
   :home "/usr/java/ibm-java-x86_64-sdk-7.0-0.0"
   :jdk-version "1.7"}
  {:name "Oracle JDK 1.8"
   :enabled true
   :home "/usr/java/jdk1.8.0_111"
   :jdk-version "1.8"}
  {:name "Oracle JDK 9"
   :enabled false
   :home "/opt/java/sdk/oracle/jdk-9.0.4"
   :jdk-version "1.9"}
  {:name "OpenJDK 9"
   :enabled false
   :home "/opt/java/sdk/openjdk/jdk-9.0.4"
   :jdk-version "1.9"}
  {:name "Open JDK 9 with Eclipse Open J9"
   :enabled false
   :home "/usr/lib/jvm/jdk-9+181"
   :jdk-version "1.10"}
    {:name "Oracle JDK 10"
   :enabled false
   :home "/opt/java/sdk/oracle/jdk-10.0.1"
   :jdk-version "1.10"}
  {:name "OpenJDK 10"
   :enabled false
   :home "/opt/java/sdk/openjdk/jdk-10.0.1"
   :jdk-version "1.10"}
  {:name "Oracle 11 EA"
   :enabled true
   :home "/opt/java/sdk/oracle/jdk-11"
   :jdk-version "11-ea"}
  {:name "OpenJDK 11 EA"
   :enabled true
   :home "/opt/java/sdk/openjdk/jdk-11"
   :jdk-version "11-ea"}]

 ;; The contrib libraries. :owners are Hudson usernames of people with
 ;; permission to build and release each library.
 :contribs
 [{:name "algo.monads"        :owners ["konradhinsen"]}
  {:name "algo.generic"       :owners ["konradhinsen"]}
  {:name "core.async"         :owners ["alexmiller","stuart.halloway"] :min-clojure "1.7.0"}
  {:name "core.logic"         :owners ["davidnolen"]}
  {:name "core.match"         :owners ["davidnolen"]}
  {:name "core.unify"         :owners ["fogus"]}
  {:name "core.memoize"       :owners ["seancorfield"]}
  {:name "core.cache"         :owners ["seancorfield"]}
  {:name "core.contracts"     :owners ["fogus"]}
  {:name "core.rrb-vector"    :owners ["michalmarczyk"]}
  {:name "core.specs.alpha"   :owners ["alexmiller"] :min-clojure "1.9.0"}
  {:name "core.typed"         :owners ["ambrosebs"] :min-clojure "1.9.0"}
  {:name "core.typed.runtime.jvm"   :owners ["ambrosebs"] :min-clojure "1.9.0"}
  {:name "core.typed.analyzer.jvm"  :owners ["ambrosebs"] :min-clojure "1.9.0"}
  {:name "core.typed.checker.jvm"   :owners ["ambrosebs"] :min-clojure "1.9.0"}
  {:name "core.typed.annotator.jvm" :owners ["ambrosebs"] :min-clojure "1.9.0"}
  {:name "data.avl"           :owners ["michalmarczyk"]}
  {:name "data.codec"         :owners ["ataggart"] :min-clojure "1.7.0"}
  {:name "data.csv"           :owners ["jonasenlund"]}
  {:name "data.finger-tree"   :owners ["Chouser"]}
  {:name "data.fressian"      :owners ["stuart.halloway"]}
  {:name "data.generators"    :owners ["stuart.halloway"]}
  {:name "data.int-map"       :owners ["ztellman"]}
  {:name "data.json"          :owners ["stuartsierra"]}
  {:name "data.priority-map"  :owners ["markengelberg" "seancorfield"]}
  {:name "data.xml"           :owners ["ryansenior" "hhochleitner"] :min-clojure "1.7.0"}
  {:name "data.zip"           :owners []}
  {:name "java.classpath"     :owners ["stuartsierra"]}
  {:name "java.data"          :owners ["cosminstejerean"]}
  {:name "java.jdbc"          :owners ["seancorfield"] :min-clojure "1.7.0"}
  {:name "java.jmx"           :owners ["nickbailey"]}
  {:name "jvm.tools.analyzer" :owners ["ambrosebs"]}
  {:name "math.combinatorics" :owners ["markengelberg" "seancorfield"] :min-clojure "1.7.0"}
  {:name "math.numeric-tower" :owners ["markengelberg" "seancorfield"]}
  {:name "spec.alpha"         :owners ["alexmiller"] :min-clojure "1.9.0"}
  {:name "spec-alpha2"        :owners ["alexmiller"] :min-clojure "1.10.0"}
  {:name "test.check"         :owners ["gfredericks"] :min-clojure "1.7.0"}
  {:name "test.generative"    :owners ["stuart.halloway"]}
  {:name "tools.analyzer"     :owners ["nicolamometto"]}
  {:name "tools.analyzer.jvm" :owners ["nicolamometto"]}
  {:name "tools.emitter.jvm"  :owners ["nicolamometto"]}
  {:name "tools.cli"          :owners ["garethjones" "sungpae" "seancorfield"] :min-clojure "1.8.0"}
  {:name "tools.deps.alpha"   :owners ["puredanger"] :min-clojure "1.9.0"}
  {:name "tools.gitlibs"      :owners ["puredanger"] :min-clojure "1.8.0"}
  {:name "tools.logging"      :owners ["ataggart"]}
  {:name "tools.macro"        :owners ["konradhinsen"]}
  {:name "tools.namespace"    :owners ["stuartsierra"] :min-clojure "1.7.0"}
  {:name "tools.reader"       :owners ["nicolamometto"]}
  {:name "tools.trace"        :owners ["lucprefontaine"]}]}
