# Use Amazon Corretto as the base image
FROM amazoncorretto:21

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]