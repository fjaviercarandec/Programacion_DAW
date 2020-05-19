package Tarea9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static Connection con = null;
    public static Connection getConnection() {
        try {
            if (con == null) {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost/classicmodels?autoReconnect=true";
                String pwd = "root";
                String usr = "root";
                Class.forName(driver);
                con = DriverManager.getConnection(url, usr, pwd);
                System.out.println("Conexion satisfactoria.");
            }
        } catch (ClassNotFoundException | SQLException e) {
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
