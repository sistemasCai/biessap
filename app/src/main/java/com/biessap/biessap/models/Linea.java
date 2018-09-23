package com.biessap.biessap.models;

import org.json.JSONObject;

public class Linea {
    int id = 0;
    String nombre;
    String tipo;
    String color;

    public Linea(int id, String nombre, String tipo, String color) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.color = color;
    }

    public Linea(){

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static Linea parser(JSONObject jsonObject){
        Linea linea = new Linea();
        try{
            linea.setId(0);
        }catch (Exception e){}
        try{
            linea.setColor(jsonObject.getString("color"));
        }catch (Exception e){}
        try{
            linea.setNombre(jsonObject.getString("nombre"));
        }catch (Exception e){}
        try{
            linea.setTipo(jsonObject.getString("tipo"));
        }catch (Exception e){}
        return linea;
    }
}
