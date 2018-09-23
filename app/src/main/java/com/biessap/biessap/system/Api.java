package com.biessap.biessap.system;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by movil on 13/08/2017.
 */

public class Api {

    public static final String NET_ERROR = "Error al conectar con servidor";

    public static String get(String ruta){
        int responseCode = 408;
        StringBuilder json = new StringBuilder();
        try {
            URL url = new URL(ruta);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.setConnectTimeout(4000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();


            responseCode = httpURLConnection.getResponseCode();
            InputStream input = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

            String linea = "";
            while ((linea = bufferedReader.readLine()) != null) {
                json.append(linea);
            }
        } catch (Exception e) {
            return ""+responseCode;
        }
        return json.toString();
    }

    public static String post(String Ruta, JSONObject json){
        StringBuilder res = new StringBuilder("");
        int responseCode = 408;
        // conectar con el servidor
        try {
            URL url = new URL(Ruta);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setDoOutput(true); // salida de datos = true
            urlConnection.setConnectTimeout(3000);
            urlConnection.connect();

            // envio a al servidor
            OutputStream out= urlConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write(json.toString());
            bufferedWriter.flush();

            // respuesta del servidor

            InputStream in = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            responseCode = urlConnection.getResponseCode();

            String linea = "";

            while ((linea = bufferedReader.readLine())!=null){
                res.append(linea);
            }

            bufferedReader.close();
            bufferedWriter.close();
        }catch (Exception e){
            String data = e.getMessage();
            return ""+responseCode;
        }

        return res.toString();
    }

    public static String post(String Ruta, JSONArray json){
        StringBuilder res = new StringBuilder("");
        // conectar con el servidor
        try {
            URL url = new URL(Ruta);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type","application/json");
            urlConnection.setDoOutput(true); // salida de datos = true
            urlConnection.setConnectTimeout(3000);
            urlConnection.connect();

            // envio a al servidor
            OutputStream out= urlConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write(json.toString());
            bufferedWriter.flush();

            // respuesta del servidor

            InputStream in = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));


            String linea = "";

            while ((linea = bufferedReader.readLine())!=null){
                res.append(linea);
            }

            bufferedReader.close();
            bufferedWriter.close();
        }catch (Exception e){
            Log.e("serverError",e.getMessage());
            return NET_ERROR;
        }

        return res.toString();
    }
}
