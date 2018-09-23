package com.biessap.biessap.models;

import org.json.JSONObject;

public class Ciudad {
    int id;
    String nombre;
    String color;

    public Ciudad(int id, String nombre, String color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
    }

    public Ciudad() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Ciudad parser(JSONObject jsonObject){
        Ciudad ciudad = new Ciudad();

        try{
            ciudad.setId(jsonObject.getInt("id"));
        }catch (Exception e){}
        try{
            ciudad.setNombre(jsonObject.getString("nombre"));
        }catch (Exception e){}
        try{
            ciudad.setColor(jsonObject.getString("color"));
        }catch (Exception e){}

        return ciudad;
    }
}
