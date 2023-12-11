FROM maven:3.8-openjdk-17-slim AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

# RUN apt-get update && apt-get install -y maven

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/payment-service-1.0-SNAPSHOT.jar /payment-service.jar

ENTRYPOINT ["java", "-jar", "/payment-service.jar"]
