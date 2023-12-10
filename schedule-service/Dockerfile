FROM openjdk:17-jdk-slim AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN apt-get update && apt-get install -y maven

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/ticket-service-1.0-SNAPSHOT.jar /ticket-service.jar

ENTRYPOINT ["java", "-jar", "/ticket-service.jar"]
