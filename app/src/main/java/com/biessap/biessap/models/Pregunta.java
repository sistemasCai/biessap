package com.biessap.biessap.models;

import java.util.ArrayList;

public class Pregunta {

    int id;
    String texto;
    String image;
    int respondida = -1;
    int checkId = 0;
    ArrayList<Respuesta> respuestas;
    int materiaId;

    public Pregunta(int id, String texto, String image, ArrayList<Respuesta> respuestas,int materiaId) {
        this.id = id;
        this.texto = texto;
        this.image = image;
        this.respuestas = respuestas;
        this.materiaId = materiaId;
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public int getMateriaId() {
        return materiaId;
    }


    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public int getRespondida() {
        return respondida;
    }

    public void setRespondida(int respondida) {
        this.respondida = respondida;
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
