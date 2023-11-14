# Use a base image with OpenJDK for running the application
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Define a build argument to receive the JAR file name during build time
ARG JAR_FILE

# Copy the dynamically detected JAR file into the container
COPY ${JAR_FILE} /app/app.jar

# Expose port 8080 (assuming your Spring Boot app runs on this port)
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]