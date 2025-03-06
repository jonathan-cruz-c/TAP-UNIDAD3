# Comandos para instalar y administrar PostgreSQL en Debian

A continuación, se presentan los comandos necesarios para instalar y administrar PostgreSQL en una distribución basada en Debian dentro de WSL.

## 1. Instalar Debian en WSL

```sh
wsl --install -d debian
```

**Descripción:** Este comando instala la distribución Debian en el Subsistema de Windows para Linux (WSL). Si WSL no está habilitado, lo activa y procede con la instalación de Debian.

## 2. Instalar PostgreSQL

```sh
sudo apt install postgresql
```

**Descripción:** Instala el servidor de base de datos PostgreSQL en una distribución basada en Debian/Ubuntu.

## 3. Iniciar sesión como usuario PostgreSQL

```sh
sudo -i -u postgres
```

**Descripción:** Cambia al usuario del sistema `postgres`, que es creado automáticamente al instalar PostgreSQL. Esto es necesario para ejecutar ciertos comandos administrativos de PostgreSQL.

## 4. Verificar el estado del servicio PostgreSQL

```sh
sudo service postgresql status
```

**Descripción:** Muestra el estado actual del servicio de PostgreSQL, indicando si está en ejecución, detenido o si ha fallado.

## 5. Reiniciar el servicio de PostgreSQL

```sh
sudo service postgresql restart
```

**Descripción:** Reinicia el servicio de PostgreSQL, útil después de realizar cambios en la configuración.
