package entregaPOO5;

public class Helicoptero extends Aereo {

    public Helicoptero(String nombre, int numMax, String codigo) {
        super(nombre, numMax, codigo);
    }

    @Override
    public String toString() {
        return "Tipo = " + getClass().getSimpleName() + ", " + super.codigo  + " }";
    }
}
