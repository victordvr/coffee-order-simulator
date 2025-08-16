# Stage 1: Build the project using Maven 3.9.9 and Java 17
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create a runtime lighter image with only the JAR
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/coffee-order-simulator-1.0-SNAPSHOT.jar app.jar

# Automatically run the interactive Java app when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]