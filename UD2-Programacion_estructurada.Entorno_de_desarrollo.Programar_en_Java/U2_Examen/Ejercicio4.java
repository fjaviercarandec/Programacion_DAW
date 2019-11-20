import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un numero entero positivo: ");
        int num = sc.nextInt();

        boolean noPrimo = false;

        for (int i = num; i < num+5; i++) {
            for (int j = 2; j < i; j++) {
                if (i%j==0) {
                    System.out.println(i + " no es primo.");
                    noPrimo = true;
                    break;
                }
            }
            if (!noPrimo) {
                System.out.println(i + " es primo.");
            }
            noPrimo = false;
        }
    }
}
