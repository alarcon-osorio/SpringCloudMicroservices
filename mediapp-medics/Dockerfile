FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY target/mediapp-medics-0.0.1-SNAPSHOT.jar mediapp-medics-0.0.1-SNAPSHOT.jar
EXPOSE 8092
CMD [ "java", "-jar", "mediapp-medics-0.0.1-SNAPSHOT.jar" ]