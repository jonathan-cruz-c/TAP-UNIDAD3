import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class S4V {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/S4V";
        String USER = "jona";
        String PASS = "12345";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Exitoso");
            statement = connection.createStatement();
            // Consulta 1
            String query = "select * from \"TAP\".estudiantes";
            resultset = statement.executeQuery(query);
            System.out.println("resultset: " + resultset);
            System.out.println("\nEjecutando consulta 1: select * from TAP.estudiantes");
            while (resultset.next()) {
                System.out.println("id: " + resultset.getInt("id") + " | " + "name: " + resultset.getString("name")
                        + " | " + "age: " + resultset.getInt("age"));
            }
            // Consulta 2
            System.out.println("-------------------------------------------");
            String query2 = "select * from \"TAP\".estudiantes where age = 20";
            resultset = statement.executeQuery(query2);
            System.out.println("resultset: " + resultset);
            System.out.println("\nEjecutando consulta 2: select * from TAP.estudiantes where age = 20");
            while (resultset.next()) {
                System.out.println("id: " + resultset.getInt("id") + " | " + "name: " + resultset.getString("name")
                        + " | " + "age: " + resultset.getInt("age"));
            }
            // Consulta 2
            System.out.println("-------------------------------------------");
            String query3 = "select * from \"TAP\".estudiantes order by age desc";
            resultset = statement.executeQuery(query3);
            System.out.println("resultset: " + resultset);
            System.out.println("\nEjecutando consulta 3: select * from TAP.estudiantes order by age desc");
            while (resultset.next()) {
                System.out.println("id: " + resultset.getInt("id") + " | " + "name: " + resultset.getString("name")
                        + " | " + "age: " + resultset.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println("Fallido " + e);
        }
    }
}