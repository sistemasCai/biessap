package com.biessap.biessap.Fragments.CalendarioFragments;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.biessap.biessap.CoreApplication.CoreFragment;
import com.biessap.biessap.R;
import com.biessap.biessap.models.Universidad;

public class InscripcionFragment extends CoreFragment {
    Universidad uni;
    @Override
    public int getLayout() {
        return R.layout.fragment_inscripcion;
    }

    @Override
    public void iniciarFragmentoView(View v) {
        TextView textView = v.findViewById(R.id.texto);
        try{
            textView.setText(Html.fromHtml(uni.getFecha_inscripcion()));
            textView.setText(Html.fromHtml(uni.getFecha_inico_clases()));
            textView.append(Html.fromHtml(uni.getBeneficios()));
        }catch (Exception e){
            textView.setText("Aun No Disponible");
        }
    }

    @Override
    public void iniciarFragmento() {
        Bundle bundle = getArguments();
         uni = (Universidad) bundle.getSerializable("universidad");
    }
}
