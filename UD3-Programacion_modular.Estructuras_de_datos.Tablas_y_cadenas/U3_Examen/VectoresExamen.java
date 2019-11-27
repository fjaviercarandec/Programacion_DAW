public class VectoresExamen {
    public static String[] unir (String[] v1, String[] v2) {
        String[] sol = new String[v1.length+v2.length];
        int pos = 0;
        for (int i = 0; i < v2.length; i++) {
            sol[pos] = v2[i];
            pos++;
        }
        for (int i = 0; i < v1.length; i++) {
            sol[pos] = v1[i];
            pos++;
        }
        return sol;
    }

    public static String[] rotar (String[] v1, int pos) {
        String[] sol = new String[v1.length];
        int aux = 0;
        for (int i = (v1.length-pos); i < v1.length; i++) {
            sol[aux] = v1[i];
            aux++;
        }
        aux = pos;
        for (int i = 0; i < (v1.length-pos); i++) {
            sol[aux] = v1[i];
            aux++;
        }
        return sol;
    }
}
