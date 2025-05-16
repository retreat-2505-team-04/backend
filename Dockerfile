FROM eclipse-temurin:21.0.7_6-jre-ubi9-minimal

WORKDIR /app

# Lefordított JAR bemásolása a konténerbe
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar

# (Opcionális) JVM beállítások környezeti változóként
# ENV JAVA_OPTS="-Xms256m -Xmx512m"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
