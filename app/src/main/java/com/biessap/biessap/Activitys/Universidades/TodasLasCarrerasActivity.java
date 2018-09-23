package com.biessap.biessap.Activitys.Universidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.biessap.biessap.Adapters.CarreraAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.GetInstitucion;
import com.biessap.biessap.Rest.RestGeneral;
import com.biessap.biessap.Rest.RestGetCarreras;
import com.biessap.biessap.models.Carrera;
import com.biessap.biessap.models.Universidad;
import com.crowdfire.cfalertdialog.CFAlertDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TodasLasCarrerasActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    CarreraAdapter adapter;
    int tipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_las_carreras);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Todas Las Carreras");
        tipo = getIntent().getIntExtra("tipo",-1);
        obtenerCarreras();
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

    private void obtenerCarreras(){
        String institucion = "universidad";
        int ciudad_id = 1;
        if(tipo == 0){
            institucion = "instituto";
        }
        new RestGeneral(institucion,ciudad_id) {
            @Override
            protected void onError(String code) {
                Toast.makeText(TodasLasCarrerasActivity.this, ""+code, Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {

                try{
                    ArrayList<Carrera> datos = new ArrayList<>();
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray data = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < data.length(); i++) {
                        Carrera carrera = Carrera.parser(data.getJSONObject(i));
                        datos.add(carrera);
                    }

                    adapter = new CarreraAdapter(datos) {
                        @Override
                        public void OnItemClick(int pos) {
                            Carrera carrera = adapter.getItem(pos);
                            int institucion_id = carrera.getInstitucion_id();
                            obtenerInstitucion(institucion_id);
                        }
                    };
                    recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(TodasLasCarrerasActivity.this);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setAdapter(adapter);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }

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

    private void obtenerInstitucion(int institucion){

        new GetInstitucion(institucion) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),code+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONObject datos = jsonObject.getJSONObject("datos");
                    Universidad uni = Universidad.parser(datos);
                    Intent i = new Intent(TodasLasCarrerasActivity.this,DetalleUniversidadActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("universidad",uni);
                    i.putExtra("universidad",bundle);
                    startActivity(i);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }.runDialog(this);
    }
}
