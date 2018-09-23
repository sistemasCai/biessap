package com.biessap.biessap.system;

public class Configuracion {

    private final String dominio = "http://admin.el-bachiller.com";
    private final String api = "/" + "api" + "/";
    private final String baseUrl = dominio+api;
    public static final String URL_IMAGE = "http://admin.el-bachiller.com/storage/";

    public Configuracion(){
    }

    public String getBaseUrl() {
        return baseUrl;
    }

}
