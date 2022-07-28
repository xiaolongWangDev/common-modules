FROM eclipse-temurin:17.0.3_7-jre-jammy

ARG DUCK_HOME="/opt/rubberduck"

RUN mkdir -p ${DUCK_HOME}/bin

COPY rubber-duck-server.jar ${DUCK_HOME}/rubber-duck.jar
COPY entrypoint.sh ${DUCK_HOME}/bin

WORKDIR	${DUCK_HOME}

ENV PATH $PATH:${DUCK_HOME}/bin

ENTRYPOINT ["entrypoint.sh"]

