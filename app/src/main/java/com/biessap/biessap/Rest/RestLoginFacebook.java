package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

import org.json.JSONObject;

public abstract class RestLoginFacebook extends CoreApiRest {

    String email;
    String name;
    int facebook_id;

    public RestLoginFacebook(String email, String name,int facebook_id) {
        this.email = email;
        this.facebook_id = facebook_id;
        this.name = name;
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
            jsonObject.put("name",name);
            jsonObject.put("facebook_id",facebook_id);
        }catch (Exception e){}
        return Api.post(configuracion.getBaseUrl() + "login-facebook",jsonObject);
    }
}
