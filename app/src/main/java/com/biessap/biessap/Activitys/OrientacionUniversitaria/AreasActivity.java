package com.biessap.biessap.Activitys.OrientacionUniversitaria;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.biessap.biessap.Activitys.MenuActivity;
import com.biessap.biessap.Adapters.TabPageAdapter;
import com.biessap.biessap.CoreApplication.CoreFragment;
import com.biessap.biessap.Fragments.AreasFragments.LicenciaturaFragment;
import com.biessap.biessap.Fragments.AreasFragments.TecnicoMedioFragment;
import com.biessap.biessap.Fragments.AreasFragments.TecnicoSuperiorFragment;
import com.biessap.biessap.R;

public class AreasActivity extends AppCompatActivity implements CoreFragment.OnFragmentInteractionListener {

    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Atras");

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        CardView btn_inicio = findViewById(R.id.btn_inicio);
        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AreasActivity.this, MenuActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
                finish();
            }
        });
    }

    private void setupViewPager(ViewPager pager){
        TabPageAdapter adapter = new TabPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new LicenciaturaFragment(),"Licenciatura");
        adapter.addFragment(new TecnicoSuperiorFragment(),"Tecnico Superior");
        adapter.addFragment(new TecnicoMedioFragment(), "Tecnico Medio");
        pager.setAdapter(adapter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

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
