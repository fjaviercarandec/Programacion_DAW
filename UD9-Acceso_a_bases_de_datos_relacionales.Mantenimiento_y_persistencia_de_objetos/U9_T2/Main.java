package Tarea9;

public class Main {
    public static void main(String[] args) {
        ADClassicModels base = new ADClassicModels();

        System.out.println(base.getEmpleados());
        System.out.println(base.getOficinas());

        ConexionDB.closeConnection();

    }
}
