#!/bin/bash
set -e

echo "START Running Jmeter on `date`"
# Keep entrypoint simple: we must pass the standard JMeter arguments
EXTRA_ARGS="-Dlog4j2.formatMsgNoLookups=true -Jclient.rmi.localport=7000 -Jserver.rmi.ssl.disable=true"
echo "jmeter ALL ARGS=${EXTRA_ARGS} $@"
jmeter ${EXTRA_ARGS} $@
echo "END Running Jmeter on `date`"