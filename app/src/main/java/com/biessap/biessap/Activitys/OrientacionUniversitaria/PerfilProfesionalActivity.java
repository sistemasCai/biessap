package com.biessap.biessap.Activitys.OrientacionUniversitaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.R;
public class PerfilProfesionalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_profesional);
        Button btSig = findViewById(R.id.btSig);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Atras");
        btSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilProfesionalActivity.this, ActivityOrientacion.class);
                startActivity(i);
            }
        });

        TextView textView = findViewById(R.id.textView3);
        String info = "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\"><A NAME=\"_GoBack\"></A>\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN LANG=\"es-ES\">Bienvenido\n" +
                "</SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN LANG=\"es-ES\"><I><B>José\n" +
                "Ugarte</B></I></SPAN></FONT></FONT><FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\"><SPAN LANG=\"es-ES\">,\n" +
                "en esta área encontrarás todas las carreras profesionales\n" +
                "existentes en Bolivia, donde te mostraremos cada una, su descripción\n" +
                "clara de conjuntos de capacidades y competencias que requieren la\n" +
                "formación de una persona, para encarar responsablemente las\n" +
                "funciones y tareas de las profesiones o trabajos.</SPAN></FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<BR>\n" +
                "</P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" ALIGN=JUSTIFY STYLE=\"margin-bottom: 0in\">\n" +
                "<FONT COLOR=\"#3b3838\"><FONT FACE=\"Helvetica Neue, serif\">También\n" +
                "encontrarás términos y/o conceptos básicos muy importantes que te\n" +
                "ayudarán al inicio de tu formación profesional.</FONT></FONT></P>\n" +
                "<P LANG=\"en-US\" CLASS=\"western\" STYLE=\"margin-bottom: 0in\"><BR>\n" +
                "</P>";
        textView.setText(Html.fromHtml(info));
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
