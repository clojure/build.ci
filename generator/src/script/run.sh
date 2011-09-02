#!/bin/sh

cd `dirname $0`/../..

mvn -q clean dependency:copy-dependencies
cd ..
rm -rf ./hudson/jobs
java -cp "generator/src/main/clojure:generator/src/main/resources:generator/target/dependency/*" clojure.main -m clojure.build.ci.generator
