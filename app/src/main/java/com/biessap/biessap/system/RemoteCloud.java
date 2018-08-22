package com.biessap.biessap.system;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;


public class RemoteCloud extends AsyncTask<String, String, String> {

    ProgressDialog progressDialog;
    Context context;
    HashMap<String,String> config;
    public static final String METODO = "metodo";
    public static final String JSON = "json";
    public static final String URL = "url";
    public static final String POST = "POST";
    public static final String GET = "GET";
    public RemoteCloud(Context context, HashMap<String,String> config) {
        this.config = config;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Espere Por Favor");
        progressDialog.setMessage("Conectando el servidor...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String metodo = config.get(METODO);
        if(metodo.equalsIgnoreCase(POST)){
            try{
                JSONObject jsonObject = new JSONObject(config.get(JSON));
                return Api.post(config.get(URL),jsonObject);
            }catch (Exception e){
                Log.e("errorJson","Error Json");
                return e.getMessage();
            }
        }
        return Api.get(config.get(URL));
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        finalmente(s);
        progressDialog.dismiss();
    }

    public void finalmente(String s){
    }
}