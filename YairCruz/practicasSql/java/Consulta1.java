import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta1 {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/tiendaonline";
        String USER = "admin";
        String PASS = "Sitecreas7";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();
            String query1 = "SELECT p.id_pedido, c.nombre, p.fecha_pedido, p.total " +
                    "FROM tienda.pedidos p INNER JOIN tienda.clientes c " +
                    "ON p.id_cliente = c.id_cliente;";
            System.out.println("Lista de Pedidos con Clientes:");
            ResultSet rs1 = stmt.executeQuery(query1);
            while (rs1.next()) {
                System.out.println("Pedido: " + rs1.getInt("id_pedido") +
                        ", Cliente: " + rs1.getString("nombre") +
                        ", Fecha: " + rs1.getDate("fecha_pedido") +
                        ", Total: " + rs1.getBigDecimal("total"));
            }
            rs1.close();
            System.out.println("----------------------------------------");

            System.out.println("Lista de Productos con Categoría:");
            String query2 = "SELECT pr.id_producto, pr.nombre, pr.precio, cat.nombre AS categoria " +
                    "FROM tienda.productos pr " +
                    "INNER JOIN tienda.categorias cat ON pr.id_categoria = cat.id_categoria;";
            ResultSet rs2 = stmt.executeQuery(query2);
            while (rs2.next()) {
                System.out.println("Producto: " + rs2.getInt("id_producto") +
                        ", Nombre: " + rs2.getString("nombre") +
                        ", Precio: $" + rs2.getBigDecimal("precio") +
                        ", Categoría: " + rs2.getString("categoria"));
            }
            rs2.close();
            System.out.println("----------------------------------------");

            System.out.println("Detalle de Pedidos con Productos:");
            String query3 = "SELECT dp.id_pedido, pr.nombre AS producto, dp.cantidad, dp.subtotal " +
                    "FROM tienda.detalle_pedido dp " +
                    "INNER JOIN tienda.productos pr ON dp.id_producto = pr.id_producto;";
            ResultSet rs3 = stmt.executeQuery(query3);
            while (rs3.next()) {
                System.out.println("Pedido: " + rs3.getInt("id_pedido") +
                        ", Producto: " + rs3.getString("producto") +
                        ", Cantidad: " + rs3.getInt("cantidad") +
                        ", Subtotal: $" + rs3.getBigDecimal("subtotal"));
            }
            rs3.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
