package Tarea5;

import com.google.gson.Gson;

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
        String json = "";

        //Recorremos el ArrayList y almacenamos cada objeto como Json
        for (Futbolista f: futbolistas) {
            json = json + "\n" + gson.toJson(f);
        }

        System.out.println(json);

    }
}
