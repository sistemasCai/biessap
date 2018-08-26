package com.biessap.biessap.models;

public class Facultad {
    int id;
    String nombre;
    int id_institucion;
    String sigla;

    public Facultad(int id, String nombre, int id_institucion, String sigla) {
        this.id = id;
        this.nombre = nombre;
        this.id_institucion = id_institucion;
        this.sigla = sigla;
    }

    public Facultad() {
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

    public int getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(int id_institucion) {
        this.id_institucion = id_institucion;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
