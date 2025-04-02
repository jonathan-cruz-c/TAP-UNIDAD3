import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta2 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/biblioteca";
        String USER = "admin";
        String PASS = "Sitecreas7";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();

            String query1 = "SELECT p.id_prestamo, u.nombre, l.titulo, p.fecha_prestamo, p.fecha_devolucion " +
                            "FROM gestion.prestamos p " +
                            "INNER JOIN gestion.usuarios u ON p.id_usuario = u.id_usuario " +
                            "INNER JOIN gestion.libros l ON p.id_libro = l.id_libro;";
            System.out.println("Lista de Préstamos con Usuarios y Libros:");
            ResultSet rs1 = stmt.executeQuery(query1);
            while (rs1.next()) {
                System.out.println("Préstamo: " + rs1.getInt("id_prestamo") +
                        ", Usuario: " + rs1.getString("nombre") +
                        ", Libro: " + rs1.getString("titulo") +
                        ", Fecha Préstamo: " + rs1.getDate("fecha_prestamo") +
                        ", Fecha Devolución: " + rs1.getDate("fecha_devolucion"));
            }
            rs1.close();
            System.out.println("----------------------------------------");

            System.out.println("Lista de Libros y Disponibilidad:");
            String query2 = "SELECT id_libro, titulo, autor, genero, stock FROM gestion.libros;";
            ResultSet rs2 = stmt.executeQuery(query2);
            while (rs2.next()) {
                System.out.println("Libro ID: " + rs2.getInt("id_libro") +
                        ", Título: " + rs2.getString("titulo") +
                        ", Autor: " + rs2.getString("autor") +
                        ", Género: " + rs2.getString("genero") +
                        ", Stock: " + rs2.getInt("stock"));
            }
            rs2.close();
            System.out.println("----------------------------------------");

            System.out.println("Usuarios con Préstamos:");
            String query3 = "SELECT DISTINCT u.nombre " +
                            "FROM gestion.usuarios u " +
                            "INNER JOIN gestion.prestamos p ON u.id_usuario = p.id_usuario;";
            ResultSet rs3 = stmt.executeQuery(query3);
            while (rs3.next()) {
                System.out.println("Usuario: " + rs3.getString("nombre"));
            }
            rs3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
