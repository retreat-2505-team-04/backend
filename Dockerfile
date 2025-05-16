FROM eclipse-temurin:21.0.7_6-jre-ubi9-minimal

WORKDIR /app

# Másold be a lefordított JAR fájlt a konténerbe
COPY target/demo.jar

# (Opcionális) JVM beállítások környezeti változóként
# ENV JAVA_OPTS="-Xms256m -Xmx512m"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo.jar"]
