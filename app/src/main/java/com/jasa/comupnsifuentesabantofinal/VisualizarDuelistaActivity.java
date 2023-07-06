package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VisualizarDuelistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_duelista);

        Bundle data=getIntent().getExtras();
        int idDuelista=data.getInt("id");
        String nombreDuelista=data.getString("nombre");

        Button CrearCarta,VerCartas,SincronizarCartas;
        TextView tvNombreDuelista=findViewById(R.id.tvNombreDuelista);
        tvNombreDuelista.setText(nombreDuelista);

        CrearCarta=findViewById(R.id.botRegistrarCarta);
        VerCartas=findViewById(R.id.botVerCartas);
        SincronizarCartas=findViewById(R.id.botSincronizarCartas);

        CrearCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        VerCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        SincronizarCartas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}