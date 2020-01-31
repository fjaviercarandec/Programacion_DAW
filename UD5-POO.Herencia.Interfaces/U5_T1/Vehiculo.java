package entregaPOO5;

public abstract class Vehiculo {
    protected String nombre;
    protected int numMax;
    protected int numPasajeros;

    public Vehiculo(String nombre, int numMax) {
        this.nombre = nombre;
        this.numMax = numMax;
    }

    public void transportar(int numPasajeros) {
        if (numMax - numPasajeros >= 0) {
            this.numPasajeros = numPasajeros;
        }
    }

    @Override
    public String toString() {
        return "Nombre = " + nombre + ", NumeroMaxPasajeros = " + numMax + " }";
    }
}
