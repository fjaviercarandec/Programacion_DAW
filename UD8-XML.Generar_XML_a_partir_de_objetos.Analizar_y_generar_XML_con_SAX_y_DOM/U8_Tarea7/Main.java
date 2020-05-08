package Tarea7;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/chemaduran/futbolistas_api_demo/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Peticiones servicio = rf.create(Peticiones.class);

        System.out.println("Obtenemos el listado de jugadores");
        try {
            Response<List<Futbolista>> respuesta = servicio.listFutbolistas().execute();
            if (respuesta.isSuccessful()) {
                List<Futbolista> futbolistas = respuesta.body();
                System.out.println(futbolistas);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
