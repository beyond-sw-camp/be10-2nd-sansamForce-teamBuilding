# Step 1: Base image
FROM openjdk:17-jdk-slim
WORKDIR /workspace/app

# Step 2: Copy the built JAR into the Docker container
COPY build/libs/team-service-0.0.1-SNAPSHOT.jar team-service.jar
COPY ./src/main/resources/application.yml /workspace/app

# Step 3: Run the application
ENTRYPOINT ["java", "-jar", "team-service.jar", "—spring.config.location=file:/workspace/app/application.yml"]