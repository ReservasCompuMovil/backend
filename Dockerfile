FROM maven:3.8.5-openjdk-17 AS build
COPY . .
ARG MAVEN_PROFILE=prod
RUN mvn clean package -P ${MAVEN_PROFILE} -DskipTests
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]