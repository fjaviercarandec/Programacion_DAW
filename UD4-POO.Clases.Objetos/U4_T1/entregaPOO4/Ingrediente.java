package entregaPOO4;

/**
 * Clase Ingrediente
 * Atributos: String nombre | int caloria
 */
public class Ingrediente {
    private String nombre;
    private int caloria;

    /**
     * Contructor
     * @param nombre
     * @param caloria
     */
    public Ingrediente(String nombre, int caloria) {
        this.nombre = nombre;
        this.caloria = caloria;
    }

    /**
     * Constructor por defecto. Nombre = "Queso" | Caloria = 250.
     */
    public Ingrediente() {
        this.nombre = "Queso";
        this.caloria = 250;
    }

    /**
     * Devuelve el nombre.
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre.
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve caloria.
     * @return
     */
    public int getCaloria() {
        return caloria;
    }

    /**
     * Actualiza caloria.
     * @param caloria
     */
    public void setCaloria(int caloria) {
        this.caloria = caloria;
    }
}
