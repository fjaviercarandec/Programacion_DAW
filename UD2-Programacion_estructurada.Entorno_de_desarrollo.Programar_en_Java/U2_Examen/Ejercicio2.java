import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un numero entero positivo: ");
        int num = sc.nextInt();
        int cont = 0;
        int sol = 0;
        int eliminados = 0;

        if (num<0) {
            System.out.println("ERROR. El numero debe ser positivo.");
        } else {
            int aux = num;
            while (aux!=0) {
                if (aux%10==0 || aux%10==8) {
                    aux = aux/10;
                    eliminados++;
                } else {
                    sol = sol + (int) ((Math.pow(10,cont))*(aux%10));
                    aux = aux/10;
                    cont++;
                }
            }
            System.out.println("Resultado: " + sol);
            System.out.println("Numeros eliminados: " + eliminados);
        }
    }
}
