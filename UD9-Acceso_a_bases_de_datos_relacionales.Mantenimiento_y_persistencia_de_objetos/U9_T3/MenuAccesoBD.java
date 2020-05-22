package Tarea3;

import java.sql.*;
import java.util.Scanner;

public class MenuAccesoBD {
    private static Connection con = ConexionDB.getConnection();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aux = 0;

        try {
            while (aux!=5) {
                //Menu
                System.out.println("Selecciona una opcion del menu:");
                System.out.println("1. Insertar cliente");
                System.out.println("2. Asignar empleado a cliente");
                System.out.println("3. Añadir producto a pedido");
                System.out.println("4. Mostrar detalles de un pedido");
                System.out.println("5. Salir");
                aux = sc.nextInt();
                sc.nextLine();

                //Control de menu
                switch (aux) {
                    case 1:
                        System.out.println("Introduzca el numero del cliente:");
                        int num = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduzca el nombre del cliente:");
                        String nom = sc.nextLine();
                        System.out.println("Introduzca el nombre del contacto:");
                        String contnom = sc.nextLine();
                        System.out.println("Introduzca el apellido del contacto:");
                        String contape = sc.nextLine();
                        System.out.println("Introduzca el numero de telefono:");
                        String tlf = sc.nextLine();
                        System.out.println("Introduzca la direccion:");
                        String dir = sc.nextLine();
                        System.out.println("Introduzca la ciudad:");
                        String ciu = sc.nextLine();
                        System.out.println("Introduzca el pais:");
                        String pais = sc.nextLine();
                        addCustomer(num, nom, contnom, contape, tlf, dir, ciu, pais);
                        break;
                    case 2:
                        System.out.println("Introduzca el numero de Empleado");
                        int numEmp = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduzca el numero de Cliente");
                        int numCust = sc.nextInt();
                        sc.nextLine();
                        assignEmployeeToCustomer(numEmp, numCust);
                        break;
                    case 3:
                        System.out.println("Introduzca el codigo del Producto");
                        String prodCode = sc.nextLine();
                        System.out.println("Introduzca el numero del Pedido");
                        int orderNum = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Introduzca la cantidad");
                        int quantity = sc.nextInt();
                        sc.nextLine();
                        assignProductToOrder(prodCode, orderNum, quantity);
                        break;
                    case 4:
                        System.out.println("Introduzca el numero del Pedido");
                        int orderNumber = sc.nextInt();
                        sc.nextLine();
                        showOrderDetails(orderNumber);
                        break;
                    case 5:
                        System.out.println("Cerrando conexion...");
                        con.close();
                        break;
                    default:
                        System.out.println("Opcion erronea.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addCustomer(int num, String nom, String contnom, String contape, String tlf, String dir, String ciu, String pais) {
        try {
            String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, " +
                    "addressLine2, city, state, postalCode, country, creditLimit) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,num);
            ps.setString(2,nom);
            ps.setString(3,contnom);
            ps.setString(4,contape);
            ps.setString(5,tlf);
            ps.setString(6,dir);
            ps.setString(7,null);
            ps.setString(8,ciu);
            ps.setString(9,null);
            ps.setString(10,null);
            ps.setString(11,pais);
            ps.setNull(12, Types.FLOAT);
            System.out.println(ps.toString());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void assignEmployeeToCustomer(int empNum, int custNum) {
        try {
            String queryEmp = "SELECT * FROM employees WHERE employeeNumber = ?";
            PreparedStatement psEmp = con.prepareStatement(queryEmp);
            psEmp.setInt(1, empNum);
            ResultSet rsEmp = psEmp.executeQuery();

            if (rsEmp.next()) {
                String queryCust = "SELECT * FROM customers WHERE customerNumber = ?";
                PreparedStatement psCust = con.prepareStatement(queryCust);
                psCust.setInt(1, custNum);
                ResultSet rsCust = psCust.executeQuery();

                if (rsCust.next()) {
                    String query = "UPDATE customers SET salesRepEmployeeNumber = ? WHERE customerNumber = ?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setInt(1, empNum);
                    ps.setInt(2, custNum);
                    ps.executeUpdate();
                } else {
                    System.out.println("ERROR. No existe dicho cliente.");
                }
            } else {
                System.out.println("ERROR. No existe dicho empleado.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void assignProductToOrder(String prodCode, int orderNum, int quantity) {
        try {
            String queryOrder = "SELECT * FROM orders WHERE orderNumber = ?";
            PreparedStatement psOrder = con.prepareStatement(queryOrder);
            psOrder.setInt(1, orderNum);
            ResultSet rsOrder = psOrder.executeQuery();

            if (rsOrder.next()) {
                String queryProdInOrder = "SELECT quantityOrdered FROM orderdetails WHERE orderNumber = ? AND productCode = ?";
                PreparedStatement psProdInOrder = con.prepareStatement(queryProdInOrder);
                psProdInOrder.setInt(1, orderNum);
                psProdInOrder.setString(2, prodCode);
                ResultSet rsProdInOrder = psProdInOrder.executeQuery();

                if (rsProdInOrder.next()) {
                    quantity = quantity + rsProdInOrder.getInt("quantityOrdered");
                    String queryQuantity = "UPDATE orderdetails SET quantityOrdered = ? WHERE orderNumber = ? AND productCode = ?";
                    PreparedStatement psQuantity = con.prepareStatement(queryQuantity);
                    psQuantity.setInt(1, quantity);
                    psQuantity.setInt(2, orderNum);
                    psQuantity.setString(3, prodCode);
                    psQuantity.executeUpdate();
                } else {
                    String queryPrice = "SELECT MSRP FROM WHERE productCode = ?";
                    PreparedStatement psPrice = con.prepareStatement(queryPrice);
                    psPrice.setString(1, prodCode);
                    ResultSet rsPrice = psPrice.executeQuery();
                    if (rsPrice.next()) {
                        double priceEach = rsPrice.getDouble("MSRP");

                        String queryOrderLineNumber = "SELECT orderLineNumber FROM orderdetails WHERE orderNumber = ? ORDER BY orderLineNumber DESC";
                        PreparedStatement psOrderLineNumber = con.prepareStatement(queryOrderLineNumber);
                        psOrderLineNumber.setInt(1, orderNum);
                        ResultSet rsOrderLineNumber = psOrderLineNumber.executeQuery();
                        int orderLineNumber = 0;
                        if (rsOrderLineNumber.next()) {
                            orderLineNumber = rsOrderLineNumber.getInt("orderLineNumber");
                        }

                        String query = "INSERT INTO orderdetails (orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) values (?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(query);
                        ps.setInt(1, orderNum);
                        ps.setString(2, prodCode);
                        ps.setInt(3, quantity);
                        ps.setDouble(4, priceEach);
                        ps.setInt(5, ++orderLineNumber);
                        ps.executeUpdate();
                    } else {
                        System.out.println("ERROR. No existe dicho producto");
                    }
                }
            } else {
                System.out.println("ERROR. No existe dicho pedido.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showOrderDetails(int orderNumber) {
        try {
            String query = "SELECT o.orderDate, o.requiredDate, o.shippedDate, o.comments, o.customerNumber, p.productName, " +
                    "od.quantityOrdered, od.priceEach, (od.quantityOrdered * od.priceEach) AS total FROM orderdetails od " +
                    "INNER JOIN products p ON p.productCode = od.productCode INNER JOIN orders o ON o.orderNumber = od.orderNumber " +
                    "WHERE o.orderNumber = ? ORDER BY p.productName";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, orderNumber);
            ResultSet rs = ps.executeQuery();
            double total = 0;
            while (rs.next()) {
                total = total + rs.getDouble("total");
                System.out.println("=================================================================================");
                System.out.println("OrderDate = " + rs.getDate("orderDate") + " RequiredDate = " + rs.getDate("requiredDate") + " ShippedDate = " + rs.getDate("shippedDate") + "\n"
                + "ProducName = " + rs.getString("productName") + " Quantity = " + rs.getInt("quantityOrdered") + " PriceEach = " + rs.getDouble("priceEach") + "\n"
                + "Comments = " + rs.getString("comments"));
                System.out.println("=================================================================================");
            }
            System.out.println("Total del pedido = " + total);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
