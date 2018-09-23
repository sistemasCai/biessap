package com.biessap.biessap.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.Toast;

import com.biessap.biessap.Adapters.PaisAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestGetPaises;
import com.biessap.biessap.models.Pais;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PaisActivity extends AppCompatActivity {

    private PaisAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        obtenerPaises();
    }

    private void obtenerPaises(){
        new RestGetPaises() {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),code+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                ArrayList<Pais> lista = new ArrayList<>();
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray datos = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < datos.length(); i++) {
                        lista.add(Pais.parser(datos.getJSONObject(i)));
                    }

                }catch (Exception e){}

                adapter = new PaisAdapter(lista) {
                    @Override
                    public void OnItemClick(int pos) {
                        Pais pais = adapter.getItem(pos);
                        Intent i = new Intent(PaisActivity.this,SelectCiudadActivity.class);
                        i.putExtra("pais_id",pais.getId());
                        startActivity(i);
                    }
                };
                recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(PaisActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        }.runDialog(this);
    }
}
