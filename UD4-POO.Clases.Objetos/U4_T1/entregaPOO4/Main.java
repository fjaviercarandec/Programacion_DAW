package entregaPOO4;

public class Main {
    public static void main(String[] args) {

        Ingrediente ingre1 = new Ingrediente();
        Ingrediente ingre2 = new Ingrediente();
        Ingrediente ingre3 = new Ingrediente("Jamón",300);
        Ingrediente ingre4 = new Ingrediente("Tomate", 150);

        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza(Pizza.Size.MEDIANA);

        System.out.println(pizza1.MostrarTamaños());

        pizza2.AddIngrediente(ingre1);
        pizza2.AddIngrediente(ingre2);
        pizza2.AddIngrediente(ingre3);
        pizza2.AddIngrediente(ingre4);
        System.out.println(pizza2.MostrarPizza());

        Pedido pedido1 = new Pedido(pizza2);
        System.out.println(pedido1.MostrarPedido());

        Pizzeria pizzeria1 = new Pizzeria();
        pizzeria1.AddPedido(pedido1);
        System.out.println(pizzeria1.getNumPedidos());
        System.out.println(pizzeria1.MostrarPedidos());
    }
}
