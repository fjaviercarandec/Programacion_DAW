import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un numero para pasarlo a binario: ");
        int num = sc.nextInt();
        String aux = "";
        while (num!=0) {
            if (num%2==0) {
                aux = aux + "0";
            } else if (num%2!=0) {
                aux = aux + "1";
            }
            num=num/2;
        }
        for (int i=aux.length()-1; i>=0; i--) {
            System.out.printf("%c",aux.charAt(i));
        }
    }
}
