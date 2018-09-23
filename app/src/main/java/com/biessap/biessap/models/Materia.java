package com.biessap.biessap.models;

import java.util.ArrayList;

public class Materia {
    int id;
    String nombre;
    ArrayList<Pregunta> preguntas;

    public Materia(int id, String nombre, ArrayList<Pregunta> preguntas) {
        this.id = id;
        this.nombre = nombre;
        this.preguntas = preguntas;
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

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
