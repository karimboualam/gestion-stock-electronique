# Utilisez l'image de base OpenJDK pour exécuter Spring Boot
FROM openjdk:17-jdk-slim

# Créez un répertoire pour l'application
WORKDIR /app

# Copiez le fichier JAR généré par Maven dans l'image
COPY target/electro-0.0.1-SNAPSHOT.jar /app/electro.jar

# Exposez le port sur lequel l'application va tourner
EXPOSE 8080

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "electro.jar"]
