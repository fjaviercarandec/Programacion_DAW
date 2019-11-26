public class Ejercicio5 {
    public static int aleatorioDeArray (int[] a) {
        int aleatorio = (int) (Math.random()*(a.length+1));
        return a[aleatorio];
    }
    public static void main(String[] args) {
        int[] a = {111,222,333,444};
        System.out.println(aleatorioDeArray(a));

    }
}
