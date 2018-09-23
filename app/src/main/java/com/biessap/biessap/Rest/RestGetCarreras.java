package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

public abstract class RestGetCarreras extends CoreApiRest{
    int institucion_id;

    public RestGetCarreras(int institucion_id) {
        this.institucion_id = institucion_id;
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
        return Api.get(configuracion.getBaseUrl() + "get-carreras/"+institucion_id);
    }
}
