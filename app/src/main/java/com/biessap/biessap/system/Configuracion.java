package com.biessap.biessap.system;

public class Configuracion {

    private final String dominio = "http://213.136.88.102:8081";
    private final String api = "/" + "fexpocruz/service" + "/";
    private final String baseUrl = dominio+api;

    public Configuracion(){
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
