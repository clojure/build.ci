#!/bin/sh

cd `dirname $0`/../../..

rm -rf ./jenkins
java -cp ".:generator/src/main/clojure:generator/src/main/resources:generator/target/dependency/*" clojure.main -m clojure.build.ci.generator
