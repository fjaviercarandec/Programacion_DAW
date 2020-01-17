package entregaPOO4;

import java.util.Arrays;

/**
 * Clase Pizzeria
 * Atributos: Pedido[] pedidos | int numPedidos.
 */
public class Pizzeria {
    private Pedido[] pedidos;
    private int numPedidos;

    /**
     * Constructor por defecto. Inicializa una pizzeria con array Pedido[5]
     */
    public Pizzeria() {
        this.pedidos = new Pedido[5];
        this.numPedidos = 0;
    }

    /**
     * Añade un pedido al array y en caso de superar tamaño la aumenta en 1.
     * @param pedido
     */
    public void AddPedido(Pedido pedido) {
        if (numPedidos < pedidos.length) {
            pedidos[numPedidos] = pedido;
        } else {
            this.pedidos = Arrays.copyOf(pedidos, pedidos.length+1);
            this.pedidos[pedidos.length-1] = pedido;
        }
        numPedidos++;
    }

    /**
     * Devuelve el numero de pedidos.
     * @return
     */
    public int getNumPedidos() {
        return numPedidos;
    }

    /**
     * Muestra los pedidos.
     * @return
     */
    public String MostrarPedidos() {
        String mostrar = "Pedidos { ";
        for (int i = 0; i < numPedidos ; i++) {
            mostrar = mostrar + pedidos[i].MostrarPedido() + " ";
        }
        return mostrar;
    }
}
