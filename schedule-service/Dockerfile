FROM openjdk:17-jdk-slim AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

COPY --from=build /app/target/ticket-service-1.0-SNAPSHOT.jar /ticket-service.jar

ENTRYPOINT ["java", "-jar", "/ticket-service.jar"]
