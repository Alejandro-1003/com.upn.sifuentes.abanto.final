package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import DataBase.AppDatabase;
import entidades.Duelista;

public class CrearDuelistaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_duelista);
        TextView tvDuelistaNombre=findViewById(R.id.textBoxNombreDuelista);
        Button botonCrearDuelista=findViewById(R.id.botCreaDuelista);
        botonCrearDuelista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvDuelistaNombre.getText().toString().length()==0){
                    Toast toast = Toast.makeText(CrearDuelistaActivity.this, "Inserte noombre del duelista", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                Duelista auxDuelista = new Duelista();
                auxDuelista.name=tvDuelistaNombre.getText().toString();
                AppDatabase db = AppDatabase.getInstance(CrearDuelistaActivity.this);
                db.dbDao().createDuelista(auxDuelista);
                Toast toast = Toast.makeText(CrearDuelistaActivity.this, "Duelista creado", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }
}