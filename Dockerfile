
FROM maven:latest
WORKDIR /app
COPY pom.xml /app
COPY . /app
ENTRYPOINT ["java", "-jar", "target/week7_inclass.jar"]
CMD ["java", "-jar", "target/week7_inclass.jar"]