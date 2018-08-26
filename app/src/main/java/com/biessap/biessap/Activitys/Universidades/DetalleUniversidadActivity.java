package com.biessap.biessap.Activitys.Universidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.biessap.biessap.R;
public class DetalleUniversidadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_universidad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Atras");

        CardView c_carreraOfertada = findViewById(R.id.carrera_ofertada);
        c_carreraOfertada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleUniversidadActivity.this,ListaCarrera2Activity.class);
                startActivity(i);
            }
        });

        CardView c_calendario = findViewById(R.id.calendario);
        c_calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleUniversidadActivity.this,CalendarioActivity.class);
                startActivity(i);
            }
        });

        CardView c_mapeoView = findViewById(R.id.mapeoView);
        c_mapeoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        CardView c_ubicacionView = findViewById(R.id.ubicacionView);
        c_ubicacionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        CardView c_transporteView = findViewById(R.id.transporteView);
        c_transporteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleUniversidadActivity.this,TransporteActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
