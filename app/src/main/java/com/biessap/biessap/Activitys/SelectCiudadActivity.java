package com.biessap.biessap.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.biessap.biessap.R;
public class SelectCiudadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_select_ciudad);
        setTitle("Selecciona Una Ciudad");
        Toast.makeText(getApplicationContext(),"Selecciona una Ciudad",Toast.LENGTH_SHORT);

        TextView text_santaCruz = findViewById(R.id.text_santa_cruz);
        text_santaCruz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectCiudadActivity.this,MenuActivity.class);
                startActivity(i);
                finish();
            }
        });
        TextView text_cochabamba = findViewById(R.id.text_cochabamba);
        text_cochabamba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ciudad No Disponible, solo para Santa Cruz",Toast.LENGTH_SHORT).show();
            }
        });

        TextView text_laPaz = findViewById(R.id.text_la_paz);
        text_laPaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ciudad No Disponible, solo para Santa Cruz",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
