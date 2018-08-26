package com.biessap.biessap.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.biessap.biessap.R;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class CarreraAdapter extends RecyclerView.Adapter<CarreraAdapter.CarreraViewHolder> implements Filterable {

    ArrayList<String> lista;
    ArrayList<String>  listaFilter;

    public CarreraAdapter(ArrayList<String> lista) {
        this.lista = lista;
        listaFilter = new ArrayList<>();
        listaFilter.addAll(lista);
    }

    @NonNull
    @Override
    public CarreraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrera,parent,false);
        CarreraViewHolder CarreraViewHolder = new CarreraViewHolder(view);
        return CarreraViewHolder;
    }

    public String getItem(int i){
        return listaFilter.get(i);
    }

    @Override
    public void onBindViewHolder(@NonNull CarreraViewHolder holder, int position) {
        String Carrera = listaFilter.get(position);
        holder.titulo.setText(Carrera);
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
                        if(lista.get(i).toLowerCase().contains(texto.toLowerCase())){
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
    public class CarreraViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        LinearLayout container;
        public CarreraViewHolder(View itemView) {
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
