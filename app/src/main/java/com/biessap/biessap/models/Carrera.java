package com.biessap.biessap.models;

import org.json.JSONObject;

public class Carrera {

    int id;
    String nombre;
    String tipo;
    String costo_inscripcion;
    String costo_matricula;
    int institucion_id;

    public Carrera(int id, String nombre, String tipo, String costo_inscripcion, String costo_matricula, int institucion_id) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.costo_inscripcion = costo_inscripcion;
        this.costo_matricula = costo_matricula;
        this.institucion_id = institucion_id;
    }

    public Carrera() {
    }

    public String getCosto_inscripcion() {
        return costo_inscripcion;
    }

    public void setCosto_inscripcion(String costo_inscripcion) {
        this.costo_inscripcion = costo_inscripcion;
    }

    public String getCosto_matricula() {
        return costo_matricula;
    }

    public void setCosto_matricula(String costo_matricula) {
        this.costo_matricula = costo_matricula;
    }

    public int getInstitucion_id() {
        return institucion_id;
    }

    public void setInstitucion_id(int institucion_id) {
        this.institucion_id = institucion_id;
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

    public static Carrera parser(JSONObject jsonObject){
        Carrera carrera = new Carrera();
        try{
            carrera.setId(jsonObject.getInt("id"));
        }catch (Exception e){}
        try{
            carrera.setNombre(jsonObject.getString("nombre"));
        }catch (Exception e){}
        try{
            carrera.setTipo(jsonObject.getString("tipo"));
        }catch (Exception e){}
        try{
            carrera.setCosto_inscripcion(jsonObject.getString("costo_inscripcion"));
        }catch (Exception e){}
        try{
            carrera.setCosto_matricula(jsonObject.getString("costo_matricula"));
        }catch (Exception e){}
        try{
            carrera.setInstitucion_id(jsonObject.getInt("institucion_id"));
        }catch (Exception e){}
        return carrera;
    }
}
