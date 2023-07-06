package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import entidades.Carta;

public class CrearCartaActivity extends AppCompatActivity {

    TextView tvNombre,tvDefensa,tvAtaque,tvImagen,tvCoord;
    Button botRegImagen,botRegCoord,botRegCarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle data=getIntent().getExtras();
        int idDuelista=data.getInt("idDuelista");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carta);

        botRegCarta=findViewById(R.id.botRegCarta);
        botRegCoord=findViewById(R.id.botRegCoord);
        botRegImagen=findViewById(R.id.botRegImagen);

        botRegCarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carta cartaAux=new Carta();
                cartaAux.idDuelista=idDuelista;
                cartaAux.name=tvNombre.getText().toString();
                cartaAux.defensa=Integer.parseInt(tvDefensa.getText().toString());
                cartaAux.ataque=Integer.parseInt(tvAtaque.getText().toString());
                cartaAux.imagen=tvImagen.getText().toString();
                String[] parts = tvCoord.getText().toString().split(";");
            }
        });

        botRegImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        botRegCoord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}