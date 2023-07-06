package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import DataBase.AppDatabase;
import entidades.Carta;

public class VerCartaActivity extends AppCompatActivity {
    TextView idNombreCarta,idAtaqueCarta,idDefensaCarta;
    ImageView idImagenCarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_carta);

        Bundle data=getIntent().getExtras();
        int idCarta=data.getInt("id");
        String nombre=data.getString("nombre");
        int ataque=data.getInt("ataque");
        int defensa=data.getInt("defensa");
        String ruta=data.getString("ruta");

        AppDatabase db = AppDatabase.getInstance(VerCartaActivity.this);
        List<Carta> carta = db.dbDao().findCarta(idCarta);

        idNombreCarta=findViewById(R.id.idNombreCarta);
        idAtaqueCarta=findViewById(R.id.idAtaqueCarta);
        idDefensaCarta=findViewById(R.id.idDefensaCarta);
        idImagenCarta=findViewById(R.id.idImagenCarta);


        idNombreCarta.setText(nombre);
        idAtaqueCarta.setText(""+ataque);
        idDefensaCarta.setText(""+defensa);

        try {
            Picasso.get().load(ruta).into(idImagenCarta);
        }catch (Exception e){

        }


    }
}