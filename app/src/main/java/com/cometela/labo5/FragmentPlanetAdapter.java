package com.cometela.labo5;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FragmentPlanetAdapter extends RecyclerView.Adapter<FragmentPlanetAdapter.FragmentPlanetViewHolder> {

    private Context myContext;
    private List<Planeta> planetaList;


    @Override
    public FragmentPlanetAdapter.FragmentPlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View v =  inflater.inflate(R.layout.ejercicio,null);

        return new FragmentPlanetAdapter.FragmentPlanetViewHolder(v);
    }

    public FragmentPlanetAdapter(Context myContext, List<Planeta> planetaList) {
        this.myContext = myContext;
        this.planetaList = planetaList;

    }

    @Override
    public void onBindViewHolder(final FragmentPlanetAdapter.FragmentPlanetViewHolder holder, final int position) {
        holder.title.setText(planetaList.get(position).getTitulo());
        holder.descripcion.setText(planetaList.get(position).getDescripcion());
        holder.imagen.setImageResource(planetaList.get(position).getImagen());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                planetaList.remove(position);
                notifyItemRemoved(position);
                notifyItemChanged(position,planetaList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return planetaList.size();
    }

    protected class FragmentPlanetViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView title,descripcion;
        ImageButton button;


        public FragmentPlanetViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.Titulo);
            descripcion = itemView.findViewById(R.id.Descripcion);
            imagen = itemView.findViewById(R.id.Imagen);
            button = itemView.findViewById(R.id.FavoritosButton);

        }
    }


}
