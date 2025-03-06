#Comandos de Linux para instalar y administrar PostgreSQL en Debian

Se presentara a continuación los comandos básicos para instalar y administrar PostgreSQL en Debian dentro de WSL

#1.- Instalacion de Debian en WSL
```wsl --install -d debian```
Este comando instala Debian en el Subsistema de Windows para Linux (WSL). Si no tienes WSL activado, lo habilita automáticamente y mete Debian en tu sistema.

#2.- Instalacion de PostgreSQL
```sudo apt install postgresql```
Con esto, instalas PostgreSQL en Debian. Básicamente, es el motor de bases de datos que vamos a usar.

#3.- Cambiar al usuario PostgreSQL
```sudo -i -u postgres```
 PostgreSQL crea su propio usuario en el sistema. Este comando te cambia a ese usuario para que puedas hacer cosas más avanzadas dentro de la base de datos.

#4.- Verificar si PostgreSQL esta corriendo
```sudo service postgresql status```
Con este comando puedes ver su estado: si está activo, detenido o si algo salió mal.

#5.- Reiniciar PostgreSQL
```sudo service postgresql restart```
Este comando reinicia el servicio y debería dejar todo funcionando otra vez.
