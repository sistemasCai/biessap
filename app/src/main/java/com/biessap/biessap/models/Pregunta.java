package com.biessap.biessap.models;

import java.util.ArrayList;

public class Pregunta {

    int id;
    String texto;
    String image;
    ArrayList<Respuesta> respuestas;

    public Pregunta(int id, String texto, String image, ArrayList<Respuesta> respuestas) {
        this.id = id;
        this.texto = texto;
        this.image = image;
        this.respuestas = respuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
