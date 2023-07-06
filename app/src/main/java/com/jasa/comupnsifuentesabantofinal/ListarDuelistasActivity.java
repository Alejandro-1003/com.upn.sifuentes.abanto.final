package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListarDuelistasActivity extends AppCompatActivity {
    RecyclerView listaDuelistas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_duelistas);
        listaDuelistas=findViewById(R.id.listaDuelistas);

    }
}