package entregaPOO5;

import java.util.Comparator;

public class ComparaAñoTerrestre implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Terrestre ter1 = (Terrestre) o;
        Terrestre ter2 = (Terrestre) t1;
        return ter1.anyoFabricacion - ter2.anyoFabricacion;
    }
}
