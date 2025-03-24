# DESAFÍO: Análisis de Entidades y Creación de una Base de Datos

La actividad consiste en crear una base de datos por lo cual hay que identificar y dos entidades y describir el tipo de relación que comparten para definir los atributos de cada entidad como tambien las claves primarias y las foraneas si es que las hay de cada entidad(tabla). Despues se procede a crear todo en PostgreSQL y desarrollar un instructivo del paso a paso.

## Entidades seleccionadas
**Profesor y Curso**

### Relación
Uno a muchos (**1:N**), donde un profesor puede impartir varios cursos, pero cada curso solo tiene un profesor.

## Base de Datos
**AcademiaDB**

### Schema
**gestion**

### Tablas
#### Tabla `profesor`
- `id`
- `nombre`
- `apellido_pat`
- `apellido_mat`
- `especialidad`

#### Tabla `curso`
- `id`
- `nombre`
- `duracion`
- `id_profesor`

---

## INSTRUCCIONES

1. Se ingresa a PostgreSQL con el usuario `admin` que tiene privilegios de superusuario, con cualquier base de datos:
   ```sql
   sudo -i -u postgres psql -U admin -d db0
   ```

2. Se crea una base de datos llamada `AcademiaDB`:
   ```sql
   create database "AcademiaDB";
   ```

3. Nos pasamos a la base de datos creada en el paso anterior.

4. Se crea un schema con el nombre de `gestion`:
   ```sql
   create schema gestion;
   ```

5. Para crear las tablas `profesor` y `curso`, ya que tienen una relación de 1:N, donde un profesor puede impartir varios cursos, pero cada curso solo tiene un profesor, podemos notar que la tabla `curso` necesitará el dato de la tabla `profesor`, es decir, que tendrá un atributo foráneo proveniente de la tabla `profesor` (`id_profesor`), por ello es necesario crear primeramente la tabla `profesor`:
   ```sql
   create table gestion.profesor (
       id serial primary key, 
       nombre text, 
       apellido_pat text, 
       apellido_mat text, 
       especialidad text
   );
   ```

6. Se realizan 10 registros a la tabla `profesor`:
   ```sql
   insert into gestion.profesor (nombre, apellido_pat, apellido_mat, especialidad) values (...), ...;
   ```

7. Se realiza una consulta de la tabla completa `profesor` para verificar los registros:
   ```sql
   select * from gestion.profesor;
   ```

8. Se crea la segunda tabla `curso`:
   ```sql
   create table gestion.curso (
       id serial primary key, 
       nombre text, 
       duracion int, 
       id_profesor int references gestion.profesor(id)
   );
   ```

9. Se realizan 10 registros a la tabla `curso`:
   ```sql
   insert into gestion.curso (nombre, duracion, id_profesor) values (...), ...;
   ```

10. Se realiza una consulta de la tabla completa `curso` para verificar los registros:
    ```sql
    select * from gestion.curso;
    ```
