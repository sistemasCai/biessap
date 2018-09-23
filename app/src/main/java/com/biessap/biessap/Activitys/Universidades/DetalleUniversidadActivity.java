package com.biessap.biessap.Activitys.Universidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.biessap.biessap.R;
import com.biessap.biessap.models.Universidad;
import com.biessap.biessap.system.Configuracion;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetalleUniversidadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_universidad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView imageView = findViewById(R.id.imguni);
        TextView text_titulo = findViewById(R.id.tituloUniversidad);
        Bundle bundle = getIntent().getBundleExtra("universidad");
        final Universidad uni = (Universidad) bundle.getSerializable("universidad");
        setTitle(uni.getNombre());
        String tipo_imagen = uni.getTipo_imagen();
        if(tipo_imagen.equalsIgnoreCase("logo")){
            Glide.with(this).load(Configuracion.URL_IMAGE +  uni.getLogo())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);;
                    text_titulo.setText(uni.getNombre());
        }else{
            imageView.setVisibility(View.GONE);
            text_titulo.setVisibility(View.GONE);
            ImageView img_portada = findViewById(R.id.portada);
            img_portada.setVisibility(View.VISIBLE);
            Glide.with(this).load(Configuracion.URL_IMAGE +  uni.getPortada())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(img_portada);;
        }


        CardView c_carreraOfertada = findViewById(R.id.carrera_ofertada);
        c_carreraOfertada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleUniversidadActivity.this,ListaCarrera2Activity.class);
                i.putExtra("institucion_id",uni.getId());
                i.putExtra("nombre",uni.getNombre());
                startActivity(i);
            }
        });

        CardView c_calendario = findViewById(R.id.calendario);
        c_calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleUniversidadActivity.this,CalendarioActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("universidad",uni);
                i.putExtra("universidad",bundle);
                startActivity(i);
            }
        });

        CardView c_mapeoView = findViewById(R.id.mapeoView);
        c_mapeoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(DetalleUniversidadActivity.this,MapeoActivity.class);
                //startActivity(i);
            }
        });

        CardView c_ubicacionView = findViewById(R.id.ubicacionView);
        c_ubicacionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleUniversidadActivity.this,UbicacionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("universidad",uni);
                i.putExtra("universidad",bundle);
                startActivity(i);
            }
        });

        CardView c_transporteView = findViewById(R.id.transporteView);
        c_transporteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetalleUniversidadActivity.this,TransporteActivity.class);
                i.putExtra("id",uni.getId());
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
