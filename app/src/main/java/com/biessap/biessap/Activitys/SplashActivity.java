package com.biessap.biessap.Activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.biessap.biessap.R;
import com.biessap.biessap.models.DataSession;
import com.biessap.biessap.system.Session;

import org.json.JSONObject;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                Intent menuIntent = new Intent(SplashActivity.this, MenuActivity.class);
                DataSession dataSession = Session.getDataSession(SplashActivity.this);
                int iniciarsesion = dataSession.getId();
                if (iniciarsesion != -1) {
                    startActivity(menuIntent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    SplashActivity.this.finish();
                } else {
                    startActivity(loginIntent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    SplashActivity.this.finish();
                }
            }
        }, 4100);
    }

}
