package com.biessap.biessap.Activitys;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.biessap.biessap.Activitys.Institutos.InstitutoActivity;
import com.biessap.biessap.Activitys.OrientacionUniversitaria.PerfilProfesionalActivity;
import com.biessap.biessap.Activitys.Psa.PsaAreaActivity;
import com.biessap.biessap.Activitys.Psa.PsaPrincipalActivity;
import com.biessap.biessap.Activitys.Universidades.UniversidadesActivity;
import com.biessap.biessap.R;
import com.biessap.biessap.system.Api;
import com.biessap.biessap.system.Session;

import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        //new prueba().execute();


        Log.i("datosSession",Session.getDataSession(this).toString());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CardView card_orientacion = findViewById(R.id.c_orientacion);
        CardView card_universidades = findViewById(R.id.c_universidades);
        CardView card_institutos = findViewById(R.id.c_institutos);
        CardView c_psa = findViewById(R.id.c_psa);
        card_orientacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, PerfilProfesionalActivity.class);
                startActivity(i);
            }
        });

        card_universidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, UniversidadesActivity.class);
                startActivity(i);
            }
        });

        card_institutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, InstitutoActivity.class);
                startActivity(i);
            }
        });
        c_psa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this, PsaPrincipalActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.sesion) {
            Session.clear(this);
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id == R.id.nav_activar){
            DialogActivarPaquete dialogCarrera = new DialogActivarPaquete();
            dialogCarrera.setCancelable(true);
            dialogCarrera.show(getSupportFragmentManager());
        }
        if(id == R.id.nav_caducidad){
            Intent i = new Intent(MenuActivity.this,CaducidadActivity.class);
            startActivity(i);
        }
        if(id == R.id.nav_ayuda){
            Intent i = new Intent(MenuActivity.this,AyudaActivity.class);
        }
        if(id == R.id.nav_mapa){
            Intent i = new Intent(MenuActivity.this,MapsActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
