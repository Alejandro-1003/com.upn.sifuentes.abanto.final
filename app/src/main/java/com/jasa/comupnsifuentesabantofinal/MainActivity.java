package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import DataBase.AppDatabase;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

            }
        });
    }
}