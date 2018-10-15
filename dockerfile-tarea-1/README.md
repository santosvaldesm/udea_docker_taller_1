# Instrucciones para La Aplicacion Node

## Instructions from the app developer
- you should use the 'node' official image, with the alpine 6.x branch
- this app listens on port 3000, but the container should launch on port 80
   so it will respond to http://localhost:80 on your computer
- then it should use alpine package manager to install tini
- then it should create directory /usr/src/app for app files 
- Node uses a "package manager", so it needs to copy in package.json file
-  then it needs to run 'npm install' to install dependencies from that file
- to keep it clean and small, run 'npm cache clean --force' after above
- then it needs to copy in all files from current directory
- then it needs to start container with command '/sbin/tini -- node ./bin/www'

# Instrucciones para La Aplicación Nodo

## Instrucciones del desarrollador de la aplicación
- Debes usar la imagen oficial 'nodo', con la rama alpina 6.x
- esta aplicación escucha en el puerto 3000, pero el contenedor debe iniciarse en el puerto 80
   por lo que responderá a http: // localhost: 80 en su computadora
- entonces debería usar el gestor de paquetes alpino para instalar tini
- entonces debería crear el directorio / usr / src / app para los archivos de la aplicación
- El nodo utiliza un "administrador de paquetes", por lo que debe copiarse en el archivo package.json
- luego debe ejecutar 'npm install' para instalar las dependencias de ese archivo
- para mantenerlo limpio y pequeño, ejecute 'npm cache clean --force' después de lo anterior
- entonces necesita copiar en todos los archivos del directorio actual
- entonces necesita iniciar el contenedor con el comando '/ sbin / tini - node ./bin/www'