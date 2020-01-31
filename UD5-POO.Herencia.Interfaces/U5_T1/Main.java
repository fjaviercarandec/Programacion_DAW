package entregaPOO5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Vehiculo[] vehiculos = new Vehiculo[6];

        //Creo 3 coches.
        vehiculos[0] = new Coche("Coche1", 5, "222BBB", 2003, Terrestre.Color.AZUL);
        vehiculos[1] = new Coche("Coche2", 4, "333CCC", 2001, Terrestre.Color.ROJO);
        vehiculos[2] = new Coche("Coche3", 5, "111AAA", 2002, Terrestre.Color.AMARILLO);

        //Creo 3 motocicletas.
        vehiculos[3] = new Motocicleta("Moto1", 1, "222BBB", 2003, Terrestre.Color.AZUL);
        vehiculos[4] = new Motocicleta("Moto2", 2, "333CCC", 2001, Terrestre.Color.ROJO);
        vehiculos[5] = new Motocicleta("Moto3", 1, "111AAA", 2002, Terrestre.Color.AMARILLO);

        //Creo un helicoptero y una avioneta.
        Helicoptero h1 = new Helicoptero("Helicoptero1", 10, "UP-A300I");
        Avion a1 = new Avion("Avion1", 10, "UP-A100I");

        //Ordeno los vehiculos y muestro.
        Arrays.sort(vehiculos);
        System.out.println(Arrays.deepToString(vehiculos));

        Arrays.sort(vehiculos, new ComparaAñoTerrestre());
        System.out.println(Arrays.deepToString(vehiculos));

        //Añado 9 personas al helicoptero.
        h1.transportar(9);
        System.out.println("Numero de pasajeros = " + h1.numPasajeros);

        //Muestro contenido del helicoptero.
        System.out.println(h1.toString());

    }
}
