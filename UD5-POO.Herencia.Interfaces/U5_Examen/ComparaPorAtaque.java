package examen;

import java.util.Comparator;

public class ComparaPorAtaque implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Personaje p1 = (Personaje) o;
        Personaje p2 = (Personaje) t1;
        return p1.getAtaque() - p2.getAtaque();
    }
}
