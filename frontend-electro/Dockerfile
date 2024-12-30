# Utilisez une image de Node.js pour le build
FROM node:16 as build

WORKDIR /app

# Copiez les fichiers du frontend
COPY . .

# Installez les dépendances et build l'application
RUN npm install && npm run build

# Utilisez une image de serveur web pour servir l'application
FROM nginx:alpine

# Copiez les fichiers générés dans le répertoire build de nginx
COPY --from=build /app/dist/ /usr/share/nginx/html

# Exposez le port 80 pour l'accès au frontend
EXPOSE 80

# Lancement de nginx
CMD ["nginx", "-g", "daemon off;"]
