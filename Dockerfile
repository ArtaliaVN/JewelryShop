FROM openjdk:25-ea-21-jdk-slim

VOLUME /tmp

COPY target/jewelryServerApp.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

