package Tarea3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection con = null;
    public static Connection getConnection() {
        try {
            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels?user=root&password=root");
                System.out.println("Conexion satisfactoria.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection closeConnection() {
        try {
            if (con != null) {
                System.out.println("Conexión cerrada.");
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
