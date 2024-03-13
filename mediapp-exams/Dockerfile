FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY target/mediapp-exams-0.0.1-SNAPSHOT.jar mediapp-exams-0.0.1-SNAPSHOT.jar
EXPOSE 8091
CMD [ "java", "-jar", "mediapp-exams-0.0.1-SNAPSHOT.jar" ]