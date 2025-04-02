import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ComercioDB {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/comercio_db";
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
            String query1 = "select c.id as cliente_id, c.nombre, c.correo, c.telefono, p.id as pedido_id, p.fecha_pedido, p.total, p.cliente_id from ventas_sc.pedidos p full join ventas_sc.clientes c on p.cliente_id=c.id";
            resultset = statement.executeQuery(query1);
            System.out.println("resultset: " + resultset);
            System.out.println(
                    "\nEjecutando consulta 1: select c.id as cliente_id, c.nombre, c.correo, c.telefono, p.id as pedido_id, p.fecha_pedido, p.total, p.cliente_id from ventas_sc.pedidos p full join ventas_sc.clientes c on p.cliente_id=c.id");
            while (resultset.next()) {
                System.out.println("cliente_id: " + resultset.getInt("cliente_id") + " | " + "nombre: "
                        + resultset.getString("nombre") + " | " + "correo: " + resultset.getString("correo") + " | "
                        + "telefono: " + resultset.getString("telefono") + " - " + "pedido_id: "
                        + resultset.getInt("pedido_id") + " | " + "fecha de pedido: "
                        + resultset.getString("fecha_pedido")
                        + " | " + "total: " + resultset.getDouble("total") + " | " + "cliente: "
                        + resultset.getInt("cliente_id"));
            }
            // Consulta 2
            System.out.println("-------------------------------------------");
            String query2 = "select c.id as id_cliente, c.nombre, c.telefono, p.id as id_pedido, p.fecha_pedido, p.total from ventas_sc.pedidos p inner join ventas_sc.clientes c on p.cliente_id=c.id";
            resultset = statement.executeQuery(query2);
            System.out.println("resultset: " + resultset);
            System.out.println(
                    "\nEjecutando consulta 2: select c.id as id_cliente, c.nombre, c.telefono, p.id as id_pedido, p.fecha_pedido, p.total from ventas_sc.pedidos p inner join ventas_sc.clientes c on p.cliente_id=c.id");
            while (resultset.next()) {
                System.out.println("id_cliente: " + resultset.getInt("id_cliente") + " | " + "nombre: "
                        + resultset.getString("nombre") + " | " + "telefono: " + resultset.getString("telefono") + " - "
                        + "id_pedido: " + resultset.getInt("id_pedido") + " | " + "fecha de pedido: "
                        + resultset.getString("fecha_pedido") + " | " + "total: " + resultset.getDouble("total"));
            }
            // Consulta 3
            System.out.println("-------------------------------------------");
            String query3 = "select c.id as id_cliente, c.nombre, c.telefono, p.id as id_pedido, p.fecha_pedido, p.total from ventas_sc.pedidos p inner join ventas_sc.clientes c on p.cliente_id=c.id where total > 200.00";
            resultset = statement.executeQuery(query3);
            System.out.println("resultset: " + resultset);
            System.out.println(
                    "\nEjecutando consulta 3: select c.id as id_cliente, c.nombre, c.telefono, p.id as id_pedido, p.fecha_pedido, p.total from ventas_sc.pedidos p inner join ventas_sc.clientes c on p.cliente_id=c.id where total > 200.00");
            while (resultset.next()) {
                System.out.println("id_cliente: " + resultset.getInt("id_cliente") + " | " + "nombre: "
                        + resultset.getString("nombre") + " | " + "telefono: " + resultset.getString("telefono") + " - "
                        + "id_pedido: " + resultset.getInt("id_pedido") + " | " + "fecha de pedido: "
                        + resultset.getString("fecha_pedido") + " | " + "total: " + resultset.getDouble("total"));
            }
        } catch (Exception e) {
            System.out.println("Fallido" + e);
        }
    }
}