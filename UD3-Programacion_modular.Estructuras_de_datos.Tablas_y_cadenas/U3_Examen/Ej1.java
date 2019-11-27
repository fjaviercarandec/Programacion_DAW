public class Ej1 {
    public static int maxMatriz (int[][] x) {
        int mayor = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j]>mayor) {
                    mayor = x[i][j];
                }
            }
        }
        return mayor;
    }
    public static void main(String[] args) {
        int[][] prueba = new int[3][3];
        for (int i = 0; i < prueba.length; i++) {
            for (int j = 0; j < prueba[i].length; j++) {
                int aleatorio = (int) (Math.random()*1001);
                prueba[i][j] = aleatorio;
                System.out.print(prueba[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("El mayor elemento es: " + maxMatriz(prueba));
    }
}
