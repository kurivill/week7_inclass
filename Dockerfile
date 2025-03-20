
FROM maven:latest
WORKDIR /app
COPY pom.xml /app
COPY . /app
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
CMD []