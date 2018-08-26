package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

public abstract class RestGetAreas extends CoreApiRest{

    String nivel;

    public RestGetAreas(String nivel) {
        this.nivel = nivel;
    }

    @Override
    protected abstract void onError(String code) ;

    @Override
    protected abstract void onSuccess(String s);

    @Override
    protected int getTipoJSON() {
        return JSON_OBJECT;
    }

    @Override
    protected String runService() {
        return Api.get(configuracion.getBaseUrl() + "get-areas/" + nivel);
    }
}
