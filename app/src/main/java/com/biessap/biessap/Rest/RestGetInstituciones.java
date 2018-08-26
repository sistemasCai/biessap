package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

public abstract class RestGetInstituciones extends CoreApiRest {

    String clase;

    public RestGetInstituciones(String clase) {
        this.clase = clase;
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
        return Api.get(configuracion.getBaseUrl() + "get-instituciones/" + clase);
    }
}
