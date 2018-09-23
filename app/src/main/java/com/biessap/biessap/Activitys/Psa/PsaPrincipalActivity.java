package com.biessap.biessap.Activitys.Psa;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestPsaGestiones;
import com.biessap.biessap.models.Gestion;
import com.crowdfire.cfalertdialog.CFAlertDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PsaPrincipalActivity extends AppCompatActivity {

    int indexSelected = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psa_principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayout btn_info = findViewById(R.id.btn_info);
        LinearLayout btn_carrera = findViewById(R.id.btn_carreras);
        LinearLayout btn_textos = findViewById(R.id.btn_texto);
        LinearLayout btn_simulador = findViewById(R.id.btn_simulador);

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_carrera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_textos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_simulador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new RestPsaGestiones() {
                    @Override
                    protected void onError(String code) {
                        Toast.makeText(getApplicationContext(), code+"", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    protected void onSuccess(String s) {
                        try{
                            ArrayList<Gestion> lista = new ArrayList<Gestion>();
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray datos = jsonObject.getJSONArray("datos");
                            for (int i = 0; i < datos.length(); i++) {
                                JSONObject JsonGestion = datos.getJSONObject(i);
                                lista.add(new Gestion(JsonGestion.getInt("id"),JsonGestion.getString("nombre")));
                            }
                            mostrarGestiones(lista);
                        }catch (Exception e){
                            String ss = e.getMessage();
                        }
                    }
                }.runDialog(PsaPrincipalActivity.this);
            }
        });
    }

    private void mostrarGestiones(ArrayList<Gestion> lista){


        String[] titulos = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            titulos[i] = lista.get(i).getNombre();
        }
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(PsaPrincipalActivity.this);
        builder.setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT);
        builder.setTitle("Seleccione Una Gestion");
        builder.setSingleChoiceItems(titulos, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                indexSelected = index;
            }
        });
        builder.addButton("SIGUIENTE", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                int gestion_id = lista.get(indexSelected).getId();
                Intent intent = new Intent(PsaPrincipalActivity.this,PsaAreaActivity.class);
                intent.putExtra("gestion_id",gestion_id);
                startActivity(intent);
            }
        });
        builder.show();
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
