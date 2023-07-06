package servicios;

import java.util.List;

import entidades.Carta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CartaService {
    @GET("Carta")
    Call<List<Carta>> getListCartas();

    @POST("Carta")
    Call<Void> createCarta(@Body Carta carta);

    @DELETE("Carta/{id}")
    Call<Void> deleteCarta(@Path("id")int id);
}
