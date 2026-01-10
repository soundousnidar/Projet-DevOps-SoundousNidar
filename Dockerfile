# Dockerfile - Projet DevOps Soundous Nidar
# Utilise Eclipse Temurin (remplacement d'AdoptOpenJDK)
FROM eclipse-temurin:11-jre-alpine

# Métadonnées
LABEL maintainer="Soundous Nidar"
LABEL version="1.0"
LABEL description="Application DevOps pour le mini-projet"

# Crée un répertoire pour l'application
WORKDIR /app

# Copie le fichier compilé depuis Jenkins/CI
# Le répertoire 'target' est généré par Maven
COPY target/classes/App.class /app/

# Commande à exécuter quand le conteneur démarre
CMD ["java", "App"]

# Port exposé (optionnel - pour documentation)
EXPOSE 8080