package entregaPOO4;

import java.util.Calendar;

/**
 * Clase Pedido
 * Atributos: Pizza pizza | Calendar fecha.
 */
public class Pedido {
    private Pizza pizza;
    private Calendar fecha;

    /**
     * Constructor inicializa pizza y la fecha de la creacion del objeto.
     * @param pizza
     */
    public Pedido(Pizza pizza) {
        this.pizza = pizza;
        this.fecha = Calendar.getInstance();
    }

    /**
     * Constructor por defecto. Inicializa una pizza con dos ingredientes y la fecha de creacion del objeto.
     */
    public Pedido() {
        this.pizza = new Pizza(Pizza.Size.FAMILIAR);
        pizza.AddIngrediente(new Ingrediente("jamon iberico",300));
        pizza.AddIngrediente(new Ingrediente());
        this.fecha = Calendar.getInstance();
    }

    /**
     * Muestra la pizza con su fecha.
     * @return
     */
    public String MostrarPedido() {
        return "Pedido {" + pizza.MostrarPizza() + " { " + (fecha.get(Calendar.DATE)) + "/"
                + (fecha.get(Calendar.MONTH)) + "/" + (fecha.get(Calendar.YEAR)) + " }";
    }
}
