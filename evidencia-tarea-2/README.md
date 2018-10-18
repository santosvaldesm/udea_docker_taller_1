# pruebas iniciales en local
create database paises_db;
use paises;
show tables;
describe paises;

CREATE TABLE IF NOT EXISTS `pais` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(32) NOT NULL,    
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

INSERT INTO `pais` (`codigo`, `nombre`) VALUES
  (null, 'Clombia'),
  (null, 'Bolivia'),
  (null, 'Argentina'),
  (null, 'Ecuador');
  
select * from pais;


# descargar o acutalizar repositorio
git clone https://github.com/santosvaldesm/udea_docker_taller_1.git
git pull origin master

# imagen de mysql
docker run -it \
    --name demo-mysql \
    -e MYSQL_ROOT_PASSWORD=1234 \
    -e MYSQL_DATABASE=paises_db \
    -e MYSQL_USER=santos \
    -e MYSQL_PASSWORD=1234 \
    mysql:latest	
# imagen de mysql
sudo docker run --name demo-mysql -p 3306:3306 \
         -v /home/usuario/db:/var/lib/mysql \
		 -e MYSQL_ROOT_PASSWORD=1234 \
		 -e MYSQL_DATABASE=paises_db \
		 -e MYSQL_USER=santos \
		 -e MYSQL_PASSWORD=1234 \
         -e MYSQL_ROOT_PASSWORD=1234 -d mysql
# conectandose a la base de datos		 
mysql --host=127.0.0.1 --port 3306 -u root -p	
	
# instalacion de java	
sudo add-apt-repository ppa:webupd8team/java
sudo apt update
sudo apt install oracle-java8-installer

# instalacion apache maven
cd /opt/
sudo su
wget http://www-eu.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
sudo tar -xvzf apache-maven-3.3.9-bin.tar.gz
sudo mv apache-maven-3.3.9 maven
sudo nano /etc/profile.d/mavenenv.sh
  export M2_HOME=/opt/maven
  export PATH=${M2_HOME}/bin:${PATH}

sudo chmod +x /etc/profile.d/mavenenv.sh
sudo -s 
source /etc/profile.d/mavenenv.sh

# dirigise a la aplicacion

cd /udea_docker_taller_1/paises_app
# creacion de imagen de java con paises_app
mvn clean package docker:build
# creacion del contenedor de la aplicacion
docker run -d \
    --name paises_app_contenedor \
    --link demo-mysql:mysql \
    -p 8080:8080 \
    -e DATABASE_HOST=localhost \
    -e DATABASE_PORT=3306 \
    -e DATABASE_NAME=paises_db \
    -e DATABASE_USER=santos \
    -e DATABASE_PASSWORD=1234 \
    santosvaldesm/paises_app
# iniciar el contenedor de la aplicacion
docker start paises_app_contenedor
# conectarse ala consola de mysql 
docker exec -it demo-mysql bash -l
# conectarse a la base de datos
mysql -uroot -p
	

