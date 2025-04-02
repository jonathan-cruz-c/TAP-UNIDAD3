import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class P20 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/p20";
        String USER = "p20_user";
        String PASS = "12345678";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Exitoso");
            statement = connection.createStatement();
            // Consulta 1
            String query1 = "select u.id as usuarios_id, u.nombre as usuario, u.materias_id, u.edad, m.id as id_materias, m.nombre as nombre_materia from rh.usuarios_p20 u full join rh.materias m on u.materias_id=m.id where u.edad=19 or u.edad=21";
            resultset = statement.executeQuery(query1);
            System.out.println("resultset: " + resultset);
            System.out.println(
                    "\nEjecutando consulta 1: select u.id as usuarios_id, u.nombre as usuario, u.materias_id, u.edad, m.id as id_materias, m.nombre as nombre_materia from rh.usuarios_p20 u full join rh.materias m on u.materias_id=m.id where u.edad=19 or u.edad=21");
            while (resultset.next()) {
                System.out.println("usuarios_id: " + resultset.getInt("usuarios_id") + " | " + "nombre: "
                        + resultset.getString("usuario") + " | " + "materia_id: " + resultset.getInt("materias_id")
                        + " | "
                        + "edad: " + resultset.getInt("edad") + " - " + "materia_id: "
                        + resultset.getInt("id_materias") + " | " + "nombre_materia: "
                        + resultset.getString("nombre_materia"));
            }
            // Consulta 2
            System.out.println("-------------------------------------------");
            String query2 = "select u.id as usuarios_id, u.nombre as usuario, u.materias_id, u.edad, m.id as id_materias, m.nombre as nombre_materia from rh.usuarios_p20 u inner join rh.materias m on u.materias_id=m.id order by m.id desc";
            resultset = statement.executeQuery(query2);
            System.out.println("resultset: " + resultset);
            System.out.println(
                    "\nEjecutando consulta 2: select u.id as usuarios_id, u.nombre as usuario, u.materias_id, u.edad, m.id as id_materias, m.nombre as nombre_materia from rh.usuarios_p20 u inner join rh.materias m on u.materias_id=m.id order by m.id desc");
            while (resultset.next()) {
                System.out.println("usuarios_id: " + resultset.getInt("usuarios_id") + " | " + "nombre: "
                        + resultset.getString("usuario") + " | " + "materia_id: " + resultset.getInt("materias_id")
                        + " | "
                        + "edad: " + resultset.getInt("edad") + " - " + "materia_id: "
                        + resultset.getInt("id_materias") + " | " + "nombre_materia: "
                        + resultset.getString("nombre_materia"));
            }
            // Consulta 3
            System.out.println("-------------------------------------------");
            String query3 = "select u.id as usuarios_id, u.nombre as usuario, u.materias_id, u.edad, m.id as id_materias, m.nombre as nombre_materia from rh.usuarios_p20 u full join rh.materias m on u.materias_id=m.id where u.nombre like '%C%' or u.nombre like '%c%'";
            resultset = statement.executeQuery(query3);
            System.out.println("resultset: " + resultset);
            System.out.println(
                    "\nEjecutando consulta 3: select u.id as usuarios_id, u.nombre as usuario, u.materias_id, u.edad, m.id as id_materias, m.nombre as nombre_materia from rh.usuarios_p20 u full join rh.materias m on u.materias_id=m.id where u.nombre like '%C%' or u.nombre like '%c%'");
            while (resultset.next()) {
                System.out.println("usuarios_id: " + resultset.getInt("usuarios_id") + " | " + "nombre: "
                        + resultset.getString("usuario") + " | " + "materia_id: " + resultset.getInt("materias_id")
                        + " | "
                        + "edad: " + resultset.getInt("edad") + " - " + "materia_id: "
                        + resultset.getInt("id_materias") + " | " + "nombre_materia: "
                        + resultset.getString("nombre_materia"));
            }
        } catch (Exception e) {
            System.out.println("Fallido" + e);
        }
    }
}