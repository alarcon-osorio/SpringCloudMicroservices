FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY target/security-backend-0.0.1-SNAPSHOT.jar security-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8099
CMD [ "java", "-jar", "security-backend-0.0.1-SNAPSHOT.jar" ]