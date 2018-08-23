package com.biessap.biessap.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.biessap.biessap.Activitys.OrientacionUniversitaria.ActivityOrientacion;
import com.biessap.biessap.R;
import com.google.android.gms.common.api.GoogleApiClient;

public class HomeActivity extends AppCompatActivity{

    private ImageView photo;
    private TextView name;
    private TextView email;
    private TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        /*photo = findViewById(R.id.photo);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);*/

        
    }
}
