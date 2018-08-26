package com.biessap.biessap.Activitys.Universidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.Activitys.OrientacionUniversitaria.DetalleCarreraActivity;
import com.biessap.biessap.Activitys.OrientacionUniversitaria.ListaCarreraActivity;
import com.biessap.biessap.Adapters.AreaAdapter;
import com.biessap.biessap.Adapters.CarreraAdapter;
import com.biessap.biessap.R;

import java.util.ArrayList;

public class ListaCarrera2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    CarreraAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carrera2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Atras");

        ArrayList<String> data = new ArrayList<>();
        data.add("Ing. Informatica");
        data.add("Ing. Informatica");
        data.add("Ing. Informatica");
        data.add("Ing. Informatica");
        adapter = new CarreraAdapter(data) {
            @Override
            public void OnItemClick(int pos) {
                Intent i = new Intent(ListaCarrera2Activity.this,DetalleCarreraActivity.class);
                startActivity(i);
            }
        };
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        EditText edit_buscar = findViewById(R.id.buscar);
        edit_buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

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
