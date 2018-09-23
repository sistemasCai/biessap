package com.biessap.biessap.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biessap.biessap.R;
import com.biessap.biessap.models.Pais;

import java.util.ArrayList;

public abstract class PaisAdapter extends RecyclerView.Adapter<PaisAdapter.PaisViewHolder> {

    ArrayList<Pais> lista;

    public PaisAdapter(ArrayList<Pais> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public PaisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pais,parent,false);
        PaisViewHolder PaisViewHolder = new PaisViewHolder(view);
        return PaisViewHolder;
    }

    public Pais getItem(int i){
        return lista.get(i);
    }

    @Override
    public void onBindViewHolder(@NonNull PaisViewHolder holder, int position) {
        Pais pais = lista.get(position);
        holder.titulo.setText(pais.getNombre());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public abstract void OnItemClick(int pos);
    public class PaisViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        RelativeLayout container;
        public PaisViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.relative_container);
            titulo = itemView.findViewById(R.id.titulo_carrera);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
