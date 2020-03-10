import java.util.Comparator;

public class OrdenaPorPeso implements Comparator {
    @Override
    public int compare(Object o, Object t1) {
        Perro p1 = (Perro) o;
        Perro p2 = (Perro) t1;
        return p2.getPeso() - p1.getPeso();
    }
}
