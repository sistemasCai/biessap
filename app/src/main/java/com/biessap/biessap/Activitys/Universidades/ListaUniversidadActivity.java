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
import android.widget.Toast;

import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.Adapters.AreaAdapter;
import com.biessap.biessap.Adapters.UniversidadAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestGetInstituciones;
import com.biessap.biessap.models.Area;
import com.biessap.biessap.models.Universidad;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaUniversidadActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UniversidadAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_universidad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Atras");
        obtenerUniversidades();
        EditText edit_buscar = findViewById(R.id.buscar);

         edit_buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    adapter.getFilter().filter(s);
                }catch (Exception e){}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        CardView btn_inicio = findViewById(R.id.btn_inicio);
        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ListaUniversidadActivity.this, MenuActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
            }
        });

    }

    private void obtenerUniversidades() {
        String clase = "universidad";
        new RestGetInstituciones(clase) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),""+code,Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                ArrayList<Universidad> lista = new ArrayList<>();
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray datos = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < datos.length(); i++) {
                        lista.add(Universidad.parser(datos.getJSONObject(i)));
                    }
                }catch (Exception e){}
                adapter = new UniversidadAdapter(lista) {
                    @Override
                    public void OnItemClick(int pos) {
                        Intent i = new Intent(ListaUniversidadActivity.this,DetalleUniversidadActivity.class);
                        Universidad uni = adapter.getItem(pos);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("universidad",uni);
                        i.putExtra("universidad",bundle);
                        startActivity(i);
                    }
                };
                recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(ListaUniversidadActivity.this);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);

            }
        }.runDialog(this);
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
