package Tarea8;

import Tarea5.Futbolista;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/chemaduran/json_entrega1/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Peticiones servicio = rf.create(Peticiones.class);

        System.out.println("Obtenemos el listado completo de alumnos");
        try {
            Response<List<Alumno>> respuesta = servicio.listAlumnos().execute();
            if (respuesta.isSuccessful()) {
                List<Alumno> alumnos = respuesta.body();
                System.out.println(alumnos);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
