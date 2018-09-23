package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

import org.json.JSONObject;

public abstract class RestRegistraCelular extends CoreApiRest{

    int usuario_id;
    String celular;

    public RestRegistraCelular(int usuario_id, String celular) {
        this.usuario_id = usuario_id;
        this.celular = celular;
    }

    @Override
    protected abstract void onError(String code);

    @Override
    protected abstract void onSuccess(String s);

    @Override
    protected int getTipoJSON() {
        return JSON_OBJECT;
    }

    @Override
    protected String runService() {
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject.put("celular",celular);
        }catch (Exception e){}
        return Api.post(configuracion.getBaseUrl() +"registrar-celular/"+ usuario_id, jsonObject);
    }
}
