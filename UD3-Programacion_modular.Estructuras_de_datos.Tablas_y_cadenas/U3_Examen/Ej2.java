public class Ej2 {
    public static int[] insertarValor (int[] v, int valor, int posicion) {
        int[] sol = new int[v.length+1];
        int j = 0;
        for (int i = 0; i < v.length; i++) {
            if (j == posicion) {
                sol[j] = valor;
                j++;
                i--;
            } else {
                sol[j] = v[i];
                j++;
            }
        }
        return sol;
    }
    public static void main(String[] args) {
        int[] v = {1,2,3,4,5};
        for (int i = 0; i < insertarValor(v,8,3).length; i++) {
            System.out.print(insertarValor(v,8,3)[i] + " | ");
        }
    }
}
