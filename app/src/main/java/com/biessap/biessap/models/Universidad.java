package com.biessap.biessap.models;

import org.json.JSONObject;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;

public class Universidad implements Serializable{
    int id;
    String nombre;
    String logo;
    String mapeo_interno;
    double lat;
    double lng;
    String gestion;
    String fecha_actualizacion;
    String fecha_inscripcion;
    String fecha_inico_clases;
    String beneficios;
    String requisitos;
    String ubicacion;
    String telefono;
    String correo;
    String link_web;
    String link_maps;
    String link_facebook;
    String link_twitter;
    String ciudad_id;
    String tipo;
    String link_youtube;
    String portada;
    int estado;
    String tipo_imagen;

    public String getLink_youtube() {
        return link_youtube;
    }

    public void setLink_youtube(String link_youtube) {
        this.link_youtube = link_youtube;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTipo_imagen() {
        return tipo_imagen;
    }

    public void setTipo_imagen(String tipo_imagen) {
        this.tipo_imagen = tipo_imagen;
    }

    public Universidad(int id, String nombre, String logo, String mapeo_interno, double lat, double lng, String gestion, String fecha_actualizacion, String fecha_inscripcion, String fecha_inico_clases, String beneficios, String requisitos, String ubicacion, String telefono, String correo, String link_web, String link_maps, String link_facebook, String link_twitter, String ciudad_id, String tipo, String link_youtube, String portada, int estado, String tipo_imagen) {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
        this.mapeo_interno = mapeo_interno;
        this.lat = lat;
        this.lng = lng;
        this.gestion = gestion;
        this.fecha_actualizacion = fecha_actualizacion;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_inico_clases = fecha_inico_clases;
        this.beneficios = beneficios;
        this.requisitos = requisitos;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.correo = correo;
        this.link_web = link_web;
        this.link_maps = link_maps;
        this.link_facebook = link_facebook;
        this.link_twitter = link_twitter;
        this.ciudad_id = ciudad_id;
        this.tipo = tipo;
        this.link_youtube = link_youtube;
        this.portada = portada;
        this.estado = estado;
        this.tipo_imagen = tipo_imagen;
    }

    public Universidad() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGestion() {
        return gestion;
    }

    public void setGestion(String gestion) {
        this.gestion = gestion;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLink_web() {
        return link_web;
    }

    public void setLink_web(String link_web) {
        this.link_web = link_web;
    }

    public String getLink_maps() {
        return link_maps;
    }

    public void setLink_maps(String link_maps) {
        this.link_maps = link_maps;
    }

    public String getLink_facebook() {
        return link_facebook;
    }

    public void setLink_facebook(String link_facebook) {
        this.link_facebook = link_facebook;
    }

    public String getLink_twitter() {
        return link_twitter;
    }

    public void setLink_twitter(String link_twitter) {
        this.link_twitter = link_twitter;
    }

    public String getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(String ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public String getFecha_inico_clases() {
        return fecha_inico_clases;
    }

    public void setFecha_inico_clases(String fecha_inico_clases) {
        this.fecha_inico_clases = fecha_inico_clases;
    }

    public static Universidad parser(JSONObject jsonObject){
        Universidad universidad = new Universidad();
        try{
            universidad.setId(jsonObject.getInt("id"));
        }catch (Exception e){}
        try{
            universidad.setNombre(jsonObject.getString("nombre"));
        }catch (Exception e){}
        try{
            universidad.setLogo(jsonObject.getString("logo"));
        }catch (Exception e){}

        try{
            universidad.setMapeo_interno(jsonObject.getString("mapeo_interno"));
        }catch (Exception e){}
        try{
            universidad.setLat(jsonObject.getDouble("lat"));
        }catch (Exception e){}
        try{
            universidad.setLat(jsonObject.getDouble("lng"));
        }catch (Exception e){}
        try{
            universidad.setGestion(jsonObject.getString("gestion"));
        }catch (Exception e){}
        try{
            universidad.setFecha_actualizacion(jsonObject.getString("fecha_actualizacion"));
        }catch (Exception e){}
        try{
            universidad.setFecha_inscripcion(jsonObject.getString("fecha_inscripcion"));
        }catch (Exception e){}

        try{
            universidad.setFecha_inico_clases(jsonObject.getString("fecha_inico_clases"));
        }catch (Exception e){}
        try{
            universidad.setBeneficios(jsonObject.getString("beneficios"));
        }catch (Exception e){}
        try{
            universidad.setRequisitos(jsonObject.getString("requisitos"));
        }catch (Exception e){}

        try{
            universidad.setUbicacion(jsonObject.getString("ubicacion"));
        }catch (Exception e){}
        try{
            universidad.setTelefono(jsonObject.getString("telefono"));
        }catch (Exception e){}
        try{
            universidad.setCorreo(jsonObject.getString("correo"));
        }catch (Exception e){}
        try{
            universidad.setLink_web(jsonObject.getString("link_web"));
        }catch (Exception e){}
        try{
            universidad.setLink_maps(jsonObject.getString("link_maps"));
        }catch (Exception e){}
        try{
            universidad.setLink_facebook(jsonObject.getString("link_facebook"));
        }catch (Exception e){}
        try{
            universidad.setCorreo(jsonObject.getString("link_twitter"));
        }catch (Exception e){}
        try{
            universidad.setTipo(jsonObject.getString("tipo"));
        }catch (Exception e){}
        try{
            universidad.setLink_youtube(jsonObject.getString("link_youtube")); // ultimos agregados
        }catch (Exception e){}
        try{
            universidad.setPortada(jsonObject.getString("portada"));
        }catch (Exception e){}
        try{
            universidad.setEstado(jsonObject.getInt("estado"));
        }catch (Exception e){}
        try{
            universidad.setTipo_imagen(jsonObject.getString("tipo_imagen"));
        }catch (Exception e){}
        return universidad;
    }
}
