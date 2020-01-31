package entregaPOO5;

public class Coche extends Terrestre {

    public Coche(String nombre, int numMax, String matricula, int anyoFabricacion, Color color) {
        super(nombre, numMax, matricula, anyoFabricacion, color);
    }

    @Override
    public String toString() {
        return "Coche { " + super.toString() + "\n";
    }
}
