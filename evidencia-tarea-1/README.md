# Configuración realizada en virtual box
captura1

# Modificacion del archivo Dockerfile
nano udea_docker_taller_1/dockerfile-tarea-1/Dockerfile

# Contenido del archivo Dockerfile

FROM node:6-alpine
LABEL maintainer="santosvaldesm@gmail.com"
RUN apk update
RUN apk upgrade
RUN apk add --no-cache tini
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY package.json /usr/src/app
RUN npm install
RUN npm cache clean --force
COPY . /usr/src/app
EXPOSE 80
ENTRYPOINT ["/sbin/tini", "--", "./bin/www"]

# Creacion del contenedor
docker build -t nodejs-image udea_docker_taller_1/dockerfile-tarea-1
docker run --name tarea1_contenedor_01 -p 80:3000 -it nodejs-image /bin/sh

# Ver el contenedor en el explorador
captura2

# Cargar la imagen en docker hub
docker login -u santosvaldesm -p xxxxxx

santosvaldesm@santosvaldesm-VirtualBox:~/docker$ docker images

REPOSITORY                   | TAG         IMAGE ID     | CREATED      | SIZE   |
| -------------------------- | --------- | ------------ | ------------ | ------ |
| tarea1-image               | latest    | fbbea92efbee | 10 hours ago | 69MB   |
| santosvaldesm/tarea1-image | latest    | fbbea92efbee | 10 hours ago | 69MB   | 
| node                       | 6-alpine  | ac75c1f95b80 | 4 weeks ago  | 55.2MB |

docker tag fbbea92efbee santosvaldesm/tarea1-image:latest
docker push santosvaldesm/tarea1-image

https://hub.docker.com/r/santosvaldesm/tarea1-image/