package com.biessap.biessap.Activitys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestLoginFacebook;
import com.biessap.biessap.system.Session;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private GoogleApiClient googleApiClient;
    private SignInButton signInButton;
    public static final int SIGN_IN_CODE = 777;
    private CallbackManager mCallbackManager;
    protected ProgressDialog mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);


        habilitarAutenticacionConFacebook();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        signInButton = findViewById(R.id.btn_signin);

        signInButton.setSize(SignInButton.SIZE_WIDE);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,SIGN_IN_CODE);
            }
        });

        Button btnFacebook = findViewById(R.id.btnFacebook);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSessionFacebook();
            }
        });
    }


    private void habilitarAutenticacionConFacebook() {
        mCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("success", loginResult.getAccessToken().getToken());

                mProgress = new ProgressDialog(LoginActivity.this);
                mProgress.setMessage("Obteniendo Datos");
                mProgress.show();
                String token = loginResult.getAccessToken().getToken();
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        LoginManager.getInstance().logOut();
                        mProgress.dismiss();
                        getDataFacebook(object);
                        Log.i("response", object.toString());
                    }
                });

                Bundle parametres = new Bundle();
                parametres.putString("fields", "id,email,name,last_name,picture");
                request.setParameters(parametres);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "onError", Toast.LENGTH_SHORT).show();
            }
        });

        Button loginButton = (Button) findViewById(R.id.button_facebook_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile, email"));
            }
        });
        if (AccessToken.getCurrentAccessToken() != null) {
            Toast.makeText(getApplicationContext(), AccessToken.getCurrentAccessToken().getUserId(), Toast.LENGTH_SHORT).show();
        }

    }

    private void getDataFacebook(JSONObject object) {
        try {
            String Id = object.getString("id");
            String Nombre = object.getString("name");
            String Apellidos = object.getString("last_name");


            String Email = object.getString("email");
            consultar(Nombre ,Apellidos, Email, "", Id, "", "", "0", 2);
            finish();
        } catch (Exception e) {
            Log.e("getDataFacebook", e.getMessage());
        }
    }

    private void consultar(String nombre,String apellido, String correo, String contrasena, String facebookId, String googleId, String telefono, String genero, int tipo) {
        Intent i = new Intent(LoginActivity.this,MenuActivity.class);
        startActivity(i);
        /*new RegistroUsuario(nombre, apellido,correo, contrasena, facebookId, googleId, telefono, genero, tipo) {
            @Override
            protected void onError() {

            }

            @Override
            protected void onEmpty(String s) {
            }

            @Override
            protected void onSuccess(String s) {

                try {
                    mProgress.dismiss();
                    JSONObject jsonObject = new JSONObject(s);
                    JSONObject data = jsonObject.getJSONObject("Data");
                    if (data != null) {
                        Session session = new Session(LoginActivity.this);
                        boolean validacion = session.setDataSession(data);
                        if (validacion) {
                            Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error de Servidor", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Fallo al Iniciar Session", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error de Servidor", Toast.LENGTH_SHORT).show();
                }

            }
        }.runBackground();*/
    }
    private void iniciarSessionFacebook(){
        String email = "darling@gmail.com";
        int facebookId = 22323234;
        String name = "darling Valencia";
        new RestLoginFacebook(email,name, facebookId) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getApplicationContext(),code,Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONObject datos = jsonObject.getJSONObject("datos");
                    Session session = new Session(LoginActivity.this);
                    session.setDataSession(datos);
                    goMainScreen();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT);
                }
            }
        }.runDialog(this);
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == SIGN_IN_CODE){
            GoogleSignInResult result =  Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            goMainScreen();
        }else{
            Toast.makeText(this,"no se puede",Toast.LENGTH_SHORT).show();
        }
    }

    private void goMainScreen() {
        Intent intent  = new Intent(this,PaisActivity.class);
        getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
