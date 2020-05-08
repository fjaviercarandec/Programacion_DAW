package Tarea7;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Peticiones {

    @GET("https://my-json-server.typicode.com/chemaduran/futbolistas_api_demo/jugadores")
    Call<List<Futbolista>> listFutbolistas();
}
