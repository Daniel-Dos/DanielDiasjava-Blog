FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.2.9_openj9-0.12.1-alpine-slim 

COPY /target/vertx-sample.jar /opt/vertx-sample.jar
COPY /target/libs /opt/libs

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/vertx-sample.jar"]
