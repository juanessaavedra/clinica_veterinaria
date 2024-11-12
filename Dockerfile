FROM openjdk:17-jdk-slim
COPY target/clinica_veterinaria-0.0.1.jar app_veterinaria.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]