package Tarea5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //ArrayList de Futbolista. Añadimos todos los futbolistas con sus atributos.
        ArrayList<Futbolista> futbolistas = new ArrayList<>();
        futbolistas.add(new Futbolista(1, "Casillas", new ArrayList<>(Arrays.asList("Portero")) ,"Real Madrid"));
        futbolistas.add(new Futbolista(15, "Ramos", new ArrayList<>(Arrays.asList("Lateral derecho", "Medio centro")) ,"Real Madrid"));
        futbolistas.add(new Futbolista(3, "Pique", new ArrayList<>(Arrays.asList("Central")) ,"FC Barcelona"));
        futbolistas.add(new Futbolista(5, "Puyol", new ArrayList<>(Arrays.asList("Central")) ,"FC Barcelona"));
        futbolistas.add(new Futbolista(11, "Capdevila", new ArrayList<>(Arrays.asList("Lateral izquierdo")) ,"Villareal"));
        futbolistas.add(new Futbolista(14, "Xabi Alonso", new ArrayList<>(Arrays.asList("Defensa mediocampo")) ,"FC Barcelona"));
        futbolistas.add(new Futbolista(16, "Xavi Hernandez", new ArrayList<>(Arrays.asList("Mediocampo")) ,"FC Barcelona"));
        futbolistas.add(new Futbolista(18, "Pedrito", new ArrayList<>(Arrays.asList("Extremo izquierdo", "Falso extremo")) ,"FC Barcelona"));
        futbolistas.add(new Futbolista(6, "Iniesta", new ArrayList<>(Arrays.asList("Extremo derecho", "Mediocampo")) ,"FC Barcelona"));
        futbolistas.add(new Futbolista(7, "Villa", new ArrayList<>(Arrays.asList("Delantero centro")) ,"FC Barcelona"));

        //Objeto Gson para convertir
        Gson gson = new Gson();
        //Variable string sobre la que almacenaremos cada Json.
        String json = gson.toJson(futbolistas);
        System.out.println(json);

        //U8: Tarea 6
        Type listType = new TypeToken<ArrayList<Futbolista>>() {}.getType();
        ArrayList<Futbolista> arrayFutbolistas = new ArrayList<>();
        arrayFutbolistas = gson.fromJson(json, listType);
        System.out.println(arrayFutbolistas);
        //Saco demarcaciones
        for (Futbolista f: arrayFutbolistas) {
            if (f.getNombre().equals("Ramos")) {
                System.out.println(f.getDemarcaciones());
            }
        }
        
    }
}
