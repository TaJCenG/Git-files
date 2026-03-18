# Use OpenJDK 17 runtime
FROM openjdk:17-jdk-alpine

# Add a volume to store logs (optional)
VOLUME /tmp

# Copy the packaged jar file into the container at /app/app.jar
COPY target/task-management-app.jar /app/app.jar

# Expose port 8080 for the Spring Boot app
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
