import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la altura: ");
        int altura = sc.nextInt();

        if (altura<5 || altura%2==0) {
            System.out.println("ERROR. La altura debe ser mayor o igual que 5 e impar.");
        } else {
            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < 6; j++) {
                    if (i == 0 || i == altura-1 || j == 0 || j == 5 || i == altura/2) {
                        System.out.print("M");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
