import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] array = new int[4][5];
        int[][] arrayMedia = new int[5][6];


        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduzca la fila " + i + " de numero enteros.");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = sc.nextInt();
                arrayMedia[4][5] = arrayMedia[4][5] + array[i][j];
                arrayMedia[i][j] = array[i][j];
            }
        }
        arrayMedia[4][5] = arrayMedia[4][5]/20;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arrayMedia[i][5] = arrayMedia[i][5] + array[i][j];
            }
            arrayMedia[i][5] = arrayMedia[i][5]/5;
        }

        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                arrayMedia[4][i] = arrayMedia[4][i] + array[j][i];
            }
            arrayMedia[4][i] = arrayMedia[4][i]/4;
        }

        for (int i = 0; i < arrayMedia.length; i++) {
            for (int j = 0; j < arrayMedia[i].length; j++) {
                System.out.print(arrayMedia[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
