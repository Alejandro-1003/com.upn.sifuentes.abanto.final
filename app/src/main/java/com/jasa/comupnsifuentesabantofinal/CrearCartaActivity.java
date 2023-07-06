package com.jasa.comupnsifuentesabantofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import DataBase.AppDatabase;
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
                cartaAux.latitud=parts[0];
                cartaAux.longitud=parts[1];
                AppDatabase db = AppDatabase.getInstance(CrearCartaActivity.this);
                db.dbDao().createCarta(cartaAux);

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
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (ContextCompat.checkSelfPermission(CrearCartaActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            if (location != null) {
                                double latitude = location.getLatitude();
                                double longitude = location.getLongitude();
                                tvCoord.setText("" + latitude + ";" + longitude);
                            } else {
                                Toast toast = Toast.makeText(CrearCartaActivity.this, "No se puede acceder a la ubicación", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {
                        }

                        @Override
                        public void onProviderEnabled(String provider) {
                        }

                        @Override
                        public void onProviderDisabled(String provider) {
                        }
                    });
                }

            }
        });
    }
}