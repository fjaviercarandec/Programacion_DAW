import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la nota del primer control: ");
        float nota1 = sc.nextFloat();
        System.out.println("Introduce la nota del segundo control: ");
        float nota2 = sc.nextFloat();
        System.out.println("Introduce la nota del tercer control: ");
        float nota3 = sc.nextFloat();

        float media = (nota1 + nota2 + nota3)/3;

        if (media<5) {
            System.out.println("¿Cual ha sido el resultado de la recuperación? (Apto|No apto)");
            String recup = sc.next();
            if (recup.contentEquals("Apto")) {
                System.out.println("Tu nota media en Programacion es 5 - Suficiente.");
            } else {
                System.out.println("Tu nota media en Programacion es " +media+ " - Suspendido");
            }
        } else {
            if (media>=5 && media<6) {
                System.out.println("Tu nota media en Programacion es " +media+ " - Suficiente.");
            } else if (media>=6 && media<7) {
                System.out.println("Tu nota media en Programacion es " +media+ " - Bien.");
            } else if (media>=7 && media<9) {
                System.out.println("Tu nota media en Programacion es " +media+ " - Notable.");
            } else if (media>=9) {
                System.out.println("Tu nota media en Programacion es " +media+ " - Sobresaliente.");
            }
        }
    }
}
