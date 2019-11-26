import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Num mesa | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");

        int[] ocupacion = new int[10];
        System.out.print("Ocupacion | ");
        for (int i = 0; i < ocupacion.length; i++) {
            int aleatorio = (int) (Math.random()*5);
            ocupacion[i] = aleatorio;
            System.out.print(ocupacion[i] + " | ");
        }
        System.out.println();

        int num = 0;
        boolean mesavacia = false;
        boolean sinsitio = false;
        while (num!=-1) {
            System.out.println("¿Cuántos son? (Introduzca -1 para salir del programa):");
            num = sc.nextInt();
            if (num==-1) {
                System.out.println("Gracias. Hasta pronto.");
            } else {
                if (num>4) {
                    System.out.println("Lo siento, no admitimos grupos de 6, haga grupos de 4 personas como máximo e intente de nuevo");
                } else {
                    for (int i = 0; i < ocupacion.length; i++) {
                        if (ocupacion[i]==0) {
                            mesavacia = true;
                            ocupacion[i] = num;
                            System.out.println("Por favor, siéntense en la mesa número " + (i + 1));
                            break;
                        }
                    }
                    if (!mesavacia) {
                        for (int i = 0; i < ocupacion.length; i++) {
                            if (ocupacion[i]+num <= 4) {
                                ocupacion[i] = ocupacion[i]+num;
                                System.out.println("Tendrán que compartir mesa. Por favor, siéntense en la mesa número " + (i+1));
                                break;
                            } else {
                                sinsitio = true;
                            }
                        }
                    }
                    if (sinsitio) {
                        System.out.println("Lo siento, en estos momentos no queda sitio.");
                        sinsitio = false;
                    }
                    mesavacia = false;

                    System.out.println("Num mesa | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");
                    System.out.print("Ocupacion | ");
                    for (int i = 0; i < ocupacion.length; i++) {
                        System.out.print(ocupacion[i] + " | ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
