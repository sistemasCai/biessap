package com.biessap.biessap.Activitys.OrientacionUniversitaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.R;
public class PerfilProfesionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_profesional);
        Button btSig = findViewById(R.id.btSig);
        btSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilProfesionalActivity.this, ActivityOrientacion.class);
                startActivity(i);
            }
        });
    }
}
