package com.biessap.biessap.Rest;
import com.biessap.biessap.CoreApplication.CoreApiRest;
import com.biessap.biessap.system.Api;

public abstract class RestGetCarrerasA extends CoreApiRest {

    int id_area;

    public RestGetCarrerasA(int id_area) {
        this.id_area = id_area;
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
        return Api.get(configuracion.getBaseUrl() + "get-carrerasA/" + id_area);
    }
}
