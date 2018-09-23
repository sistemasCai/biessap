package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

public abstract class RestGetAreasPsa extends CoreApiRest {
    int gestion_id;

    public RestGetAreasPsa(int gestion_id) {
        this.gestion_id = gestion_id;
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
        return Api.get(configuracion.getBaseUrl() + "get-psa-areas/"+gestion_id);
    }
}
