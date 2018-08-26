package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

import org.json.JSONObject;

public abstract class RestLoginGoogle extends CoreApiRest {

    String email;
    int google_id;

    public RestLoginGoogle(String email, int google_id) {
        this.email = email;
        this.google_id = google_id;
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
            jsonObject.put("email",email);
            jsonObject.put("google_id",google_id);
        }catch (Exception e){}
        return Api.post(configuracion.getBaseUrl() + "login-google",jsonObject);
    }
}
