package com.biessap.biessap.Activitys.Universidades;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.biessap.biessap.R;

public class UniversidadesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universidades);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Atras");

        TextView textView = findViewById(R.id.textView3);
        String textoHtml = "<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\">Te mostraremos todas las universidades y sus carreras ofertadas de la ciudad de santa cruz. &iquest;D&oacute;nde est&aacute; la pr&oacute;xima informaci&oacute;n actualizada en cada gesti&oacute;n por cada universidad?</span></span></p>\n" +
                "<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\"><span style=\"color: #0000ff;\">a)</span> Inscripciones, requisitos e inicio de clases.</span></span></p>\n" +
                "<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\"><span style=\"color: #0000ff;\">b)</span> Mensualidad o Matricula por cada carrera</span></span></p>\n" +
                "<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\"><span style=\"color: #0000ff;\">c)</span> Ubicaci&oacute;n GPS de las universidades</span></span></p>\n" +
                "<p><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\"><span style=\"color: #0000ff;\">d)</span> L&iacute;neas de micros, que pasan cerca o sus alrededores</span></span></p>\n" +
                "<p style=\"text-align: left;\"><span style=\"vertical-align: inherit;\"><span style=\"vertical-align: inherit;\"><span style=\"color: #0000ff;\">e)</span> Mapeo interno de cada universidad (M&oacute;dulos, comedor, biblioteca, cajas, centro de informaci&oacute;n, etc.)</span></span></p>";
        textView.setText(Html.fromHtml(textoHtml));
        //Boton Ver Lista
        Button btn = (Button) findViewById(R.id.btnVer);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UniversidadesActivity.this, ListaUniversidadActivity.class);
                startActivity(intent);
            }
        });

        Button btn_ir_carreras = (Button) findViewById(R.id.btn_ir_carreras);
        btn_ir_carreras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UniversidadesActivity.this,TodasLasCarrerasActivity.class);
                Intent i = new Intent(UniversidadesActivity.this,TodasLasCarrerasActivity.class);
                i.putExtra("tipo",1);
                startActivity(intent);
            }
        });
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
