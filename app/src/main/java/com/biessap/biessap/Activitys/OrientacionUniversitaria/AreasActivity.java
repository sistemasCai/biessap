package com.biessap.biessap.Activitys.OrientacionUniversitaria;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Atras");
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
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
