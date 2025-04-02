import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class ConBase3 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/p20";
        String USER = "admin";
        String PASS = "123456";

        Connection connection = null;  
        Statement statement = null;  
        ResultSet resultSet = null;  

        try {  
            connection = DriverManager.getConnection(URL, USER, PASS);  
            System.out.println("Conexión exitosa a p20");  

            statement = connection.createStatement();  
            String query1 = "SELECT * FROM rh.usuario_p20";  
            String query2 = "SELECT * FROM rh.usuario_p20 WHERE edad > 20";  
            String queryMaterias = "SELECT * FROM rh.materias_p20"; 
            resultSet = statement.executeQuery(query1);  
            while (resultSet.next()) {  
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("name"));  
            }  

            resultSet = statement.executeQuery(query2);  
            while (resultSet.next()) {  
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("name") + ", Edad: " + resultSet.getInt("edad"));  
            }  

            resultSet = statement.executeQuery(queryMaterias);  
            while (resultSet.next()) {  
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre de la Materia: " + resultSet.getString("name"));  
            }  

        } catch (Exception e) {  
            System.out.println("Error de conexión: " + e);  
        }  
    }
}
