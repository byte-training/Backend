FROM openjdk:8u181-alpine

MAINTAINER Jose Gomez

ADD target/demo-microservice-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT exec java -jar app.jar