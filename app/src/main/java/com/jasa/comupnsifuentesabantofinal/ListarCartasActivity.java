package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import DataBase.AppDatabase;
import adapters.CartasAdapter;
import entidades.Carta;

public class ListarCartasActivity extends AppCompatActivity {
    RecyclerView listaCartas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle data=getIntent().getExtras();
        int idDuelista=data.getInt("idDuelista");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cartas);
        listaCartas=findViewById(R.id.listaCartas);
        AppDatabase db = AppDatabase.getInstance(ListarCartasActivity.this);
        List<Carta> cartasEncontradas = db.dbDao().findCartas(idDuelista);

        listaCartas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listaCartas.setAdapter(new CartasAdapter(cartasEncontradas));


    }
}