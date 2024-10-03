# Step 1: Base image
FROM openjdk:17-jdk-alpine

# Step 2: Copy the built JAR into the Docker container
COPY build/libs/user-service-0.0.1-SNAPSHOT.jar user.jar

# Step 3: Run the application
ENTRYPOINT ["java", "-jar", "/user.jar"]