package Tarea8;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Peticiones {

    @GET("https://my-json-server.typicode.com/chemaduran/json_entrega1/alumnos?_embed=asignaturas")
    Call<List<Alumno>> listAlumnos();
}
