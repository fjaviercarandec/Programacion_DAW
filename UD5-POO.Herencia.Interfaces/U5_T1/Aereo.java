package entregaPOO5;

public abstract class Aereo extends Vehiculo {
    protected Double altitud;
    protected String codigo;

    public Aereo(String nombre, int numMax, String codigo) {
        super(nombre, numMax);
        this.codigo = codigo;
        this.altitud = 0.0;
    }

    public String tipoAeronave() {
        return getClass().getSimpleName() + ", " + altitud;
    }

    @Override
    public String toString() {
        return super.toString() + " Aereo {" +
                " Altitud = " + altitud +
                ", Codigo = " + codigo + " }";
    }
}
