import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double aux = 0;
        String numeros = "";
        int cont = 0;
        int mayor = 0;
        int menor = 0;

        boolean esprimo = false;
        while (!esprimo) {
            System.out.println("Introduzca un número entero positivo. Para terminar, introduzca un número primo:");
            Integer num = sc.nextInt();

            for (int i = 2; i < num; i++) {
                if (num%i == 0) {
                    esprimo = false;
                    aux = aux + num;

                    String s = num.toString();
                    numeros = numeros + s + " ";

                    if (cont == 0) {
                        mayor = num;
                        menor = num;
                    } else {
                        if (num > mayor) {
                            mayor = num;
                        }
                        if (num < menor) {
                            menor = num;
                        }
                    }
                    cont++;
                    break;
                } else {
                    esprimo = true;
                }
            }
        }

        System.out.println("Lista de numeros no primos: " + numeros);
        System.out.println("Se han introducido " + cont + " numeros no primos.");
        System.out.println("El maximo es " + mayor);
        System.out.println("El minimo es " + menor);
        System.out.println("La media de los numeros es " + aux/cont);
    }
}
