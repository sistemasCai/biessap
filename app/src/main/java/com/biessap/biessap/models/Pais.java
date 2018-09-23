package com.biessap.biessap.models;

import org.json.JSONObject;

public class Pais {
    int id;
    String nombre;
    String image;

    public Pais(int id, String nombre, String image) {
        this.id = id;
        this.nombre = nombre;
        this.image = image;
    }

    public Pais() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Pais parser(JSONObject jsonObject){
        Pais pais = new Pais();
        try{
            pais.setId(jsonObject.getInt("id"));
        }catch (Exception e){}
        try{

            pais.setImage("vacio");
        }catch (Exception e){}
        try{

            pais.setNombre(jsonObject.getString("nombre"));
        }catch (Exception e){}
        return  pais;
    }
}
