# Step 1: Base image
FROM openjdk:17-jdk-slim
WORKDIR /workspace/app

# Step 2: Copy the built JAR into the Docker container
COPY ./build/libs/api-gateway-0.0.1-SNAPSHOT.jar /workspace/app/api-gateway.jar
COPY ./src/main/resources/application.yml /workspace/app
# Step 3: Run the application
ENTRYPOINT ["java", "-jar", "api-gateway.jar", "—spring.config.location=file:/workspace/app/application.yml"]