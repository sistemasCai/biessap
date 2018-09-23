package com.biessap.biessap.Activitys.Psa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestIniciarPsa;
import com.biessap.biessap.models.Materia;
import com.biessap.biessap.models.Pregunta;
import com.biessap.biessap.models.Respuesta;
import com.crowdfire.cfalertdialog.CFAlertDialog;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PreguntasActivity extends AppCompatActivity implements View.OnClickListener {

    int area_id;
    int materiaIndex=0;
    int preguntaIntex=0;
    private static final int CANTIDAD_MATERIAS = 4;
    private static final int CANTIDAD_PREGUNTAS = 10;
    TextView texto_pregunta;
    RadioButton radio1,radio2, radio3,radio4;
    ArrayList<Materia> MateriaList;
    Button preg_1,preg_2,preg_3,preg_4,preg_5,preg_6,preg_7,preg_8,preg_9,preg_10;
    Button preg_11,preg_12,preg_13,preg_14,preg_15,preg_16,preg_17,preg_18,preg_19,preg_20;
    Button preg_21,preg_22,preg_23,preg_24,preg_25,preg_26,preg_27,preg_28,preg_29,preg_30;
    Button preg_31,preg_32,preg_33,preg_34,preg_35,preg_36,preg_37,preg_38,preg_39,preg_40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Preguntas");
        area_id = getIntent().getIntExtra("area_id",-1);
        TextView text_materia1 = findViewById(R.id.text_materia1);
        MateriaList = new ArrayList<>();
        obtenerPreguntas();

        texto_pregunta = findViewById(R.id.text_pregunta);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);

        TextView text_materia2 = findViewById(R.id.text_materia2);
        TextView text_materia3 = findViewById(R.id.text_materia3);
        TextView text_materia4 = findViewById(R.id.text_materia4);
        TextView btn_siguiente = findViewById(R.id.btn_seguiente);
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntaIntex++;
                if(preguntaIntex == CANTIDAD_PREGUNTAS){
                    preguntaIntex = 0;
                    materiaIndex = (materiaIndex + 1)%CANTIDAD_MATERIAS;
                }
                mostrarPregunta(materiaIndex,preguntaIntex);
               // alert();
            }
        });

        text_materia1.setText("Lenguaje");
        text_materia2.setText("Matematicas");
        text_materia3.setText("Fisica");
        text_materia4.setText("Ingles");

    }

    private void prepararButton(){
        preg_1 = findViewById(R.id.preg_1);
        preg_2 = findViewById(R.id.preg_2);
        preg_3 = findViewById(R.id.preg_3);
        preg_4 = findViewById(R.id.preg_4);
        preg_5 = findViewById(R.id.preg_5);
        preg_6 = findViewById(R.id.preg_6);
        preg_7 = findViewById(R.id.preg_7);
        preg_8 = findViewById(R.id.preg_8);
        preg_9 = findViewById(R.id.preg_9);
        preg_10 = findViewById(R.id.preg_10);
        preg_11 = findViewById(R.id.preg_11);
        preg_12 = findViewById(R.id.preg_12);
        preg_13 = findViewById(R.id.preg_1);
        preg_14 = findViewById(R.id.preg_1);
        preg_15 = findViewById(R.id.preg_1);
        preg_16 = findViewById(R.id.preg_1);
        preg_17 = findViewById(R.id.preg_1);

    }
    private void procesarPreguntas(){
        mostrarPregunta(materiaIndex,preguntaIntex);
    }

    private void mostrarPregunta(int materiaIndex, int preguntaIndex){
        try{

            Materia materia = MateriaList.get(materiaIndex);
            ArrayList<Pregunta> preguntas = materia.getPreguntas();
            String textoPregunta = preguntas.get(preguntaIndex).getTexto();
            texto_pregunta.setText(textoPregunta);
            ArrayList<Respuesta> respuestas = preguntas.get(preguntaIndex).getRespuestas();
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
                    default:
                        radio4.setText(respuesta.getTexto());
                        break;
                }
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void alert(){
        // Create Alert using Builder
        CFAlertDialog.Builder builder = new CFAlertDialog.Builder(this)
                .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
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
        new RestIniciarPsa(area_id) {
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
                        JSONArray preguntasJSON = jsonMaterias.getJSONArray("preguntas");
                        ArrayList<Pregunta> preguntas = new ArrayList<>();
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
                                    respuestas
                            );
                            preguntas.add(pregunta);
                        }

                        Materia materia = new Materia(
                                jsonMaterias.getInt("id"),
                                jsonMaterias.getString("nombre"),
                                preguntas
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
        switch (id){
            case R.id.preg_1:
                mostrarPregunta(0,0);
                Toast.makeText(getApplicationContext(),"preg_1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.preg_2:
                mostrarPregunta(0,1);
                Toast.makeText(getApplicationContext(),"preg_2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.preg_3:
                mostrarPregunta(0,2);
                Toast.makeText(getApplicationContext(),"preg_3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.preg_4:
                mostrarPregunta(0,3);
                Toast.makeText(getApplicationContext(),"preg_4",Toast.LENGTH_SHORT).show();
                break;
            case R.id.preg_5:
                break;
            case R.id.preg_6:
                break;
            case R.id.preg_7:
                break;
            case R.id.preg_8:
                break;
            case R.id.preg_9:
                break;
            case R.id.preg_10:
                break;


            case R.id.preg_11:
                break;
            case R.id.preg_12:
                break;
            case R.id.preg_13:
                break;
            case R.id.preg_14:
                break;
            case R.id.preg_15:
                break;
            case R.id.preg_16:
                break;
            case R.id.preg_17:
                break;
            case R.id.preg_18:
                break;
            case R.id.preg_19:
                break;
            case R.id.preg_20:
                break;


            case R.id.preg_21:
                break;
            case R.id.preg_22:
                break;
            case R.id.preg_23:
                break;
            case R.id.preg_24:
                break;
            case R.id.preg_25:
                break;
            case R.id.preg_26:
                break;
            case R.id.preg_27:
                break;
            case R.id.preg_28:
                break;
            case R.id.preg_29:
                break;
            case R.id.preg_30:
                break;


            case R.id.preg_31:
                break;
            case R.id.preg_32:
                break;
            case R.id.preg_33:
                break;
            case R.id.preg_34:
                break;
            case R.id.preg_35:
                break;
            case R.id.preg_36:
                break;
            case R.id.preg_37:
                break;
            case R.id.preg_38:
                break;
            case R.id.preg_39:
                break;
            case R.id.preg_40:
                break;

        }
    }
}
