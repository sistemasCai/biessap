package com.biessap.biessap.system;
import android.content.Context;
import android.content.SharedPreferences;

import com.biessap.biessap.models.DataSession;

import org.json.JSONObject;

public class Session {
    Context context;
    public Session(Context context){
        this.context = context;
    }

    public boolean setDataSession(JSONObject data){
        try {
            SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefsLogin.edit();
            //Inicio de Sesion
            //Datos Usuario

            String nombre = (data.getString("name")=="null")?"":data.getString("name");
            String correo = (data.getString("email") == "null") ? "":data.getString("email");
            String avatar = (data.getString("avatar") == "null") ? "":data.getString("avatar");
            String es_premium = (data.getString("premium")=="null")?"":data.getString("premium");
            String celular = (data.getString("celular")=="null")?"":data.getString("celular");
            editor.putInt("id", data.getInt("id"));
            editor.putString("name", nombre);
            editor.putString("email", correo);
            editor.putString("avatar", avatar);
            editor.putString("premium", es_premium);
            editor.putString("celular",celular);
            editor.apply();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static boolean setDataSession(DataSession session, Context context){
        SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefsLogin.edit();
        editor.putInt("id", session.getId());
        editor.putString("name", session.getName());
        editor.putString("email", session.getEmail());
        editor.putString("avatar", session.getAvatar());
        editor.putString("es_premium", session.getEs_premium());
        editor.putString("dio_psa",session.getDio_psa());
        editor.putString("celular",session.getCelular());
        editor.apply();
        return true;
    }


    public static DataSession getDataSession(Context context){
        SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        DataSession session = new DataSession(
          prefsLogin.getInt("id",-1),
          prefsLogin.getString("name",""),
          prefsLogin.getString("email",""),
          prefsLogin.getString("avatar",""),
                prefsLogin.getString("es_premium",""),
                prefsLogin.getString("dio_psa",""),
                prefsLogin.getString("celular","")
        );

        return session;
    }

    public static boolean clear(Context context){
        SharedPreferences prefsLogin = context.getSharedPreferences("DatosUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefsLogin.edit();
        editor.clear();
        editor.commit();
        return true;
    }
}
