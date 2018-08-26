package com.biessap.biessap.models;

import org.json.JSONObject;

public class Universidad {
    int id;
    String nombre;
    String logo;
    String mapeo_interno;
    double lat;
    double lng;
    String fecha_actualizacion;
    String privada;
    String nombre_gestion;
    String fecha_inscripcion;
    String fecha_inicio_clases;
    String costo_inscripcion;
    String costo_matricula;
    String promocion;
    String id_ciudad;
    String sigla;
    String clase;

    public Universidad(int id, String nombre, String logo, String mapeo_interno, double lat, double lng, String fecha_actualizacion, String privada, String nombre_gestion, String fecha_inscripcion, String fecha_inicio_clases, String costo_inscripcion, String costo_matricula, String promocion, String id_ciudad, String sigla, String clase) {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
        this.mapeo_interno = mapeo_interno;
        this.lat = lat;
        this.lng = lng;
        this.fecha_actualizacion = fecha_actualizacion;
        this.privada = privada;
        this.nombre_gestion = nombre_gestion;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_inicio_clases = fecha_inicio_clases;
        this.costo_inscripcion = costo_inscripcion;
        this.costo_matricula = costo_matricula;
        this.promocion = promocion;
        this.id_ciudad = id_ciudad;
        this.sigla = sigla;
        this.clase = clase;
    }

    public Universidad() {
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getMapeo_interno() {
        return mapeo_interno;
    }

    public void setMapeo_interno(String mapeo_interno) {
        this.mapeo_interno = mapeo_interno;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public String getPrivada() {
        return privada;
    }

    public void setPrivada(String privada) {
        this.privada = privada;
    }

    public String getNombre_gestion() {
        return nombre_gestion;
    }

    public void setNombre_gestion(String nombre_gestion) {
        this.nombre_gestion = nombre_gestion;
    }

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public String getFecha_inicio_clases() {
        return fecha_inicio_clases;
    }

    public void setFecha_inicio_clases(String fecha_inicio_clases) {
        this.fecha_inicio_clases = fecha_inicio_clases;
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

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public String getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public static Universidad parser(JSONObject jsonObject){
        Universidad universidad = new Universidad();
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}
        try{

        }catch (Exception e){}



        return universidad;
    }
}
