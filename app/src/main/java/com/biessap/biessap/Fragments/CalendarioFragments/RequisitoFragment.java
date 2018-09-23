package com.biessap.biessap.Fragments.CalendarioFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biessap.biessap.CoreApplication.CoreFragment;
import com.biessap.biessap.R;
import com.biessap.biessap.models.Universidad;

public class RequisitoFragment extends CoreFragment {

    @Override
    public int getLayout() {
        return R.layout.fragment_requisito;
    }

    @Override
    public void iniciarFragmentoView(View v) {
        Bundle bundle = getArguments();
        Universidad uni = (Universidad) bundle.getSerializable("universidad");
        TextView textView = v.findViewById(R.id.texto);
       try{

           textView.setText(Html.fromHtml(uni.getRequisitos()));
       }catch (Exception e){
            textView.setText("Aun no Disponible");
       }
    }

    @Override
    public void iniciarFragmento() {

    }
}
