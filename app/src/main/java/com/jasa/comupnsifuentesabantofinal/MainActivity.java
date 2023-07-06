package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import DataBase.AppDatabase;
import entidades.Duelista;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import servicios.DuelistaService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button crear,ver,sincronizar;
        crear=findViewById(R.id.botCrearDuelista);
        ver=findViewById(R.id.botVerDuelistas);
        sincronizar=findViewById(R.id.botSincronizarDuelistas);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CrearDuelistaActivity.class);
                startActivity(intent);
            }
        });

        ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ListarDuelistasActivity.class);
                startActivity(intent);
            }
        });

        sincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDatabase db = AppDatabase.getInstance(MainActivity.this);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://64a49e01c3b509573b57af54.mockapi.io/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                DuelistaService services =retrofit.create(DuelistaService.class);

                services.getListDuelistas().enqueue(new Callback<List<Duelista>>() {
                    @Override
                    public void onResponse(Call<List<Duelista>> call, Response<List<Duelista>> response) {
                        List<Duelista> duelistas=response.body();
                        eliminar(duelistas);
                        enviarDuelistas();
                    }

                    @Override
                    public void onFailure(Call<List<Duelista>> call, Throwable t) {

                    }
                });

            }
        });
    }
    public void eliminar(List<Duelista> listaDuelistas){
        for(int i=0;i<listaDuelistas.size();i++){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://64a49e01c3b509573b57af54.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            DuelistaService services =retrofit.create(DuelistaService.class);

            services.deleteDuelista(listaDuelistas.get(i).id).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                }
            });
        }
    }
    public void enviarDuelistas(){
        AppDatabase db = AppDatabase.getInstance(MainActivity.this);
        List<Duelista> listaDuelistas = db.dbDao().getAllDuelistas();
        for(int i=0;i<listaDuelistas.size();i++){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://64a49e01c3b509573b57af54.mockapi.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            DuelistaService services =retrofit.create(DuelistaService.class);
            services.createDuelista(listaDuelistas.get(i)).enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                }
            });
        }
    }
}