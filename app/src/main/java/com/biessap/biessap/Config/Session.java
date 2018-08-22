package com.biessap.biessap.Config;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import org.json.JSONObject;

public class Session     {

    public static final String email = "email";
    public static final String password = "password";
    public static final String token =  "token";
    public static final String role = "role";
    public static final String id_user = "id_user";

    public static void setUserdata(Context context, JSONObject jsonObject){
        SharedPreferences preferences = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        try{
            editor.putString(email,jsonObject.getString(email));
            editor.putString(password,jsonObject.getString(password));
            editor.putString(role,jsonObject.getString(role));  // el token tiene el id del usuario
        }catch (Exception e){
            Log.e("errorSession",e.getMessage());
        }
        editor.commit();
    }

    public static String[] getUserData(Context context){
        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
        if(p.getString(email,null)==null){
            return null;
        }
        String[] datos = {
                p.getString(email,""),
                p.getString(password,""),
                p.getString(role,"")
        };
        return datos;
    }

    public static void cerrarSession(Context context){
        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.clear();
        editor.commit();
    }

    public static void setStatus(Context context, int estatus){
        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putInt("status",estatus);
        editor.commit();
    }

    public static int getStatus(Context context){
        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
        return p.getInt("status",1);
    }

    public static void Iduser(Context context,int id_usuario){
        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = p.edit();
        editor.putInt("IdUser",id_usuario);
        editor.commit();
    }

    public static int getIdUser(Context context){
        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
        return p.getInt("IdUser",-1);
    }


//    public static void IdDistrito(Context context,int idDistrito){
//        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = p.edit();
//        editor.putInt("IdDistrito",idDistrito);
//        editor.commit();
//    }
//
//    public static int getIdDistrito(Context context){
//        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
//        return p.getInt("IdDistrito",-1);
//    }
//
//
//    public static void guardarDistritos(Context context, String data){
//        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = p.edit();
//        editor.putString("distritos",data);
//        editor.commit();
//    }
//
//    public static String getDistritos(Context context){
//        SharedPreferences p = context.getSharedPreferences(Env.Preferences,Context.MODE_PRIVATE);
//        return p.getString("distritos","data");
//    }
}
