FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/SeguimientoResolucion-0.0.1-SNAPSHOT.jar /app/SeguimientoResolucion.jar

EXPOSE 8082

ENTRYPOINT [ "java", "-jar", "SeguimientoResolucion.jar" ]