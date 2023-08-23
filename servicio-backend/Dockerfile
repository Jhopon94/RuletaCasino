FROM openjdk:19-jdk-alpine
MAINTAINER baeldung.com
COPY target/ruletaPCABackend-0.0.1-SNAPSHOT.war servicio.war
ENTRYPOINT ["java","-jar","/servicio.war"]