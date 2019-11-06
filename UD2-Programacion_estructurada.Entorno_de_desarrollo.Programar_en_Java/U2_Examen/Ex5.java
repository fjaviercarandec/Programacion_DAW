import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un texto o frase ");
        String cad = sc.nextLine();
        cad = cad.toLowerCase();

        int cont = 0;

        for (int i = 0; i < cad.length(); i++) {
            if (cad.charAt(i)=='a' || cad.charAt(i)=='e' || cad.charAt(i)=='i' || cad.charAt(i)=='o' || cad.charAt(i)=='u') {
                cont++;
            }
        }

        System.out.println("La cantidad de vocales es " + cont);
    }
}
