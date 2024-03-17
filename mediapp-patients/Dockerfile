FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY target/mediapp-patients-0.0.1-SNAPSHOT.jar mediapp-patients-0.0.1-SNAPSHOT.jar
EXPOSE 8093
CMD [ "java", "-jar", "mediapp-patients-0.0.1-SNAPSHOT.jar" ]