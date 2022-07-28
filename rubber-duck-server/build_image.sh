#!/bin/bash

set -e
cd "$(dirname "$0")"
mvn -Dmaven.test.skip=true clean package
yes | cp -rf target/rubber-duck-server-*-SNAPSHOT.jar rubber-duck-server.jar
docker build -t rubber-duck .
rm -rf rubber-duck-server.jar
