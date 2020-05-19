package Tarea9;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ADClassicModels {

    public ADClassicModels() {
    }

    public List<Employee> getEmpleados() {
        List<Employee> emp = new ArrayList<>();
        try {
            Connection c = ConexionDB.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from employees");

            while (rs.next()) {
                Employee e = new Employee(rs.getInt("employeeNumber"), rs.getString("lastName"),
                        rs.getString("firstName"), rs.getString("extension"),
                        rs.getString("email"), rs.getString("officeCode"),
                        rs.getInt("reportsTo"), rs.getString("jobTitle"));
                emp.add(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }

    public List<Office> getOficinas() {
        List<Office> offi = new ArrayList<>();
        try {
            Connection c = ConexionDB.getConnection();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select * from offices");

            while (rs.next()) {
                Office o = new Office(rs.getString("officeCode"), rs.getString("city"),
                        rs.getString("phone"), rs.getString("addressLine1"),
                        rs.getString("addressLine2"), rs.getString("state"),
                        rs.getString("country"), rs.getString("postalCode"),
                        rs.getString("territory"));
                offi.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return offi;
    }
}
