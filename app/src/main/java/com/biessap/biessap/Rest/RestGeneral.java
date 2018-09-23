package com.biessap.biessap.Rest;

import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

public abstract class RestGeneral extends CoreApiRest {
    String institucion;
    int ciudad_id;

    public RestGeneral(String institucion, int ciudad_id) {
        this.institucion = institucion;
        this.ciudad_id = ciudad_id;
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
        return Api.get(configuracion.getBaseUrl() + "get-general/"+ciudad_id+"/"+institucion);
    }
}
