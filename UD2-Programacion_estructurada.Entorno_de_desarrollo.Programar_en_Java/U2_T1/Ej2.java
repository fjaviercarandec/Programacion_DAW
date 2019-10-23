import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero entero positivo: ");
        long num = sc.nextLong();
        long aux = num;
        long aux1 = 0;

        while (num>0) {
            aux1 = (aux1*10)+(num%10);
            num = num/10;
        }

        if (aux == aux1) {
            System.out.println("El numero es capicua.");
        } else {
            System.out.println("El numero no es capicua.");
        }

    }
}
