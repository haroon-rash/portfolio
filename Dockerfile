# Build stage
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
ARG JAR_FILE=/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

# Create a non-root user for security
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

EXPOSE 4000
ENTRYPOINT ["java","-jar","app.jar"]
