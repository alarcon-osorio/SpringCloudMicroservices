FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY target/mediapp-consults-0.0.1-SNAPSHOT.jar mediapp-consults-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD [ "java", "-jar", "mediapp-consults-0.0.1-SNAPSHOT.jar" ]