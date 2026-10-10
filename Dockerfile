
# Build the Spring Boot application using Java 21
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy the backend source code
COPY . .

# Build the application
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Run the application using Java 21
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Start Spring Boot
CMD ["java", "-jar", "app.jar"]
