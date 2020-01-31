package entregaPOO5;

public class Avion extends Aereo {

    public Avion(String nombre, int numMax, String codigo) {
        super(nombre, numMax, codigo);
    }

    @Override
    public String toString() {
        return "Tipo = " + getClass().getSimpleName() + ", " + super.codigo  + " }";
    }
}
