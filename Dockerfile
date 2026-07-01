FROM amazoncorretto:17-alpine AS build
WORKDIR /build
COPY pom.xml .
COPY backend/pom.xml backend/
COPY backend/src backend/src
RUN ./mvnw -f pom.xml package -pl backend -am -DskipTests -q 2>/dev/null || \
    mvn -f pom.xml package -pl backend -am -DskipTests -q

FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /build/backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
