package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

public abstract class RestIniciarPsa extends CoreApiRest {

    int area_id;

    public RestIniciarPsa(int area_id) {
        this.area_id = area_id;
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
        return Api.get(configuracion.getBaseUrl() + "iniciar-psa/"+area_id);
    }
}
