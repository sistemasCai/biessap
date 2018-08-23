package com.biessap.biessap.Activitys.Universidades;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.biessap.biessap.R;

public class UniversidadesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universidades);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Atras");
        //Boton Ver Lista
        Button btn = (Button) findViewById(R.id.btnVer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            //Ir a inicio
            public void onClick(View v) {
                /*Intent intent = new Intent (Universidades.this, Lista_universidades.class);
                startActivity(intent);*/
            }
        });
    }
}
