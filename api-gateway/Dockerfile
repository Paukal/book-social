# Use Eclipse Temurin (or Azul/Zulu, Amazon Corretto, etc.) for a small JRE/JDK
FROM eclipse-temurin:21-jre

# Set a directory for the app
WORKDIR /app

# Copy the jar produced by your build
COPY target/*.jar app.jar

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]