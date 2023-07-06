package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import DataBase.AppDatabase;
import adapters.DuelistasAdapter;
import entidades.Duelista;

public class ListarDuelistasActivity extends AppCompatActivity {
    RecyclerView listaDuelistas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_duelistas);
        listaDuelistas=findViewById(R.id.listaDuelistas);
        AppDatabase db = AppDatabase.getInstance(ListarDuelistasActivity.this);
        List<Duelista> allDuelistas = db.dbDao().getAllDuelistas();

        listaDuelistas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        listaDuelistas.setAdapter(new DuelistasAdapter(allDuelistas));

    }
}