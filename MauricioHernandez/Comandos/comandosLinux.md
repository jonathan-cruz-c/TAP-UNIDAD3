## Instalación de maquina virtual y el Rdbms postgres 

# Comandos 
comando wsl --install -d debian = instalar la maquina virtual de Linux

# Comandos linux 
1.- wsl --install -d debian = instalar la maquina virtual de Linux
2.- sudo apt install postgresql = instalar postgresql
3.- sudo -i -u postgres = entrar a la terminal de postgres
4.- sudo services postgresql status = ver el estado y si estas activo
5.- sudo services postgresql restart = reinicia el servicio Postgres

# Comandos DDL 
alter user nombreUsuario password '123456789'; = modificar la contraseña 
create user admin with password '1234567';= crear user y con contraseña
alter user admin superuser createdb createrole;=darle permisos y crear db y role para ese usuario
create database db0 owner admin; = crear base de datos  

# Comandos PSQL 
\l = enlistar base de datos
\c = verificar que base de datos y user estas conectado
show hba_file = ver la ruta del archivo
\du = enlistar los usuarios
psql -U admin -d db0; = entrar con el usuario admin a la base de datos db0
\q y exit= comando para salir de la base de datos