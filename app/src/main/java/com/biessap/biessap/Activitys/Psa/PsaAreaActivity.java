package com.biessap.biessap.Activitys.Psa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.biessap.biessap.Activitys.Institutos.ListaCarreraInstitutoActivity;
import com.biessap.biessap.Activitys.OrientacionUniversitaria.DetalleCarreraActivity;
import com.biessap.biessap.Adapters.AdapterAreaPsa;
import com.biessap.biessap.Adapters.CarreraAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestGetAreasPsa;
import com.biessap.biessap.models.Area;
import com.biessap.biessap.models.AreaPsa;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PsaAreaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterAreaPsa adapter;
    int gestion_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psa_area);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Simulador");
        gestion_id = getIntent().getIntExtra("gestion_id",-1);
        obtenerAreas();
    }

    private void preguntar(int area_id){
        final SweetAlertDialog da = new SweetAlertDialog(PsaAreaActivity.this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Esta Seguro de Iniciar el Examen?")
                .setContentText("Tiene 60 minutos para resolver!")
                .setConfirmText("Si")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        Intent i = new Intent(PsaAreaActivity.this,PreguntasActivity.class);
                        i.putExtra("area_id",area_id);
                        startActivity(i);
                        sDialog.dismiss();
                    }
                });
        da.show();
    }
    private void obtenerAreas(){
        new RestGetAreasPsa(gestion_id) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),code+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                ArrayList<AreaPsa> data = new ArrayList<>();
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray datos = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < datos.length(); i++) {
                        JSONObject jsonArea = datos.getJSONObject(i);
                        data.add(new AreaPsa(jsonArea.getInt("id"),jsonArea.getString("nombre")));
                    }
                }catch (Exception e){}

                adapter = new AdapterAreaPsa(data) {
                    @Override
                    public void OnItemClick(int pos) {
                        AreaPsa area = adapter.getItem(pos);
                        preguntar(area.getId());
                    }
                };
                recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(PsaAreaActivity.this);
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
