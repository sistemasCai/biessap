package com.biessap.biessap.models;

public class Respuesta  {

    int id;
    String texto;
    String image;
    String tipo;

    public Respuesta(int id, String texto, String image, String tipo) {
        this.id = id;
        this.texto = texto;
        this.image = image;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
