FROM amazoncorretto:17-alpine
WORKDIR /app
# JAR is built by CodeBuild before docker build runs
COPY backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
