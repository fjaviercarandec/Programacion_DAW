package entregaPOO4;

import java.util.Arrays;

/**
 * Clase Pizza
 * Atributos: Ingrediente[] ingredientes | enum Size tamanyo | int numIngre.
 */
public class Pizza {
    private Ingrediente[] ingredientes;
    public enum Size {MEDIANA, FAMILIAR}
    private Size tamanyo;
    private int numIngre;

    /**
     * Constructor inicializa la lista Ingrediente[3] vacia.
     * @param tamanyo
     */
    public Pizza(Size tamanyo) {
        this.ingredientes = new Ingrediente[3];
        this.tamanyo = tamanyo;
        this.numIngre = 0;
    }

    /**
     * Constructor por defecto inicializa la lista Ingrediente[3] vacia y Size.FAMILIAR.
     */
    public Pizza() {
        this.ingredientes = new Ingrediente[3];
        this.tamanyo = Size.FAMILIAR;
        this.numIngre = 0;
    }

    /**
     * Cuenta el numero de ingredientes del objeto pizza.
     * @return
     */
    public int ContarIngrediente() {
        numIngre = 0;
        for (int i = 0; i < ingredientes.length ; i++) {
            if (ingredientes[i]!=null) {
                numIngre++;
            }
        }
        return numIngre;
    }

    /**
     * Añade ingrediente al array Ingredientes
     * @param ingrediente
     * @return
     */
    public boolean AddIngrediente (Ingrediente ingrediente) {
        if (ContarIngrediente() < 3) {
            ingredientes[ContarIngrediente()] = ingrediente;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Muestra los valores del enum Size.
     * @return
     */
    public String MostrarTamaños() {
        return Size.MEDIANA + " o " + Size.FAMILIAR;
    }

    /**
     * Muestra los ingredientes de la pizza y su Size.
     * @return
     */
    public String MostrarPizza() {
        String mostrar = "Pizza { ";
        for (int i = 0; i < ingredientes.length; i++) {
            if (ingredientes[i]!=null) {
                mostrar = mostrar + ingredientes[i].getNombre() + "|" + ingredientes[i].getCaloria() + " ";
            } else {
                mostrar = mostrar + "NULL ";
            }
        }
        mostrar = mostrar + tamanyo;
        return mostrar + " }";
    }
}
