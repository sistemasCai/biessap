package com.biessap.biessap.Activitys.Universidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.biessap.biessap.Activitys.OrientacionUniversitaria.ListaCarreraActivity;
import com.biessap.biessap.Adapters.AreaAdapter;
import com.biessap.biessap.Adapters.LineaAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestGetLineas;
import com.biessap.biessap.models.Linea;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TransporteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LineaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Transporte");
        obtenerLineas();
    }

    private void obtenerLineas(){
        int id = getIntent().getIntExtra("id",-1);
        new RestGetLineas(id) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),code,Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                ArrayList<Linea> lista = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray datos = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < datos.length(); i++) {
                        lista.add(Linea.parser(datos.getJSONObject(i)));
                    }
                }catch (Exception e){}

                adapter = new LineaAdapter(lista) {
                    @Override
                    public void itemClick(int pos) {

                        String nombre = adapter.getItem(pos).getNombre();
                        Toast.makeText(getApplicationContext(),nombre,Toast.LENGTH_SHORT).show();

                    }
                };
                recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(TransporteActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        }.runDialog(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
