import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta3 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/hospital";
        String USER = "admin";
        String PASS = "Sitecreas7";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();

            String query1 = "SELECT c.id_cita, p.nombre AS paciente, m.nombre AS medico, m.especialidad, " +
                    "c.fecha_cita, c.hora_cita, c.estado " +
                    "FROM gestion.citas c " +
                    "INNER JOIN gestion.pacientes p ON c.id_paciente = p.id_paciente " +
                    "INNER JOIN gestion.medicos m ON c.id_medico = m.id_medico;";
            System.out.println("Lista de Citas con Pacientes y Médicos:");
            ResultSet rs1 = stmt.executeQuery(query1);
            while (rs1.next()) {
                System.out.println("Cita: " + rs1.getInt("id_cita") +
                        ", Paciente: " + rs1.getString("paciente") +
                        ", Médico: " + rs1.getString("medico") +
                        " (" + rs1.getString("especialidad") + ")" +
                        ", Fecha: " + rs1.getDate("fecha_cita") +
                        ", Hora: " + rs1.getTime("hora_cita") +
                        ", Estado: " + rs1.getString("estado"));
            }
            rs1.close();
            System.out.println("----------------------------------------");

            System.out.println("Lista de Médicos y Cantidad de Citas:");
            String query2 = "SELECT m.id_medico, m.nombre, m.especialidad, COUNT(c.id_cita) AS total_citas " +
                    "FROM gestion.medicos m " +
                    "LEFT JOIN gestion.citas c ON m.id_medico = c.id_medico " +
                    "GROUP BY m.id_medico;";
            ResultSet rs2 = stmt.executeQuery(query2);
            while (rs2.next()) {
                System.out.println("Médico: " + rs2.getString("nombre") +
                        " (" + rs2.getString("especialidad") + ")" +
                        ", Total de Citas: " + rs2.getInt("total_citas"));
            }
            rs2.close();
            System.out.println("----------------------------------------");

            System.out.println("Pacientes con Citas Confirmadas:");
            String query3 = "SELECT DISTINCT p.nombre " +
                    "FROM gestion.pacientes p " +
                    "INNER JOIN gestion.citas c ON p.id_paciente = c.id_paciente " +
                    "WHERE c.estado = 'confirmada';";
            ResultSet rs3 = stmt.executeQuery(query3);
            while (rs3.next()) {
                System.out.println("Paciente: " + rs3.getString("nombre"));
            }
            rs3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
