#!/bin/sh

cd `dirname $0`/../../..

exec java -cp ".:generator/src/main/clojure:generator/src/main/resources:generator/target/dependency/*" clojure.main
