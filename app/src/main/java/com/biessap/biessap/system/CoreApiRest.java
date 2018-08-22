package com.biessap.biessap.system;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONObject;
import cn.pedant.SweetAlert.SweetAlertDialog;

public abstract class CoreApiRest {
    protected final int JSON_OBJECT = 1;
    protected final int JSON_ARRAY = 0;
    protected Configuracion configuracion;
    public CoreApiRest(){
        this.configuracion = new Configuracion();
    }

    public void runBackground(){
        new peticionInterna().execute();
    }

    public void runDialog(Context context){
        new peticionExterna(context).execute();
    }

    class peticionInterna extends AsyncTask<String,String,String>{

        @Override
        protected String doInBackground(String... strings) {
            return runService();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                if(getTipoJSON() == JSON_OBJECT){
                    JSONObject json = new JSONObject(s);
                    if(!jsonObjectEmpty(s)){
                        onSuccess(s);
                    }else{
                        onEmpty(s);
                    }
                }
                else{
                    if(!jsonArrayEmpty(s)){
                        onSuccess(s);
                    }else{
                        onEmpty(s);
                    }
                }
            }catch (Exception e){
                Log.e("CoreApiRest",e.getMessage());
                    onError();
            }
        }
    }


    class peticionExterna extends AsyncTask<String,String,String>{

        Context context;
        public peticionExterna(Context context){
            this.context = context;
        }

        SweetAlertDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
            pDialog.setTitle("Cargando...");
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            return runService();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                if(getTipoJSON() == JSON_OBJECT){
                    JSONObject json = new JSONObject(s);
                    if(!jsonObjectEmpty(s)){
                        onSuccess(s);
                    }else{
                        onEmpty(s);
                    }
                }
                else{
                    if(!jsonArrayEmpty(s)){
                        onSuccess(s);
                    }else{
                        onEmpty(s);
                    }
                }
            }catch (Exception e){
                Log.e("CoreApiRest",e.getMessage());
                onError();
            }
            pDialog.dismissWithAnimation();
        }
    }

    protected abstract void onError();

    protected abstract void onEmpty(String s);

    protected abstract void onSuccess(String s);

    private boolean jsonObjectEmpty(String s) {
      return s.equalsIgnoreCase("{}");
    }

    private boolean jsonArrayEmpty(String s){
        return s.equalsIgnoreCase("[]");
    }

    protected abstract int getTipoJSON();

    protected abstract String runService();
}
