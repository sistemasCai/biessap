package com.biessap.biessap.Activitys.Psa;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.biessap.biessap.Adapters.PreguntaAdapter;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestIniciarPsa;
import com.biessap.biessap.models.Materia;
import com.biessap.biessap.models.Pregunta;
import com.biessap.biessap.models.Respuesta;
import com.crowdfire.cfalertdialog.CFAlertDialog;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PreguntasActivity extends AppCompatActivity implements View.OnClickListener {

    int area_id;
    TextView texto_pregunta;
    RadioButton radio1,radio2, radio3,radio4,radio5;
    ArrayList<Materia> MateriaList;
    int pregunta_actual = 0;
    ArrayList<Pregunta> preguntas = new ArrayList<>();
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Preguntas");
        area_id = getIntent().getIntExtra("area_id",-1);
        MateriaList = new ArrayList<>();
        obtenerPreguntas();
        texto_pregunta = findViewById(R.id.text_pregunta);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);
        radio5 = findViewById(R.id.radio5);
        radioGroup = findViewById(R.id.radioRespuestas);

    }

    public void finalizar(View v){
        SweetAlertDialog alertDialog = new SweetAlertDialog(PreguntasActivity.this,SweetAlertDialog.WARNING_TYPE);
        alertDialog.setTitle("Simulador Psa");
        alertDialog.setContentText("¿Desea Finalizar el examen?");
        alertDialog.show();
        alertDialog.setCancelButton("Cancelar", new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                alertDialog.dismiss();
            }
        });
        alertDialog.setConfirmButton("Confirmar", new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                alertDialog.dismiss();
                alert();
            }
        });
    }
    public void onCheck(View v){
        int id = radioGroup.getCheckedRadioButtonId();
        Pregunta pregunta = preguntas.get(pregunta_actual);
        pregunta.setCheckId(id);
        int indexRespondida = obtenerRadioCheck();
        pregunta.setRespondida(indexRespondida);
    }

    private int obtenerRadioCheck(){
           int n = -1;
        if(radio1.isChecked()){
               n = 0;
        }
        if(radio2.isChecked()){
            n = 1;
        }
        if(radio3.isChecked()){
            n = 2;
        }
        if(radio4.isChecked()){
            n = 3;
        }
        if(radio5.isChecked()){
            n = 4;
        }
        return n;
    }

    private void procesarPreguntas(){
        String num[] = new String[40];
        for (int i = 0; i < num.length; i++) {
            num[i] = (i+1) + "";
        }
        GridView gridView = (GridView)findViewById(R.id.gridview);
        PreguntaAdapter booksAdapter = new PreguntaAdapter(this, num);
        gridView.setAdapter(booksAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pregunta pregunta = preguntas.get(pregunta_actual);
                int respuestaIndex = obtenerRadioCheck();
                pregunta.setRespondida(respuestaIndex);
                pregunta_actual = position;
                mostrarPregunta(pregunta_actual);
                view.setBackgroundColor(Color.YELLOW);
            }
        });
        mostrarPregunta(pregunta_actual);
    }

    private void mostrarPregunta(int preguntaIntex){
        try{
            Pregunta pregunta = preguntas.get(preguntaIntex);
            String textoPregunta = pregunta.getTexto();
            texto_pregunta.setText(textoPregunta);
            ArrayList<Respuesta> respuestas = preguntas.get(preguntaIntex).getRespuestas();
            for (int i = 0; i < respuestas.size(); i++) {
                Respuesta respuesta = respuestas.get(i);
                switch (i){
                    case 0:
                        radio1.setText(respuesta.getTexto());
                        break;
                    case 1:
                        radio2.setText(respuesta.getTexto());
                        break;
                    case 2:
                        radio3.setText(respuesta.getTexto());
                        break;
                    case 3 :
                        radio4.setText(respuesta.getTexto());
                        break;
                    default:
                        radio5.setText(respuesta.getTexto());
                        break;
                }
            }
            if(pregunta.getCheckId() != 0){
                radioGroup.check(pregunta.getCheckId());
            }
            else{
                radioGroup.clearCheck();
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void alert(){
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.NOTIFICATION)
                .setTitle("You've hit the limit")
                .setMessage("Looks like you've hit your usage limit. Upgrade to our paid plan to continue without any limits.")
                .addButton("UPGRADE", -1, -1, CFAlertDialog.CFAlertActionStyle.POSITIVE, CFAlertDialog.CFAlertActionAlignment.END, (dialog, which) -> {
                    Toast.makeText(PreguntasActivity.this, "Upgrade tapped", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                });

// Show the alert
        builder.show();
    }

    private void obtenerPreguntas(){
        new RestIniciarPsa(1,3) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),code+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                try{

                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray datos = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < datos.length(); i++) { // materias
                        JSONObject jsonMaterias = datos.getJSONObject(i);
                        int materiaId = jsonMaterias.getInt("id");
                        JSONArray preguntasJSON = jsonMaterias.getJSONArray("preguntas");
                        for (int j = 0; j < preguntasJSON.length(); j++) {
                                JSONObject preguntaObject = preguntasJSON.getJSONObject(j);
                                JSONArray respuestasJSON = preguntaObject.getJSONArray("respuestas");
                                ArrayList<Respuesta> respuestas = new ArrayList<>();
                            for (int k = 0; k < respuestasJSON.length(); k++) {
                                JSONObject respuestaObject = respuestasJSON.getJSONObject(k);
                                Respuesta res = new Respuesta(
                                        respuestaObject.getInt("id"),
                                        respuestaObject.getString("texto"),
                                        respuestaObject.getString("imagen"),
                                        respuestaObject.getString("tipo")
                                );
                                respuestas.add(res);
                            }
                            Pregunta pregunta = new Pregunta(
                                    preguntaObject.getInt("id"),
                                    preguntaObject.getString("texto"),
                                    preguntaObject.getString("imagen"),
                                    respuestas,
                                    materiaId

                            );
                            preguntas.add(pregunta);
                        }

                        Materia materia = new Materia(
                                jsonMaterias.getInt("id"),
                                jsonMaterias.getString("nombre")
                        );
                    MateriaList.add(materia);
                    }
                    procesarPreguntas();
                }catch (Exception e){
                    String ss = e.getMessage();
                }
            }
        }.runDialog(PreguntasActivity.this);
    }

    private void desCheck(){
        radio1.setChecked(false);
        radio2.setChecked(false);
        radio3.setChecked(false);
        radio4.setChecked(false);
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

    @Override
    public void onClick(View v) {
        int id = v.getId();

    }
}
