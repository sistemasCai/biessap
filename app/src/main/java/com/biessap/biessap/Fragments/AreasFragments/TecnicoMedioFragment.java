package com.biessap.biessap.Fragments.AreasFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.biessap.biessap.Activitys.OrientacionUniversitaria.ListaCarreraActivity;
import com.biessap.biessap.Adapters.AreaAdapter;
import com.biessap.biessap.CoreApplication.CoreFragment;
import com.biessap.biessap.R;
import com.biessap.biessap.Rest.RestGetAreas;
import com.biessap.biessap.models.Area;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TecnicoMedioFragment extends CoreFragment {

    RecyclerView recyclerView;
    AreaAdapter adapter;
    @Override
    public int getLayout() {
        return R.layout.fragment_tecnico_medio;
    }

    @Override
    public void iniciarFragmentoView(View v) {
        obtenerAreas(v);

        EditText edit_buscar = v.findViewById(R.id.buscar);
        edit_buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void obtenerAreas(final View v){
        String nivel = "tecnico_medio";
        new RestGetAreas(nivel) {
            @Override
            protected void onError(String code) {
                Toast.makeText(getActivity(),code,Toast.LENGTH_SHORT).show();
            }

            @Override
            protected void onSuccess(String s) {
                ArrayList<Area> data = new ArrayList<>();
                try{
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray datos = jsonObject.getJSONArray("datos");
                    for (int i = 0; i < datos.length(); i++) {
                        data.add(Area.parser(datos.getJSONObject(i)));
                    }
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }

                adapter = new AreaAdapter(data) {
                    @Override
                    public void OnItemClick(int pos) {

                        String nombre = adapter.getItem(pos).getNombre();
                        int id = adapter.getItem(pos).getId();
                        Intent i = new Intent(getActivity(), ListaCarreraActivity.class);
                        i.putExtra("id",id);
                        i.putExtra("nombre",nombre);
                        startActivity(i);

                    }
                };
                recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);
            }
        }.runDialog(getActivity());
    }
    @Override
    public void iniciarFragmento() {

    }
}
