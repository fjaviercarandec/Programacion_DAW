public class Ej4 {
    public static int[] filtraPrimos (int[] v) {
        int cont = 0;
        int div = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 1; j <= v[i]; j++) {
                if (v[i]%j==0) {
                    div++;
                }
            }
            if (div == 2 || div == 1) {
                cont++;
            }
            div = 0;
        }
        if (cont == 0) {
            int[] sol = {-1};
            return sol;
        } else {
            int[] primos = new int[cont];
            int p = 0;
            for (int i = 0; i < v.length; i++) {
                for (int j = 1; j <= v[i]; j++) {
                    if (v[i]%j==0) {
                        div++;
                    }
                }
                if (div == 2 || div == 1) {
                    primos[p] = v[i];
                    p++;
                }
                div = 0;
                }
            return primos;
        }
    }
    public static void main(String[] args) {
        int[] v = {1,2,4,11,8,5,12,13};
        for (int i = 0; i < filtraPrimos(v).length; i++) {
            System.out.print(filtraPrimos(v)[i] + " | ");
        }
    }
}
