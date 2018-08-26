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
import com.biessap.biessap.models.Linea;

import java.util.ArrayList;

public class TransporteActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LineaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporte);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayList<Linea> data = new ArrayList<>();
        data.add(new Linea(1,"Linea 54","micro","/img/454.jpg","#aa4431"));
        data.add(new Linea(1,"Linea 53","micro","/img/454.jpg","#aa4431"));
        data.add(new Linea(1,"Linea 52","micro","/img/454.jpg","#aa4431"));
        data.add(new Linea(1,"Linea 51","micro","/img/454.jpg","#aa4431"));
        data.add(new Linea(1,"Linea 50","micro","/img/454.jpg","#aa4431"));
        adapter = new LineaAdapter(data) {
            @Override
            public void itemClick(int pos) {

                String nombre = adapter.getItem(pos).getNombre();
                Toast.makeText(getApplicationContext(),nombre,Toast.LENGTH_SHORT).show();
                /*Intent i = new Intent(getActivity(), ListaCarreraActivity.class);
                i.putExtra("nombre",nombre);
                startActivity(i);*/

            }
        };
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

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
