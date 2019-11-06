import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el numero ");
        Long num = sc.nextLong();

        String aparece = "";
        String noaparece = "";

        String snum = num.toString();
        for (int i = 0; i <= 9; i++) {
            if (snum.contains(String.valueOf(i))) {
                aparece = aparece + i + " ";
            } else {
                noaparece = noaparece + i + " ";
            }
        }

        System.out.println("En " + num + " aparecen los numeros: " + aparece);
        System.out.println("En " + num + " no aparecen los numeros: " + noaparece);
    }
}
