# **Instructivo para base de datos**

*Base de Datos:* comercio_db

*Esquema:* ventas_sc

*Entidades:* Clientes y Pedidos (Un cliente puede hacer muchos pedidos (1:N), pero cada pedido solo pertenece a un cliente.)

*Tablas:*

- clientes ( id, nombre, correo, teléfono).
- pedidos (id, fecha_pedido, total, cliente_id).

## **Pasos para hacer la base de daros**

1. **Entrar a la terminal**

	- Primero tenemos que tener abierto la terminar de linux, tenemos que cambiar al usuario postgres con el comando sudo -i -u postgres, cuando ya cambiamos de usuario a postgres tenemos que cambiaran a la terminar de postgres con un usuario y una base de datos específicos con el comando psql -U nom_usuario_adm -d nom_db, ya dentro de la terminal de postgres ya se puede crear la base de datos.

2. **Creación de la base de datos y esquema:**

	- Primero, se crea una base de datos que se va a llamar comercio_db con el comando create database nom_db;. despues de creada se cambia a esa base de datos usando el comando \c nom_db.
	- Dentro de la base de datos se crea un esquema llamado ventas_sc se va usar el comando create schema nom_schema;.
    - Le quitamos el permisos publicos a la base de datos.

3. **Creación de tablas:**

	- Se crea una tabla llamada clientes. Esta tabla tiene los campos de id, nombre, correo, teléfono.
	- También se crea otra tabla llamado pedidos con los campos de id, fecha_pedido, total, cliente_id.
	- Se usara el comando create table esquema.tabla (campos tipo de datos);
	- La relación entre las tablas es que un cliente puede tener muchos pedidos. Esto se loga por el campo cliente_id en la tabla pedidos.

4. **Insertar datos:**

    - Se ingresa datos con el comando insert into esquema.tabla (campos) values (Valores);.
    - Primero se ingresa datos a la tabla clientes y despues la tabla pedidos por su relacion.
	- Se ingresaron 10 registros de clientes.
	- Después se ingresaron 10 pedidos, cada uno relacionado a uno de esos clientes.

5. **Verificación:**

	- Se utiliza el comando select * from esquema.tabla;. Para ver los registros que tenemos.
