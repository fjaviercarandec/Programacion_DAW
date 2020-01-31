package entregaPOO5;

import java.util.Comparator;
import java.util.Objects;

public abstract class Terrestre extends Vehiculo implements Comparable {
    protected String matricula;
    protected int anyoFabricacion;
    enum Color {AZUL, AMARILLO, ROJO, VERDE};
    protected Color color;

    public Terrestre(String nombre,int numMax ,String matricula, int anyoFabricacion, Color color) {
        super(nombre, numMax);
        this.matricula = matricula;
        this.anyoFabricacion = anyoFabricacion;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terrestre terrestre = (Terrestre) o;
        return matricula.equals(terrestre.matricula);
    }

    @Override
    public int compareTo(Object o) {
        return matricula.compareTo(((Terrestre) o).matricula);
    }

    @Override
    public String toString() {
        return super.toString() + " Terrestre {" +
                " Matricula = " + matricula +
                ", Anyo Fabricacion = " + anyoFabricacion +
                ", Color = " + color + " }";
    }
}
