public class Ejercicio3 {
    public static int[] filtraCon7 (int[] x) {
        int cont = 0;
        for (int i = 0; i < x.length; i++) {
            int aux = x[i];
            while (aux!=0) {
                if (aux%10==7 || aux==7) {
                    cont++;
                    break;
                }
                aux = aux/10;
            }
        }
        if (cont==0) {
            int[] s = {-1};
            return s;
        } else {
            int[] s = new int[cont];
            int j = 0;
            for (int i = 0; i < x.length; i++) {
                int aux = x[i];
                while (aux!=0) {
                    if (aux%10==7 || aux==7) {
                        s[j] = x[i];
                        j++;
                        break;
                    }
                    aux = aux/10;
                }
            }
            return s;
        }
    }
    public static void main(String[] args) {
        int[] prueba = {1,2,3,4,5,7};
        for (int i = 0; i < filtraCon7(prueba).length; i++) {
            System.out.print(filtraCon7(prueba)[i] + " | ");
        }
    }
}
