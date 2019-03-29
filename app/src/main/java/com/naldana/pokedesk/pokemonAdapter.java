package com.naldana.pokedesk;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class pokemonAdapter extends RecyclerView.Adapter<pokemonAdapter.ViewHolderDatos> {
    ArrayList<String> listDatos;

    public pokemonAdapter(ArrayList<String> listDatos) {
        this.listDatos=listDatos;
    }

    @NonNull
    @Override
    public pokemonAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup viewGroups, int i) {
        View view  = LayoutInflater.from(viewGroups.getContext()).inflate(R.layout.item_list_pokemon,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pokemonAdapter.ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.asignarDatos(listDatos.get(i));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre_pokex;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombre_pokex= itemView.findViewById(R.id.nombre_poke);
        }

        public void asignarDatos(String s) {
            nombre_pokex.setText(s);
        }
    }
}
