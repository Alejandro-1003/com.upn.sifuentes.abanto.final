package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import DataBase.AppDatabase;
import entidades.Carta;
import entidades.Duelista;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import servicios.CartaService;
import servicios.DuelistaService;

public class VisualizarDuelistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_duelista);

        Bundle data=getIntent().getExtras();
        int idDuelista=data.getInt("id");
        String nombreDuelista=data.getString("nombre");

        Button CrearCarta,VerCartas,SincronizarCartas,SincronizarCartasApi;
        TextView tvNombreDuelista=findViewById(R.id.tvNombreDuelista);
        tvNombreDuelista.setText(nombreDuelista);

        CrearCarta=findViewById(R.id.botRegistrarCarta);
        VerCartas=findViewById(R.id.botVerCartas);
        SincronizarCartas=findViewById(R.id.botSincronizarCartas);
        SincronizarCartasApi=findViewById(R.id.botSincronizarCartaApi);

        CrearCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(VisualizarDuelistaActivity.this,CrearCartaActivity.class);
                intent.putExtra("idDuelista",idDuelista);
                startActivity(intent);
            }
        });

        VerCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(VisualizarDuelistaActivity.this,ListarCartasActivity.class);
                intent.putExtra("idDuelista",idDuelista);
                startActivity(intent);
            }
        });

        SincronizarCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getInstance(VisualizarDuelistaActivity.this);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://64a49e01c3b509573b57af54.mockapi.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                CartaService services =retrofit.create(CartaService.class);

                services.getListCartas().enqueue(new Callback<List<Carta>>() {
                    @Override
                    public void onResponse(Call<List<Carta>> call, Response<List<Carta>> response) {
                        List<Carta> cartas=response.body();
                        eliminar(cartas);
                        enviarCartas();
                    }

                    @Override
                    public void onFailure(Call<List<Carta>> call, Throwable t) {
                    }
                });
            }
        });

        SincronizarCartasApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getInstance(VisualizarDuelistaActivity.this);
                List<Carta> cartas=db.dbDao().getAllCartas();
                for(int i=0;i<cartas.size();i++){
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://64a49e01c3b509573b57af54.mockapi.io/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    CartaService services =retrofit.create(CartaService.class);
                    services.createCarta(cartas.get(i)).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {

                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }
    public void eliminar(List<Carta> listaCartas){
        for(int i=0;i<listaCartas.size();i++){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://64a49e01c3b509573b57af54.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CartaService services =retrofit.create(CartaService.class);

            services.deleteCarta(listaCartas.get(i).id).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
    }
    public void enviarCartas() {
        AppDatabase db = AppDatabase.getInstance(VisualizarDuelistaActivity.this);
        List<Carta> listaCartas = db.dbDao().getAllCartas();
        for (int i = 0; i < listaCartas.size(); i++) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://64a49e01c3b509573b57af54.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CartaService services = retrofit.create(CartaService.class);
            services.createCarta(listaCartas.get(i)).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
        Toast toast = Toast.makeText(VisualizarDuelistaActivity.this, "Se sincronizó la api con la base de datos", Toast.LENGTH_SHORT);
        toast.show();
    }

}