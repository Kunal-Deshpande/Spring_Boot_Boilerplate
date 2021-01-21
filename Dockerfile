# Pull Adoptopenjdk 11 from Docker Hub
FROM adoptopenjdk:11.0.9_11-jre-hotspot

# Set Working Dir to app
WORKDIR /app

# Copy Jar to Image
COPY ./server/target/*.jar app.jar

EXPOSE 8080
EXPOSE 80

# Start Spring Boot Server
CMD ["java", "-jar", "/app.jar"]
