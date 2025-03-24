# INSTRUCTIVO DE LA BASE DE DATOS TRANSPORTE-PUBLIC

1. Primero, entré a la terminal de Debian y usé el comando:  
   ```sh
   sudo -i -u postgres
Después, ingresé al usuario psql para acceder a la terminal de PostgreSQL.

2. En la terminal de postgres=#, creé la base de datos llamada "TransportePublic", especificando que pertenecía a mi usuario admin previamente creado.
Usé el comando \q para salir y, en la terminal de postgres@Amadeus, ingresé a mi base de datos ya creada con:
psql -U admin -d "TransportePublic"

3. Una vez dentro de mi base de datos, creé mi esquema llamado pasatransporte.

4. Luego, creé la tabla Transportes con los atributos: id, tipo, modelo y matrícula.
Inserté 9 registros: 3 trenes, 3 aviones y 3 autobuses.
Para confirmar los registros, utilicé: SELECT * FROM pasatransporte.Transportes;

5. Después, creé la tabla Pasajeros con los atributos: id, nombre, edad, género, teléfono y tipo_pasajero.
Inserté 19 registros y confirmé con SELECT * FROM.
También realicé algunas consultas usando ASC y DESC, entre otras.

6. Luego, creé la tabla Rutas con los atributos: id, salida_lugar, destino_lugar y tiempo_aprox.
Inserté 11 registros y confirmé con SELECT * FROM.

7. Finalmente, creé la tabla Viajes, la cual conecta las tres tablas ya creadas.
Esta tabla tiene los atributos: id, id_pasajeros, id_transportes e id_rutas.
Al momento de crearla, olvidé agregar un atributo, por lo que lo arreglé con: ALTER TABLE pasatransporte.Viajes ADD COLUMN fecha_viaje DATE;
Luego, inserté 19 registros, igual que la cantidad de pasajeros, y confirmé con SELECT * FROM.

Las demás capturas corresponden a consultas utilizando LIKE, ORDER BY e IN.




