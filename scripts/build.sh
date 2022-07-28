#!/bin/bash

set -e

../rubber-duck-server/build_image.sh
../jmeter-cluster/build_image.sh
