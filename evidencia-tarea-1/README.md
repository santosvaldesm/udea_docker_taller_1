# Configuración realizada en virtual box
![N|Solid](https://raw.githubusercontent.com/santosvaldesm/udea_docker_taller_1/master/evidencia-tarea-1/Captura1.PNG)

# Modificacion del archivo Dockerfile
nano udea_docker_taller_1/dockerfile-tarea-1/Dockerfile

# Contenido del archivo Dockerfile

FROM node:6-alpine<br/>
LABEL maintainer="santosvaldesm@gmail.com"<br/>
RUN apk update<br/>
RUN apk upgrade<br/>
RUN apk add --no-cache tini<br/>
RUN mkdir -p /usr/src/app<br/>
WORKDIR /usr/src/app<br/>
COPY package.json /usr/src/app<br/>
RUN npm install<br/>
RUN npm cache clean --force<br/>
COPY . /usr/src/app<br/>
EXPOSE 80<br/>
ENTRYPOINT ["/sbin/tini", "--", "./bin/www"]

# Creacion del contenedor
docker build -t nodejs-image udea_docker_taller_1/dockerfile-tarea-1<br/>
docker run --name tarea1_contenedor_01 -p 80:3000 -it nodejs-image /bin/sh

# Ver el contenedor en el explorador
![N|Solid](https://raw.githubusercontent.com/santosvaldesm/udea_docker_taller_1/master/evidencia-tarea-1/Captura2.PNG)

# Cargar la imagen en docker hub
docker login -u santosvaldesm -p xxxxxx<br/>
santosvaldesm@santosvaldesm-VirtualBox:~/docker$ docker images<br/><br/>
<table>  
  <tr>
    <td>REPOSITORY</td>
    <td>TAG</td> 
    <td>IMAGE ID</td>
	<td>CREATED</td>
	<td>SIZE</td>
  </tr>
  <tr>
    <td>tarea1-image</td> 
    <td>latest</td>
	<td>fbbea92efbee</td>
	<td>10 hours ago</td>
	<td>69MB</td>
  </tr>
  <tr>
    <td>santosvaldesm/tarea1-image</td> 
    <td>latest</td>
	<td>fbbea92efbee</td>
	<td>10 hours ago</td>
	<td>69MB</td>
  </tr>
  <tr>
    <td>node</td> 
    <td>6-alpine</td>
	<td>ac75c1f95b80</td>
	<td>4 weeks ago</td>
	<td>55.2MB</td>
  </tr>  
</table>
<br/>
docker tag fbbea92efbee santosvaldesm/tarea1-image:latest<br/>
docker push santosvaldesm/tarea1-image<br/>
https://hub.docker.com/r/santosvaldesm/tarea1-image/