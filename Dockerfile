FROM nginx:alpine
ADD  app/dist/frontApp /usr/share/nginx/html
EXPOSE 80
