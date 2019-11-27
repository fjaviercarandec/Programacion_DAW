import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca la posición del alfil (primero letra, luego numero): ");
        String pos = sc.nextLine();

        String[][] tablero = {{"a8","b8","c8","d8","e8","f8","g8","h8"},
                {"a7","b7","c7","d7","e7","f7","g7","h7"},
                {"a6","b6","c6","d6","e6","f6","g6","h6"},
                {"a5","b5","c5","d5","e5","f5","g5","h5"},
                {"a4","b4","c4","d4","e4","f4","g4","h4"},
                {"a3","b3","c3","d3","e3","f3","g3","h3"},
                {"a2","b2","c2","d2","e2","f2","g2","h2"},
                {"a1","b1","c1","d1","e1","f1","g1","h1"}};

        int x = 0;
        int y = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].equals(pos)) {
                    x = i;
                    y = j;
                }
            }
        }
        int auxX = x;
        int auxY = y;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (!tablero[i][j].equals(pos)) {
                    if (((i == x - auxX) && (j == y - auxY)) || ((i == x + auxX) && (j == y - auxY))
                    || ((i == x - auxX) && (j == y + auxY)) || ((i == x + auxX) && (j == y + auxY))) {
                        System.out.print(tablero[i][j] + " | ");
                    }
                }
            }
            auxX--;
            auxY--;
        }
    }
}
