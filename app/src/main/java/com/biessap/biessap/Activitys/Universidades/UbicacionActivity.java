package com.biessap.biessap.Activitys.Universidades;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.biessap.biessap.R;
import com.biessap.biessap.models.Universidad;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class UbicacionActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    Universidad uni;
    BottomSheetBehavior bottomSheetBehaviorMarker;
    BottomSheetBehavior bottomSheetBehaviorInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Mapbox.getInstance(this, "pk.eyJ1Ijoiam9yZ2VsaXZlMjAxNiIsImEiOiJjampyOGR6YngwZGN5M2t0ZW10NzMyOWVhIn0.jtZuoD1i2qOuyYZ0MQVgcQ");
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        Bundle bundle = getIntent().getBundleExtra("universidad");
        uni = (Universidad) bundle.getSerializable("universidad");
        setTitle(uni.getNombre());
        menuAbajoMarker();
    }

    private void menuAbajoMarker() {


        View bottomSheet = findViewById(R.id.bottom_sheet_mapa);
        bottomSheetBehaviorMarker = BottomSheetBehavior.from(bottomSheet);
        TextView text_titulo = findViewById(R.id.titulo);
        try{
            text_titulo.setText(uni.getNombre());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        LinearLayout btn_facebook = findViewById(R.id.btn_facebook);
        LinearLayout btn_twitter = findViewById(R.id.btn_twitter);
        LinearLayout btn_web = findViewById(R.id.btn_web);
        LinearLayout btn_youtube = findViewById(R.id.btn_youtube);

        TextView enlace_direccion = findViewById(R.id.enlace_direccion);
        TextView enlace_correo = findViewById(R.id.enlace_ccrreo);
        TextView enlace_telefono = findViewById(R.id.enlace_telefono);

        enlace_correo.setText(uni.getCorreo());
        enlace_direccion.setText(uni.getUbicacion());
        enlace_telefono.setText(uni.getTelefono());
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri uri = Uri.parse(uni.getLink_facebook());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri uri = Uri.parse(uni.getLink_twitter());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri uri = Uri.parse(uni.getLink_web());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri uri = Uri.parse(uni.getLink_youtube());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomSheetBehaviorMarker.setState(BottomSheetBehavior.STATE_HIDDEN);
        bottomSheetBehaviorMarker.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetBehaviorInfo.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });

        View bottomSheet_info = findViewById(R.id.bottom_sheet_info);
        bottomSheetBehaviorInfo = BottomSheetBehavior.from(bottomSheet_info);
        TextView text_titulo2 = findViewById(R.id.titulo2);
        try{
            text_titulo2.setText(uni.getNombre());
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        Button btn_masInfo = findViewById(R.id.mas_info);
        btn_masInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetBehaviorInfo.setState(BottomSheetBehavior.STATE_HIDDEN);
                bottomSheetBehaviorMarker.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        bottomSheetBehaviorInfo.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                } else if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetBehaviorMarker.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });
        bottomSheetBehaviorInfo.setState(BottomSheetBehavior.STATE_EXPANDED);
    }


    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {

        mapboxMap.addMarker(new MarkerOptions()
                .position(new LatLng(-17.789749, -63.205126))
                .title(uni.getNombre())
                .snippet(uni.getTelefono()));

        CameraPosition position = new CameraPosition.Builder()
                .target(new LatLng(-17.789749, -63.205126)) // Sets the new camera position
                .zoom(17) // Sets the zoom
                .bearing(180) // Rotate the camera
                .tilt(30) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        mapboxMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), 7000);
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
