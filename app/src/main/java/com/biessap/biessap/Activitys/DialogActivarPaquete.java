package com.biessap.biessap.Activitys;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.biessap.biessap.R;
import me.shaohui.bottomdialog.BaseBottomDialog;

public class DialogActivarPaquete extends BaseBottomDialog {
    @Override
    public int getLayoutRes() {
        return R.layout.dialog_activar_paquete;
    }

    @Override
    public void bindView(View v) {

        Button btn_activar = v.findViewById(R.id.btn_activar);
        btn_activar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Toast.makeText(getActivity(),"Activado",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
