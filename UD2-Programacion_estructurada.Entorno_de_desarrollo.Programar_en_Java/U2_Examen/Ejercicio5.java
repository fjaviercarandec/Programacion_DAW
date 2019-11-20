import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduza horas: ");
        int horas = sc.nextInt();
        System.out.println("Introduzca minutos: ");
        int minutos = sc.nextInt();
        System.out.println("Introduzca segundos: ");
        int segundos = sc.nextInt();
        System.out.println("Introduzca segundos a incrementar: ");
        int incremento = sc.nextInt();

        System.out.println("Aumentando la hora...");
        for (int i = 0; i < incremento; i++) {
            segundos++;
            if (segundos==60) {
                segundos = 0;
                minutos++;
            }
            if (minutos==60) {
                minutos = 0;
                horas++;
            }
            if (horas==24) {
                horas = 0;
            }
            System.out.println(horas + " : " + minutos + " : " + segundos);
        }
    }
}
