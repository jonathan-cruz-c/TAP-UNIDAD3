import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class ConBase1 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/Practica_YoanaM";
        String USER = "admin";
        String PASS = "123456";

        Connection connection = null;  
        Statement statement = null;  
        ResultSet resultSet = null;  

        try {  
            connection = DriverManager.getConnection(URL, USER, PASS);  
            System.out.println("Conexión exitosa a Practica_YoanaM");  

            statement = connection.createStatement();  

            String queryColores = "SELECT * FROM catalogos.colores WHERE nombre_color LIKE '%Ro%'";  
            String queryDepartamento = "SELECT * FROM catalogos.departamento_yoanam";  
            String queryProductos = "SELECT * FROM catalogos.productos_yoanam WHERE cantidad > 10";  

            resultSet = statement.executeQuery(queryColores);  
            System.out.println("Colores (filtro: nombre contiene 'Ro'):");
            while (resultSet.next()) {  
                System.out.println("ID: " + resultSet.getInt("id") + ", Color: " + resultSet.getString("nombre_color"));  
            }  

            resultSet = statement.executeQuery(queryDepartamento);  
            System.out.println("Departamentos:");
            while (resultSet.next()) {  
                System.out.println("ID: " + resultSet.getInt("id") + ", Departamento: " + resultSet.getString("nombre"));  
            }  

            resultSet = statement.executeQuery(queryProductos);  
            System.out.println("Productos (cantidad > 10):");
            while (resultSet.next()) {  
                System.out.println("ID: " + resultSet.getInt("id") + ", Producto: " + resultSet.getString("nombre") +
                        ", Costo: " + resultSet.getDouble("costo") + ", Cantidad: " + resultSet.getInt("cantidad"));  
            }  

        } catch (Exception e) {  
            System.out.println("Error de conexión: " + e);  
        }  
    }
}