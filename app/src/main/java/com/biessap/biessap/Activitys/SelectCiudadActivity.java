package com.biessap.biessap.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.biessap.biessap.Activitys.Universidades.TelefonoActivity;
import com.biessap.biessap.Adapters.CiudadAdapter;
import com.biessap.biessap.Adapters.PaisAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestGetCiudades;
import com.biessap.biessap.models.Ciudad;
import com.biessap.biessap.models.Pais;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class SelectCiudadActivity extends AppCompatActivity {

    private CiudadAdapter adapter;
    private RecyclerView recyclerView;
    int pais_id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_select_ciudad);
        setTitle("Selecciona Una Ciudad");

        pais_id = getIntent().getIntExtra("pais_id",-1);
        obtenerCiudad();
    }

    private void obtenerCiudad(){
        new RestGetCiudades(pais_id) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),""+code,Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                ArrayList<Ciudad> lista = new ArrayList<>();
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray datos = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < datos.length(); i++) {
                        lista.add(Ciudad.parser(datos.getJSONObject(i)));
                    }

                }catch (Exception e){}

                adapter = new CiudadAdapter(lista) {
                    @Override
                    public void OnItemClick(int pos) {
                        Intent i = new Intent(SelectCiudadActivity.this,TelefonoActivity.class);
                        startActivity(i);
                    }
                };
                recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(SelectCiudadActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        }.runDialog(this);
    }
}
