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

import java.util.ArrayList;

public class TecnicoSuperiorFragment extends CoreFragment {

    RecyclerView recyclerView;
    AreaAdapter adapter;
    @Override
    public int getLayout() {
        return R.layout.fragment_tecnico_superior;
    }

    @Override
    public void iniciarFragmentoView(View v) {
        ArrayList<String> data = new ArrayList<>();
        data.add("CS. JURIDICAS POLITICAS Y SOCIALES");
        data.add("CS. ECONOMICAS, ADMINISTRATIVAS Y FINACIERAS");
        data.add("CS. DEL HABITAT");
        data.add("CS. FARMACEUTICAS Y BIOQUIMICAS");
        data.add("CS. JURIDICAS POLITICAS Y SOCIALES");
        data.add("CS. ECONOMICAS, ADMINISTRATIVAS Y FINACIERAS");
        data.add("CS. DEL HABITAT");
        data.add("CS. FARMACEUTICAS Y BIOQUIMICAS");
        adapter = new AreaAdapter(data) {
            @Override
            public void OnItemClick(int pos) {
                Intent i = new Intent(getActivity(), ListaCarreraActivity.class);
                startActivity(i);
            }
        };
        recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
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

    @Override
    public void iniciarFragmento() {

    }
}
