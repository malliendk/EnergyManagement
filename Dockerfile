FROM eclipse-temurin:21
COPY target/EnergyManagement-0.0.1-SNAPSHOT.jar EnergyManagement-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "EnergyManagement-0.0.1.jar"]
