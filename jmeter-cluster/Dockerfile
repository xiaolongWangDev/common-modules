FROM ubuntu:focal

ARG JMETER_VERSION="5.5"
ENV JMETER_HOME /opt/apache-jmeter-${JMETER_VERSION}
ENV	JMETER_DOWNLOAD_URL https://archive.apache.org/dist/jmeter/binaries/apache-jmeter-${JMETER_VERSION}.tgz

RUN apt-get -y update \
    && apt-get install -y openjdk-17-jre curl tar gzip \
    && mkdir -p /opt \
    && curl -L --silent ${JMETER_DOWNLOAD_URL} >  /opt/apache-jmeter-${JMETER_VERSION}.tgz  \
	&& tar -xzf /opt/apache-jmeter-${JMETER_VERSION}.tgz -C /opt  \
	&& rm -rf /opt/apache-jmeter-${JMETER_VERSION}.tgz

COPY entrypoint.sh ${JMETER_HOME}/bin/

ENV PATH ${PATH}:${JMETER_HOME}/bin

WORKDIR	${JMETER_HOME}

ENTRYPOINT ["entrypoint.sh"]

