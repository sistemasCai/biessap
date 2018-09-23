package com.biessap.biessap.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.biessap.biessap.R;
import com.biessap.biessap.models.Ciudad;

import java.util.ArrayList;

public abstract class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.CiudadViewHolder> {

    ArrayList<Ciudad> lista;

    public CiudadAdapter(ArrayList<Ciudad> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public CiudadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ciudad,parent,false);
        CiudadViewHolder CiudadViewHolder = new CiudadViewHolder(view);
        return CiudadViewHolder;
    }

    public Ciudad getItem(int i){
        return lista.get(i);
    }

    @Override
    public void onBindViewHolder(@NonNull CiudadViewHolder holder, int position) {
        Ciudad Ciudad = lista.get(position);
        holder.titulo.setText(Ciudad.getNombre());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public abstract void OnItemClick(int pos);
    public class CiudadViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        RelativeLayout container;
        public CiudadViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
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
