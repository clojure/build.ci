;;; ci_data.clj

;; This is the configuration file for clojure.build.ci.generator.

{
 ;; The versions of Clojure against which we will test
 ;; contrib libraries
 :clojure-versions
 ["1.2.0" "1.2.1" "1.3.0" "1.4.0" "1.5.1" "1.6.0" "1.7.0" "1.8.0" "1.9.0" "1.10.0-alpha5" "1.10.0-master-SNAPSHOT"]

 ;; Installed Java versions. If :enabled is true we will test contrib
 ;; libraries with that Java version.
 :jdks
 [{:name "Sun JDK 1.6"
   :enabled false
   :home "/usr/java/jdk1.6.0_20"
   :jdk-version "1.6"}
  {:name "Oracle JDK 1.7"
   :enabled false
   :home "/usr/java/jdk1.7.0-b147"
   :jdk-version "1.7"}
  {:name "Oracle JDK 1.8"
   :enabled true
   :home "/usr/java/jdk1.8.0_111"
   :jdk-version "1.8"}
  {:name "IBM JDK 1.6"
   :enabled false
   :home "/usr/java/ibm-java-x86_64-sdk-6.0-9.2"
   :jdk-version "1.6"}
  {:name "IBM JDK 1.7"
   :enabled false
   :home "/usr/java/ibm-java-x86_64-sdk-7.0-0.0"
   :jdk-version "1.7"}
  {:name "Open JDK 9 with Eclipse Open J9"
   :enabled false
   :home "/usr/lib/jvm/jdk-9+181"
   :jdk-version "1.9"}
  {:name "OpenJDK 1.6"
   :enabled false
   :home "/usr/lib/jvm/java-1.6.0-openjdk-1.6.0.40.x86_64"
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
  {:name "core.async"         :owners ["alexmiller","stuart.halloway"] :min-clojure "1.7.0"}
  {:name "core.incubator"     :owners []}
  {:name "core.logic"         :owners ["davidnolen"] :min-clojure "1.3.0"}
  {:name "core.match"         :owners ["davidnolen"] :min-clojure "1.4.0"}
  {:name "core.unify"         :owners ["fogus"]}
  {:name "core.memoize"       :owners ["seancorfield"] :min-clojure "1.6.0"}
  {:name "core.cache"         :owners ["seancorfield"] :min-clojure "1.6.0"}
  {:name "core.contracts"     :owners ["fogus"]}
  {:name "core.rrb-vector"    :owners ["michalmarczyk"] :min-clojure "1.5.1"}
  {:name "core.specs.alpha"   :owners ["alexmiller"] :min-clojure "1.9.0"}
  {:name "core.typed"         :owners ["ambrosebs"] :min-clojure "1.6.0"}
  {:name "data.avl"           :owners ["michalmarczyk"] :min-clojure "1.5.1"}
  {:name "data.codec"         :owners ["ataggart"] :min-clojure "1.7.0"}
  {:name "data.csv"           :owners ["jonasenlund"]}
  {:name "data.finger-tree"   :owners ["Chouser"] :min-clojure "1.4.0"}
  {:name "data.fressian"      :owners ["stuart.halloway"] :min-clojure "1.5.1"}
  {:name "data.generators"    :owners ["stuart.halloway"] :min-clojure "1.4.0"}
  {:name "data.int-map"       :owners ["ztellman"] :min-clojure "1.6.0"}
  {:name "data.json"          :owners ["stuartsierra"] :min-clojure "1.3.0"}
  {:name "data.priority-map"  :owners ["markengelberg" "seancorfield"] :min-clojure "1.5.1"}
  {:name "data.xml"           :owners ["ryansenior" "hhochleitner"] :min-clojure "1.7.0"}
  {:name "data.zip"           :owners []}
  {:name "java.classpath"     :owners ["stuartsierra"] :exclude-jdk #{"Open JDK 9 with Eclipse Open J9"}}
  {:name "java.data"          :owners ["cosminstejerean"]}
  {:name "java.jdbc"          :owners ["seancorfield"] :min-clojure "1.7.0"}
  {:name "java.jmx"           :owners ["nickbailey"] :min-clojure "1.4.0"}
  {:name "jvm.tools.analyzer" :owners ["ambrosebs"]}
  {:name "math.combinatorics" :owners ["markengelberg" "seancorfield"]}
  {:name "math.numeric-tower" :owners ["markengelberg" "seancorfield"]}
  {:name "spec.alpha"         :owners ["alexmiller"] :min-clojure "1.9.0"}
  {:name "test.check"         :owners ["gfredericks"] :min-clojure "1.7.0"}
  {:name "test.generative"    :owners ["stuart.halloway"] :min-clojure "1.4.0"}
  {:name "tools.analyzer"     :owners ["nicolamometto"] :min-clojure "1.5.1"}
  {:name "tools.analyzer.jvm" :owners ["nicolamometto"] :min-clojure "1.5.1"}
  {:name "tools.emitter.jvm"  :owners ["nicolamometto"] :min-clojure "1.5.1"}
  {:name "tools.cli"          :owners ["garethjones" "sungpae" "seancorfield"]}
  {:name "tools.deps.alpha"   :owners ["puredanger"] :min-clojure "1.8.0"}
  {:name "tools.gitlibs"      :owners ["puredanger"] :min-clojure "1.8.0"}
  {:name "tools.logging"      :owners ["ataggart"] :min-clojure "1.3.0"}
  {:name "tools.macro"        :owners ["konradhinsen"]}
  {:name "tools.namespace"    :owners ["stuartsierra"] :min-clojure "1.7.0"}
;;  {:name "tools.nrepl"        :owners ["cemerick" "trptcolin"] :min-clojure "1.2.1"}
  {:name "tools.reader"       :owners ["nicolamometto"] :min-clojure "1.5.1"}
  {:name "tools.trace"        :owners ["lucprefontaine"]}]}
