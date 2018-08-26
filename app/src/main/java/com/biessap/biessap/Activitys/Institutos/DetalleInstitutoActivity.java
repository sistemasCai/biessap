package com.biessap.biessap.Activitys.Institutos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.biessap.biessap.Activitys.Universidades.CalendarioActivity;
import com.biessap.biessap.Activitys.Universidades.DetalleUniversidadActivity;
import com.biessap.biessap.Activitys.Universidades.ListaCarrera2Activity;
import com.biessap.biessap.Activitys.Universidades.TransporteActivity;
import com.biessap.biessap.R;
public class DetalleInstitutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_instituto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Atras");

        CardView c_carreraOfertada = findViewById(R.id.carrera_ofertada);
        c_carreraOfertada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleInstitutoActivity.this,ListaCarrera2Activity.class);
                startActivity(i);
            }
        });

        CardView c_calendario = findViewById(R.id.calendario);
        c_calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleInstitutoActivity.this,CalendarioActivity.class);
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
                Intent i = new Intent(DetalleInstitutoActivity.this,TransporteActivity.class);
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
