import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca sus 3 numeros de la suerte: ");
        char suerte1 = sc.nextLine().charAt(0);
        char suerte2 = sc.nextLine().charAt(0);
        char suerte3 = sc.nextLine().charAt(0);

        System.out.println("Introduzca su numero de la loteria: ");
        String numlotto = sc.nextLine();

        int contsuerte = 0;
        int sinsuerte = 0;

        for (int i = 0; i < numlotto.length(); i++) {
            if (suerte1==(numlotto.charAt(i)) || suerte2==(numlotto.charAt(i)) || suerte3==(numlotto.charAt(i))) {
                contsuerte++;
            } else {
                sinsuerte++;
            }
        }

        if (contsuerte>sinsuerte) {
            System.out.println("El numero le dara suerte.");
        } else {
            System.out.println("El numero no le dara suerte.");
        }
    }
}
