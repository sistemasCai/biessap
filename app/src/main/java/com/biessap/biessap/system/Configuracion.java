package com.biessap.biessap.system;

public class Configuracion {

    private final String dominio = "http://213.136.88.102:8081";
    private final String api = "/" + "fexpocruz/service" + "/";

    private final String baseUrl = dominio+api;
    //private final String baseUrl = "http://192.168.0.249/FexpoCruz/Service/";
    //private final String nombreDatabase = "fexpocruz";
    //private final String urlDataBase = "http://213.136.88.102:8081/fexpocruz/recursos/sqlite/fexpocruz_3.sqlite";
    //private final String dominioApplication = "/data/data/com.osbolivia.fexpocruz/databases/";
    public Configuracion(){
    }

    public String getBaseUrl() {
        return baseUrl;
    }
/*
    public String getNombreDatabase() {
        return nombreDatabase;
    }

    public String getUrlDataBase() {
        return urlDataBase;
    }

    public String getDominioApplication() {
        return dominioApplication;
    }*/
}
