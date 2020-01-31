package entregaPOO5;

public class Motocicleta extends Terrestre {

    public Motocicleta(String nombre, int numMax, String matricula, int anyoFabricacion, Color color) {
        super(nombre, numMax, matricula, anyoFabricacion, color);
    }

    @Override
    public String toString() {
        return "Motocicleta { " + super.toString() + "\n";
    }
}
