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

import com.biessap.biessap.Activitys.DialogCarrera;
import com.biessap.biessap.Activitys.Institutos.ListaCarreraInstitutoActivity;
import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.Activitys.OrientacionUniversitaria.DetalleCarreraActivity;
import com.biessap.biessap.Activitys.OrientacionUniversitaria.ListaCarreraActivity;
import com.biessap.biessap.Activitys.Psa.PreguntasActivity;
import com.biessap.biessap.Adapters.AreaAdapter;
import com.biessap.biessap.Adapters.CarreraAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestGetCarreras;
import com.biessap.biessap.models.Carrera;
import com.crowdfire.cfalertdialog.CFAlertDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListaCarrera2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    CarreraAdapter adapter;
    int institucion_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carrera2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String nombre_universidad = getIntent().getStringExtra("nombre");
        setTitle(nombre_universidad);

         institucion_id = getIntent().getIntExtra("institucion_id",-1);
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
        new RestGetCarreras(institucion_id) {
            @Override
            protected void onError(String code) {
                Toast.makeText(ListaCarrera2Activity.this, ""+code, Toast.LENGTH_SHORT).show();
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
                            String inscripcion = (carrera.getCosto_inscripcion() == "null")?"":"Costo Inscripcion: " + carrera.getCosto_inscripcion()+ "\n";
                            String matricula = (carrera.getCosto_matricula()=="null")?"":"Costo Matricula: " + carrera.getCosto_matricula();
                            CFAlertDialog.Builder builder = new CFAlertDialog.Builder(ListaCarrera2Activity.this)
                                    .setDialogStyle(CFAlertDialog.CFAlertStyle.BOTTOM_SHEET)
                                    .setTitle(carrera.getNombre())
                                    .setMessage(
                                            "Tipo : " + carrera.getTipo() + "\n"+
                                                    inscripcion +
                                                    matricula

                                    )
                                    .addButton("Cerrar", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {

                                        dialog.dismiss();
                                    });
                            builder.show();
                        }
                    };
                    recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(ListaCarrera2Activity.this);
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
}
