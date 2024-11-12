# Etapa de construcción
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa final
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/clinica_veterinaria-0.0.1.jar app_veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]