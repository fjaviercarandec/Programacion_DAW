import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una palabra: ");
        String cad = sc.next();
        int altura = cad.length();

        for (int i=0; i<=altura-1; i++) {
            for (int j=0; j<altura; j++) {
                if (i<=altura/2) {
                    if (j<(altura/2)-i || j>(altura/2)+i) {
                        System.out.printf("+");
                    } else {
                        System.out.printf("*");
                    }
                } else {
                    if (j<i-(altura/2)) {
                        System.out.printf("+");
                    } else {
                        System.out.printf("*");
                    }
                }

            }
            System.out.println();
        }
    }
}
