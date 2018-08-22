package com.biessap.biessap.system;
import android.content.Context;
import android.content.SharedPreferences;

import com.biessap.biessap.models.DataSession;

import org.json.JSONObject;

public class Session {
    Context context;

    public static final int CODIGO_SIN_DB = -243;

    public Session(Context context){
        this.context = context;
    }

    public boolean setDataSession(JSONObject data){
        try {
            SharedPreferences prefsLogin;
            prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefsLogin.edit();
            //Inicio de Sesion
            editor.putBoolean("iniciarSesion", true);
            editor.putInt("versioDB",CODIGO_SIN_DB);
            //Datos Usuario
            String nombre = (data.getString("sNombres")=="null")?"":data.getString("sNombres");
            String apellidos = (data.getString("sApellidos") == "null")?"":data.getString("sApellidos");
            String correo = (data.getString("sCorreo") == "null") ? "":data.getString("sCorreo");
            String telefono = (data.getString("sTelefono") == "null") ? "":data.getString("sTelefono");
            String fb = (data.getString("sFacebookId")=="null")?"":data.getString("sFacebookId");
            String gogle = (data.getString("sGoogleId") == "null") ? "":data.getString("sGoogleId");
            String nit = ( data.getString("sNit") == "null") ? "" :  data.getString("sNit");
            String razon = (data.getString("sRazonSocial") == "null") ? "": data.getString("sRazonSocial");
            editor.putInt("nUsuarioId", data.getInt("nUsuarioId"));
            editor.putString("sNombres", nombre);
            editor.putString("sApellidos", apellidos);
            editor.putString("sCorreo", correo);
            editor.putString("sTelefono", telefono);
            editor.putString("sFacebookId", fb);
            editor.putString("sGoogleId", gogle);
            editor.putString("sNit",nit);
            editor.putString("sRazonSocial", razon);
            editor.putInt("nGenero",data.getInt("nGenero"));
            editor.apply();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean setDataSession(DataSession session, Context context){
        SharedPreferences prefsLogin;
        prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefsLogin.edit();
        //Inicio de Sesion
        editor.putBoolean("iniciarSesion", true);
        //Datos Usuario
        /*editor.putInt("nUsuarioId", session.getnUsuarioId());
        editor.putString("sNombres", session.getsNombres());
        editor.putString("sApellidos", session.getsApellidos());
        editor.putString("sCorreo", session.getsCorreo());
        editor.putString("sTelefono", session.getsTelefono());
        editor.putString("sFacebookId", session.getsFacebookId());
        editor.putString("sGoogleId", session.getsGoogleId());
        editor.putString("sNit", session.getsNit());
        editor.putString("sRazonSocial", session.getsRazonSocial());
        editor.putInt("nGenero", session.getnGenero());
        editor.apply();*/
        return true;
    }
    public static DataSession getDataSession(Context context){
        SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        DataSession dataSession = new DataSession();
        return dataSession;
    }

    public static void setVersionDB(int version, Context context){
        SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefsLogin.edit();
        editor.putInt("versioDB", version);
        editor.apply();
    }

    public static int getVersionDB(Context context){
        SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        return prefsLogin.getInt("versionDB",CODIGO_SIN_DB);
    }


    public static boolean clear(Context context){
        SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefsLogin.edit();
        editor.putBoolean("iniciarSesion",false);
        editor.commit();
        return true;
    }
}
