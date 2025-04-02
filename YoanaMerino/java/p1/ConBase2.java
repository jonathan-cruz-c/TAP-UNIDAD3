import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class ConBase2 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/TransportePublic";
        String USER = "admin";
        String PASS = "123456";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a TransportePublic");

            statement = connection.createStatement();

            String queryPasajeros = "SELECT * FROM pasatransporte.pasajeros WHERE tipo_pasajero = 'Estudiante'";
            String queryRutas = "SELECT * FROM pasatransporte.rutas WHERE tiempo_aprox LIKE '%horas%' AND CAST(SUBSTRING(tiempo_aprox FROM '\\d+') AS INT) > 4";
            String queryTransportes = "SELECT * FROM pasatransporte.transportes WHERE tipo = 'Avión'";
            String queryjoin = "SELECT pasajeros.nombre, pasajeros.edad, transportes.tipo, transportes.modelo " + "FROM pasatransporte.pasajeros " + "FULL JOIN pasatransporte.viajes ON pasajeros.id = viajes.id_pasajeros " + "FULL JOIN pasatransporte.transportes ON viajes.id_transportes = transportes.id";

            resultSet = statement.executeQuery(queryPasajeros);
            System.out.println("Pasajeros (Tipo: Estudiante):");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre") +
                        ", Edad: " + resultSet.getInt("edad") + ", Teléfono: " + resultSet.getString("telefono"));
            }

            resultSet = statement.executeQuery(queryRutas);
            System.out.println("Rutas (Tiempo > 4 horas):");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Salida: " + resultSet.getString("salida_lugar") +
                        ", Destino: " + resultSet.getString("destino_lugar") + ", Tiempo Aproximado: " + resultSet.getString("tiempo_aprox"));
            }

            resultSet = statement.executeQuery(queryTransportes);
            System.out.println("Transportes (Tipo: Avión):");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Modelo: " + resultSet.getString("modelo") +
                        ", Matrícula: " + resultSet.getString("matricula"));
            }

        } catch (Exception e) {
            System.out.println("Error de conexión: " + e);
        }
    }
}
