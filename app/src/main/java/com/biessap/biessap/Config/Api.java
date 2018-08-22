package com.biessap.biessap.Config;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api {

    public static String get(String ruta){
        StringBuilder json = new StringBuilder();
        try {
            URL url = new URL(ruta);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();

            InputStream input = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

            String linea = "";
            while ((linea = bufferedReader.readLine()) != null) {
                json.append(linea);
            }
        } catch (Exception e) {
            return "error de url"+e.getMessage();
        }
        return json.toString();
    }

    public static String post(String Ruta, JSONObject json){
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
            OutputStream out = urlConnection.getOutputStream();
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
            return e.getMessage();
        }
        return res.toString();
    }
}
