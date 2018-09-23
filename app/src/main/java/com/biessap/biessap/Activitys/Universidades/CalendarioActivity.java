package com.biessap.biessap.Activitys.Universidades;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.CoreApplication.CoreFragment;
import com.biessap.biessap.Fragments.CalendarioFragments.InscripcionFragment;
import com.biessap.biessap.Fragments.CalendarioFragments.RequisitoFragment;
import com.biessap.biessap.R;
import com.biessap.biessap.models.Universidad;

public class CalendarioActivity extends AppCompatActivity implements CoreFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getBundleExtra("universidad");
        final Universidad uni = (Universidad) bundle.getSerializable("universidad");
        setTitle(uni.getNombre());
        final LinearLayout btn_inscripciones = findViewById(R.id.btn_inscripcion);
        final LinearLayout btn_requisito = findViewById(R.id.btn_requisito);

        final TextView text_inscripcion = findViewById(R.id.text_inicripcion);
        final TextView text_requisito = findViewById(R.id.text_requisito);
        TextView text_gestion = findViewById(R.id.gestion);
        text_gestion.setText(uni.getGestion());

        btn_inscripciones.setBackgroundColor(Color.parseColor("#9dbcde"));
        text_inscripcion.setTextColor(Color.WHITE);
        text_requisito.setTextColor(Color.parseColor("#9dbcde"));
        btn_requisito.setBackgroundColor(Color.WHITE);
        InscripcionFragment inscripcionFragment = new InscripcionFragment();
        inscripcionFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, inscripcionFragment);
        fragmentTransaction.commit();

        btn_inscripciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn_inscripciones.setBackgroundColor(Color.parseColor("#9dbcde"));
                text_inscripcion.setTextColor(Color.WHITE);
                text_requisito.setTextColor(Color.parseColor("#9dbcde"));
                btn_requisito.setBackgroundColor(Color.WHITE);
                InscripcionFragment inscripcionFragment = new InscripcionFragment();
                inscripcionFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_content, inscripcionFragment);
                fragmentTransaction.commit();
            }
        });

        btn_requisito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_requisito.setBackgroundColor(Color.parseColor("#9dbcde"));
                text_requisito.setTextColor(Color.WHITE);
                text_inscripcion.setTextColor(Color.parseColor("#9dbcde"));
                btn_inscripciones.setBackgroundColor(Color.WHITE);
                RequisitoFragment requisitoFragment = new RequisitoFragment();
                requisitoFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_content, requisitoFragment);
                fragmentTransaction.commit();
            }
        });

        CardView btn_inicio = findViewById(R.id.btn_inicio);
        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CalendarioActivity.this, MenuActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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
