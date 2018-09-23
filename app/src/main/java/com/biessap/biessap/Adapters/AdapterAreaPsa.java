package com.biessap.biessap.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.biessap.biessap.R;
import com.biessap.biessap.models.Area;
import com.biessap.biessap.models.AreaPsa;

import java.util.ArrayList;

public abstract class AdapterAreaPsa extends RecyclerView.Adapter<AdapterAreaPsa.AreaPsaViewHolder>{

    ArrayList<AreaPsa> lista;

    public AdapterAreaPsa(ArrayList<AreaPsa> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public AreaPsaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_area_psa,parent,false);
        AdapterAreaPsa.AreaPsaViewHolder areaViewHolder = new AreaPsaViewHolder(view);
        return areaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AreaPsaViewHolder holder, int position) {
        AreaPsa areaPsa = lista.get(position);
        holder.textView.setText(areaPsa.getNombre());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public AreaPsa getItem(int pos){
        return lista.get(pos);
    }
    public abstract void OnItemClick(int pos);
    class AreaPsaViewHolder extends RecyclerView.ViewHolder{

        LinearLayout layout;
        TextView textView;
        public AreaPsaViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.container);
            textView = itemView.findViewById(R.id.text);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
