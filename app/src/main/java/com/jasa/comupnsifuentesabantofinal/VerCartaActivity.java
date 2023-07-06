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

        AppDatabase db = AppDatabase.getInstance(VerCartaActivity.this);
        List<Carta> carta = db.dbDao().findCarta(idCarta);

        carta.get(0);

        idNombreCarta=findViewById(R.id.idNombreCarta);
        idAtaqueCarta=findViewById(R.id.idAtaqueCarta);
        idDefensaCarta=findViewById(R.id.idDefensaCarta);
        idImagenCarta=findViewById(R.id.idImagenCarta);

        idNombreCarta.setText(carta.get(0).name);
        idAtaqueCarta.setText(""+carta.get(0).ataque);
        idDefensaCarta.setText(""+carta.get(0).defensa);

        try {
            Picasso.get().load(carta.get(0).imagen).into(idImagenCarta);
        }catch (Exception e){
            
        }


    }
}