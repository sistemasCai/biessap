package com.biessap.biessap.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.biessap.biessap.R;
import com.biessap.biessap.models.Area;

import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.AreaViewHolder> implements Filterable {

    ArrayList<Area> lista;
    ArrayList<Area>  listaFilter;

    public AreaAdapter(ArrayList<Area> lista) {
        this.lista = lista;
        listaFilter = new ArrayList<>();
        listaFilter.addAll(lista);
    }

    @NonNull
    @Override
    public AreaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_area,parent,false);
        AreaViewHolder areaViewHolder = new AreaViewHolder(view);
        return areaViewHolder;
    }

    public Area getItem(int i){
        return listaFilter.get(i);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaViewHolder holder, int position) {
        Area area = listaFilter.get(position);
        holder.titulo.setText(area.getNombre());
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String texto = constraint.toString();
                listaFilter.clear();
                if(texto.isEmpty()){
                    listaFilter.addAll(lista);
                }else{
                    for (int i = 0; i < lista.size(); i++) {
                        if(lista.get(i).getNombre().toLowerCase().contains(texto.toLowerCase())){
                            listaFilter.add(lista.get(i));
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = listaFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return listaFilter.size();
    }

    public abstract void OnItemClick(int pos);
    public class AreaViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        LinearLayout container;
        public AreaViewHolder(View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.container);
            titulo = itemView.findViewById(R.id.text_carrera);
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
