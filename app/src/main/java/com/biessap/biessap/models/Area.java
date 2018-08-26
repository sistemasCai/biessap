package com.biessap.biessap.models;

import org.json.JSONObject;

public class Area {
    int id;
    String nombre;
    String nivel;

    public Area(int id, String nombre, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Area() {
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public static Area parser(JSONObject jsonObject){
        Area area = new Area();
        try{
            area.setId(jsonObject.getInt("id"));
        }catch (Exception e){}

        try{
            area.setNombre(jsonObject.getString("nivel"));
        }catch (Exception e){}

        try{
            area.setNivel(jsonObject.getString("nombre"));
        }catch (Exception e){}

        return area;
    }
}
