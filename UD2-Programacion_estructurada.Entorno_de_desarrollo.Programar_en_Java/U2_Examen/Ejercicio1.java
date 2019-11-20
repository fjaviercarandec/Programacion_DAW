import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la talla del calcetin: ");
        int talla = sc.nextInt();

        if (talla<4) {
            System.out.println("La talla debe ser mayor o igual que 4.");
        } else {
            for (int i = 0; i < talla-2; i++) {
                System.out.println("***     ***");
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("******  ******");
            }
        }
    }
}
