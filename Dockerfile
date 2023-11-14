# Use a base image with OpenJDK for running the application
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

COPY target/spring-backend-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8080 (assuming your Spring Boot app runs on this port)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]