import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la altura de la flecha: ");
        int altura = sc.nextInt();

        if (altura<3 || altura%2==0) {
            System.out.println("ERROR! El numero debe ser mayor que 3 e impar.");
        } else {
            for (int i=0; i<=altura-1; i++) {
                for (int j=0; j<altura; j++) {
                    if (i<=altura/2) {
                        if (j==(altura/2)-i) {
                            System.out.printf("*     *");
                        } else {
                            System.out.printf(" ");
                        }
                    } else {
                        if (j==i-(altura/2)) {
                            System.out.printf("*     *");
                        } else {
                            System.out.printf(" ");
                        }
                    }

                }
                System.out.println();
            }
        }
    }
}
