package com.cometela.labo5;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by uca on 04-16-18.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    Context myContext;
    List<Planeta> planetaList;

    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View v =  inflater.inflate(R.layout.ejercicio,null);

        return new PlanetViewHolder(v);
    }

    public PlanetAdapter(Context myContext, List<Planeta> planetaList) {
        this.myContext = myContext;
        this.planetaList = planetaList;
    }

    @Override
    public void onBindViewHolder(PlanetViewHolder holder, int position) {
        holder.title.setText(planetaList.get(position).getTitulo());
        holder.descripcion.setText(planetaList.get(position).getDescripcion());
        holder.imagen.setImageResource(planetaList.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return planetaList.size();
    }

    protected class PlanetViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView title,descripcion;


        public PlanetViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.Titulo);
            descripcion = itemView.findViewById(R.id.Descripcion);
            imagen = itemView.findViewById(R.id.Imagen);

        }
    }
}
