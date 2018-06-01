#!/bin/bash
set -e -u

#
#
#

base=$(cd ${BASH_SOURCE%/*}/.. && pwd)
path="$base/jar/KetonixUSB-20170310.jar"

cd $base

main="java -jar $path"

$main
