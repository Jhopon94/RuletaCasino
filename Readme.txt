Ruleta es un proyecto personal desarrollado con las siguientes tecnologías:

	* Ionic
	* React
	* Vite
	* Springboot
	* Docker
	* MySql

Se trata de una simulación para la mesa de un casino, en la cual se puede registrar, editar y eliminar jugadores, además de información
indirecta pero útil para dicho casino. Simula la administración d euna mesa de juego de la ruleta, en la que se obtienen partidas
ya sea por esperar 3 minutos o pulsar el botón de "jugar". 

Está diseñado para un entorno unix. Acontinuación los pasos apra instalar el proyecto en un servidor en la nube:

Notas:
	* Los archivos dentro de esta carpeta son todo lo que necesitas.
	* la carpeta "1.ruletaBackendBase" es el proyecto completo en caso de que no quieras usar microservicios.

Pasos:

1. Asegurate de tner listo una instancia virtual ya sea de google cloud, aws, heroku, etc.
2. Asegurate de tener una base de datos mysql en un servidor; el archivo para las tablas se encuentra en la carpeta
	bajo el nombre de RuletaPCA.sql por lo que solo queda importarlo en tu base de datos.
3. Asegúrate de haber creado un usuario con todos los privilegios y una contraseña para la base de datos mysql.
4. \servicio-backend\src\main\resources y en el archivo application.properties edita los datos de la base de datos.
5. Asegurate de subir los archivos en el servidor con la misma estructura en que se encuentran dentro de esta carpeta.
6. Puedes precindir de "1. ruletaBackendBase" si vas a usar microservicios.
7. Asegurate de tener instalado docker-compose-plugin en tu máquina virtual
8. Una vez todos los archivos se encuentren en tu instancia virtual, ubícate en la carpeta principal que hayas creado.
9. asegúrate de que te encuentres al mismo nivel del archivo docker-compose.yml
10. ejecuta el comando: sudo screen docker-compose up
11. Listo, accede a la ip de tu máquina virtual y disfruta!.