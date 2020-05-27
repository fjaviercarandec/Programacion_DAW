package Tarea4;

import java.sql.*;

public class Transactions {
    public static void main(String[] args) {
        Connection con = ConexionDB.getConnection();

        Office office = new Office("8", "Sevilla", "954 11 22 33", "1, Calle prueba",
                null, null, "España", "41950", "EMEA");
        Employee emp1 = new Employee(1800, "Carande", "Javier", "x2000",
                "javier.carande@classicmodelcars.com", "8", 1102, "Sales Rep");
        Employee emp2 = new Employee(1801, "Palote", "Pepe", "x2001",
                "pepe.palote@classicmodelcars.com", "8", 1102, "Sales Rep");
        Customer cust = new Customer(2, "Nombre Cliente", "Apellido",
                "Nombre", "900 90 80 70", "2, Calle Cliente", null,
                "Sevilla", null, "41960", "España", 1800, 300000.00);
        Order order = new Order(10099, Date.valueOf("2020-01-14"), Date.valueOf("2020-01-20"), Date.valueOf("2020-01-16"),
                "Shipped", null, 2);
        OrderDetail detail1 = new OrderDetail(10099, "S18_1749", 10, 136.00, 19);
        OrderDetail detail2 = new OrderDetail(10099, "S18_2248", 5, 55.09, 20);

        insertOfficeEmployee(office, emp1, emp2, cust, con);
        insertOrderProduct(order, detail1, detail2, con);

        try {
            String query1 = "SELECT c.customerName, e.firstName, o.city FROM customers c " +
                    "INNER JOIN employees e ON c.salesRepEmployeeNumber = e.employeeNumber " +
                    "INNER JOIN offices o ON e.officeCode = o.officeCode WHERE customerNumber = ?";
            PreparedStatement ps1 = con.prepareStatement(query1);
            ps1.setInt(1, cust.getCustomerNumber());
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()) {
                System.out.println("=====================================================================================================================");
                System.out.println("CustomerName = " + rs1.getString("customerName") + ", FirstName = " + rs1.getString("firstName")
                + ", City = " + rs1.getString("city"));
                System.out.println("=====================================================================================================================");
            }

            String query2 = "SELECT c.customerName, o.orderDate, o.status FROM customers c INNER JOIN orders o ON c.customerNumber = o.customerNumber WHERE c.customerNumber = ?";
            PreparedStatement ps2 = con.prepareStatement(query2);
            ps2.setInt(1, cust.getCustomerNumber());
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                System.out.println("CustomerName = " + rs2.getString("customerName") + ", OrderDate = " + rs2.getDate("orderDate")
                        + ", Status = " + rs2.getString("status"));
            }
            String query3 = "SELECT p.productName, od.quantityOrdered, od.priceEach FROM products p " +
                    "INNER JOIN orderdetails od ON p.productCode = od.productCode WHERE od.orderNumber = ?";
            PreparedStatement ps3 = con.prepareStatement(query3);
            ps3.setInt(1, detail1.getOrderNumber());
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next()) {
                System.out.println("Product { ProductName = " + rs3.getString("productName") + ", Quantity = " + rs3.getInt("quantityOrdered")
                + ", PriceEach = " + rs3.getDouble("priceEach"));
            }
            System.out.println("=====================================================================================================================");
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertOfficeEmployee(Office o, Employee e1, Employee e2, Customer c, Connection con) {
        try {
            con.setAutoCommit(false);

            //Inserto la oficina
            String queryOffice = "INSERT INTO offices VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement psOffice = con.prepareStatement(queryOffice);
            psOffice.setString(1, o.getOfficeCode());
            psOffice.setString(2, o.getCity());
            psOffice.setString(3, o.getPhone());
            psOffice.setString(4, o.getAddressLine1());
            psOffice.setString(5, o.getAddressLine2());
            psOffice.setString(6, o.getState());
            psOffice.setString(7, o.getCountry());
            psOffice.setString(8, o.getPostalCode());
            psOffice.setString(9, o.getTerritory());
            psOffice.executeUpdate();

            //Inserto los dos empleados
            String queryEmp1 = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement psEmployee1 = con.prepareStatement(queryEmp1);
            psEmployee1.setInt(1, e1.getEmployeeNumber());
            psEmployee1.setString(2, e1.getLastName());
            psEmployee1.setString(3, e1.getFirstName());
            psEmployee1.setString(4, e1.getExtesion());
            psEmployee1.setString(5, e1.getEmail());
            psEmployee1.setString(6, e1.getOfficeCode());
            psEmployee1.setInt(7, e1.getReportsTo());
            psEmployee1.setString(8, e1.getJobTitle());
            psEmployee1.executeUpdate();
            String queryEmp2 = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement psEmployee2 = con.prepareStatement(queryEmp2);
            psEmployee2.setInt(1, e2.getEmployeeNumber());
            psEmployee2.setString(2, e2.getLastName());
            psEmployee2.setString(3, e2.getFirstName());
            psEmployee2.setString(4, e2.getExtesion());
            psEmployee2.setString(5, e2.getEmail());
            psEmployee2.setString(6, e2.getOfficeCode());
            psEmployee2.setInt(7, e2.getReportsTo());
            psEmployee2.setString(8, e2.getJobTitle());
            psEmployee2.executeUpdate();

            //Inserto cliente
            String queryCustomer = "INSERT INTO customers VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement psCustomer = con.prepareStatement(queryCustomer);
            psCustomer.setInt(1, c.getCustomerNumber());
            psCustomer.setString(2, c.getCustomerName());
            psCustomer.setString(3, c.getContactLastName());
            psCustomer.setString(4, c.getContactFirstName());
            psCustomer.setString(5, c.getPhone());
            psCustomer.setString(6, c.getAddressLine1());
            psCustomer.setString(7, c.getAddressLine2());
            psCustomer.setString(8, c.getCity());
            psCustomer.setString(9, c.getState());
            psCustomer.setString(10, c.getPostalCode());
            psCustomer.setString(11, c.getCountry());
            psCustomer.setInt(12, c.getSalesRepEmployeeNumber());
            psCustomer.setDouble(13, c.getCreditLimit());
            psCustomer.executeUpdate();

            con.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void insertOrderProduct(Order o, OrderDetail od1, OrderDetail od2, Connection con) {
        try {
            con.setAutoCommit(false);

            //Inserto Pedido
            String queryOrder = "INSERT INTO orders VALUES (?,?,?,?,?,?,?)";
            PreparedStatement psOrder = con.prepareStatement(queryOrder);
            psOrder.setInt(1, o.getOrderNumber());
            psOrder.setDate(2, o.getOrderDate());
            psOrder.setDate(3, o.getRequiredDate());
            psOrder.setDate(4, o.getShippedDate());
            psOrder.setString(5, o.getStatus());
            psOrder.setString(6, o.getComments());
            psOrder.setInt(7, o.getCustomerNumber());
            psOrder.executeUpdate();

            //Inserto dos Detalles (dos objetos)
            String queryDetail1 = "INSERT INTO orderdetails VALUES (?,?,?,?,?)";
            PreparedStatement psDetail1 = con.prepareStatement(queryDetail1);
            psDetail1.setInt(1, od1.getOrderNumber());
            psDetail1.setString(2, od1.getProductCode());
            psDetail1.setInt(3, od1.getQuantityOrdered());
            psDetail1.setDouble(4, od1.getPriceEach());
            psDetail1.setInt(5, od1.getOrderLineNumber());
            psDetail1.executeUpdate();
            String queryDetail2 = "INSERT INTO orderdetails VALUES (?,?,?,?,?)";
            PreparedStatement psDetail2 = con.prepareStatement(queryDetail2);
            psDetail2.setInt(1, od2.getOrderNumber());
            psDetail2.setString(2, od2.getProductCode());
            psDetail2.setInt(3, od2.getQuantityOrdered());
            psDetail2.setDouble(4, od2.getPriceEach());
            psDetail2.setInt(5, od2.getOrderLineNumber());
            psDetail2.executeUpdate();

            con.commit();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
