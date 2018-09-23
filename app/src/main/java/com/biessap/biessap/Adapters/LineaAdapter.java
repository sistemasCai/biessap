package com.biessap.biessap.Adapters;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.biessap.biessap.R;
import com.biessap.biessap.models.Linea;

import java.util.ArrayList;

public abstract class LineaAdapter extends RecyclerView.Adapter<LineaAdapter.LineaViewHolder>{

    ArrayList<Linea> lista;

    public LineaAdapter(ArrayList<Linea> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public LineaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linea,parent,false);
        LineaViewHolder holder = new LineaViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LineaViewHolder holder, int position) {
        Linea linea = lista.get(position);
        holder.texto.setText(linea.getNombre());
        try{
            holder.color_linea.setBackgroundColor(Color.parseColor(linea.getColor()));
        }catch (Exception e){}
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public Linea getItem(int pos){
        return lista.get(pos);
    }

    public abstract void itemClick(int pos);
    class LineaViewHolder extends RecyclerView.ViewHolder{

        TextView texto;
        LinearLayout item;
        View color_linea;
        public LineaViewHolder(View itemView) {
            super(itemView);
            texto = itemView.findViewById(R.id.text);
            item = itemView.findViewById(R.id.container);
            color_linea = itemView.findViewById(R.id.color);
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClick(getAdapterPosition());
                }
            });
        }
    }
}
