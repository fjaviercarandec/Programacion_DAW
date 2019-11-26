public class Ejercicio4 {
    public static String convierteArrayEnString (int[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s = s + a[i];

        }
        return s;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(convierteArrayEnString(a));
    }
}
