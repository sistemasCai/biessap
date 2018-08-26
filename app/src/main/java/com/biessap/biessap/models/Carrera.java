package com.biessap.biessap.models;

public class Carrera {

    int id;
    String nombre;
    int id_facultad;
    int id_area;
    String info_general;
    String imagen;
    String perfil_profesional;
    String perfil_vocacional;
    String tipo;

    public Carrera(int id, String nombre, int id_facultad, int id_area, String info_general, String imagen, String perfil_profesional, String perfil_vocacional, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.id_facultad = id_facultad;
        this.id_area = id_area;
        this.info_general = info_general;
        this.imagen = imagen;
        this.perfil_profesional = perfil_profesional;
        this.perfil_vocacional = perfil_vocacional;
        this.tipo = tipo;
    }

    public Carrera() {
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

    public int getId_facultad() {
        return id_facultad;
    }

    public void setId_facultad(int id_facultad) {
        this.id_facultad = id_facultad;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getInfo_general() {
        return info_general;
    }

    public void setInfo_general(String info_general) {
        this.info_general = info_general;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPerfil_profesional() {
        return perfil_profesional;
    }

    public void setPerfil_profesional(String perfil_profesional) {
        this.perfil_profesional = perfil_profesional;
    }

    public String getPerfil_vocacional() {
        return perfil_vocacional;
    }

    public void setPerfil_vocacional(String perfil_vocacional) {
        this.perfil_vocacional = perfil_vocacional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
