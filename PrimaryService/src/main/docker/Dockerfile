FROM openjdk:8-jdk-alpine

VOLUME /tmp
ADD /maven/primary-service-1.0.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /${fileName}'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
