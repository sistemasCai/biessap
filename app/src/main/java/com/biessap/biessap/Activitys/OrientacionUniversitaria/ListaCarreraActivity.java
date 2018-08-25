package com.biessap.biessap.Activitys.OrientacionUniversitaria;

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
import android.widget.Toast;

import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.Adapters.AreaAdapter;
import com.biessap.biessap.R;

import java.util.ArrayList;

public class ListaCarreraActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AreaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carrera);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String titulo = getIntent().getStringExtra("nombre");
        getSupportActionBar().setTitle(titulo);

        ArrayList<String> data = new ArrayList<>();
        data.add("Ing. Informatica");
        data.add("Ing. Informatica");
        data.add("Ing. Informatica");
        data.add("Ing. Informatica");
        adapter = new AreaAdapter(data) {
            @Override
            public void OnItemClick(int pos) {
                Intent i = new Intent(ListaCarreraActivity.this,DetalleCarreraActivity.class);
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

        CardView btn_inicio = findViewById(R.id.btn_inicio);
        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaCarreraActivity.this, MenuActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
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
