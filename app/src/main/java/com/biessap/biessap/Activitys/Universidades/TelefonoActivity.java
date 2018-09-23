package com.biessap.biessap.Activitys.Universidades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestRegistraCelular;
import com.biessap.biessap.models.DataSession;
import com.biessap.biessap.system.Session;

public class TelefonoActivity extends AppCompatActivity {

    EditText edit_telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefono);
        setTitle("Introduzca su Telefono");

        edit_telefono = findViewById(R.id.edit_telefono);
        Button btn_siguiente = findViewById(R.id.btn_siguiente);
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarTelefono();
            }
        });
    }

    private void registrarTelefono(){
        String data = edit_telefono.getText().toString();
        if(!data.isEmpty()){
            DataSession dataSession = Session.getDataSession(this);
            int usuario_id = dataSession.getId();

            new RestRegistraCelular(usuario_id, data) {
                @Override
                protected void onError(String code) {
                    Toast.makeText(getApplicationContext(),""+code,Toast.LENGTH_SHORT).show();
                }

                @Override
                protected void onSuccess(String s) {
                    Intent i = new Intent(TelefonoActivity.this, MenuActivity.class);
                    startActivity(i);
                }
            }.runDialog(this);

        }else{
            Toast.makeText(getApplicationContext(),"Inserte su Numero de Telefono",Toast.LENGTH_SHORT).show();
        }
    }
}
