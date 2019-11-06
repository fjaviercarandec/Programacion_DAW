import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero entero ");
        int num = sc.nextInt();
        System.out.println("Posicion por la cual quiere partir el numero ");
        int pos = sc.nextInt();

        int longnumero = 0;
        int aux = num;
        while (aux!=0) {
            aux = aux/10;
            longnumero++;
        }
        aux = num;

        if (pos < 2 || pos > longnumero) {
            System.out.println("ERROR. La posicion tiene que estar comprendida entre el 2 y la longitud del numero introducido.");
        } else {
            for (int i = 0; i < longnumero-pos+1; i++) {
                aux = aux/10;
            }
            System.out.println("Primera parte del numero: " + aux);

            for (int i = 0; i < longnumero-pos+1; i++) {
                aux = aux*10;
            }
            System.out.println("Segunda parte del numero: " + (num-aux));
        }
    }
}
