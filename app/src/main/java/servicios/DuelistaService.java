package servicios;

import java.util.List;

import entidades.Duelista;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DuelistaService {
    @GET("Duelista")
    Call<List<Duelista>> getListDuelistas();

    @POST("Duelista")
    Call<Void> createDuelista(@Body Duelista duelista);

    @DELETE("Duelista/{id}")
    Call<Void> deleteDuelista(@Path("id")int id);
}
