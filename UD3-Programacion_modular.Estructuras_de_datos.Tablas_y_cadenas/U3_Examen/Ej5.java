public class Ej5 {
    public static void main(String[] args) {
        //Prueba unir
        String[] s1 = {"a","b","c"};
        String[] s2 = {"d","e","f"};
        for (int i = 0; i < VectoresExamen.unir(s1,s2).length; i++) {
            System.out.print(VectoresExamen.unir(s1,s2)[i] + " | ");
        }

        System.out.println();

        //Prueba rotar
        String[] s = {"a","b","c","d","e","f"};
        for (int i = 0; i < s.length; i++) {
            System.out.print(VectoresExamen.rotar(s,6)[i] + " | ");
        }

    }
}
