# descargar o acutalizar repositorio
git clone https://github.com/santosvaldesm/udea_docker_taller_1.git<br/>
git pull origin master<br/>

# Creacion del micro servicio 
Construi un microservicio en spring boot que muestra una lista de ciudades que se <br/>
obtienen de una base de datos MySQL, e inicialmente lo desarrolle y probe en local<br/>
el proyecto se encuentra en la carpeta paises_app<br/>
![N|Solid](https://raw.githubusercontent.com/santosvaldesm/udea_docker_taller_1/master/evidencia-tarea-2/Captura.PNG)

# creacion de imagen de mysql
sudo docker run --name demo-mysql -p 3306:3306 \<br/>
         -v /home/usuario/db:/var/lib/mysql \<br/>
		 -e MYSQL_ROOT_PASSWORD=1234 \<br/>
		 -e MYSQL_DATABASE=paises_db \<br/>
		 -e MYSQL_USER=santos \<br/>
		 -e MYSQL_PASSWORD=1234 \<br/>
         -e MYSQL_ROOT_PASSWORD=1234 -d mysql<br/>
# conectandose a la base de datos		 
mysql --host=127.0.0.1 --port 3306 -u root -p<br/>	

# creacion de base de datos para 
<br/>
create database paises_db;<br/>
use paises;<br/>
<br/>
CREATE TABLE IF NOT EXISTS `pais` (<br/>
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,<br/>
  `nombre` VARCHAR(32) NOT NULL,<br/>
  PRIMARY KEY (`codigo`)<br/>
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;<br/>
<br/>
INSERT INTO `pais` (`codigo`, `nombre`) VALUES<br/>
  (null, 'Clombia'),<br/>
  (null, 'Bolivia'),<br/>
  (null, 'Argentina'),<br/>
  (null, 'Ecuador');<br/>
<br/>
select * from pais;<br/>
<br/>
imagen 01	
<br/>	
# instalacion de java	
sudo add-apt-repository ppa:webupd8team/java<br/>
sudo apt update<br/>
sudo apt install oracle-java8-installer<br/>

# instalacion apache maven<br/>
cd /opt/<br/>
sudo su<br/>
wget http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz<br/>
sudo tar -xvzf apache-maven-3.3.9-bin.tar.gz<br/>
sudo mv apache-maven-3.3.9 maven<br/>
sudo nano /etc/profile.d/mavenenv.sh<br/>
  //contenido de mavenenv.sh: 
  export M2_HOME=/opt/maven<br/>
  export PATH=${M2_HOME}/bin:${PATH}<br/>

sudo chmod +x /etc/profile.d/mavenenv.sh<br/>
sudo -s<br/> 
source /etc/profile.d/mavenenv.sh<br/>

# dirigise a la aplicacion
cd /udea_docker_taller_1/paises_app<br/>

# creacion de imagen de java con paises_app
mvn clean package docker:build<br/>
![N|Solid](https://raw.githubusercontent.com/santosvaldesm/udea_docker_taller_1/master/evidencia-tarea-2/Captura2.PNG)

# creacion del contenedor de la aplicacion
docker run -d \<br/>
    --name paises_app_contenedor \<br/>
    --link demo-mysql:mysql \<br/>
    -p 8080:8080 \<br/>
    -e DATABASE_HOST=localhost \<br/>
    -e DATABASE_PORT=3306 \<br/>
    -e DATABASE_NAME=paises_db \<br/>
    -e DATABASE_USER=santos \<br/>
    -e DATABASE_PASSWORD=1234 \<br/>
    santosvaldesm/paises_app<br/>
	
# iniciar el contenedor de la aplicacion
docker start paises_app_contenedor<br/>
![N|Solid](https://raw.githubusercontent.com/santosvaldesm/udea_docker_taller_1/master/evidencia-tarea-2/Captura4.PNG)

# prueba del microservicio
Hasta este punto llegue en el desarrollo de la tarea 2<br/>
![N|Solid](https://raw.githubusercontent.com/santosvaldesm/udea_docker_taller_1/master/evidencia-tarea-2/Captura3.PNG)
	

