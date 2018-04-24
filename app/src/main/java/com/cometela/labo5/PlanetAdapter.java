package com.cometela.labo5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by uca on 04-16-18.
 */

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {


    private Context myContext;
    private List<Planeta> planetaList;
    private boolean InFav = false;


    @Override
    public PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        if(!InFav){
            View v =  inflater.inflate(R.layout.ejercicio,null);
            return new PlanetViewHolder(v);
        }
        else {
            View v = inflater.inflate(R.layout.favoritoslayout, null);
            return new PlanetViewHolder(v);
        }
    }

    PlanetAdapter(Context myContext, List<Planeta> planetaList) {
        this.myContext = myContext;
        this.planetaList = planetaList;

    }

    @Override
    public void onBindViewHolder(final PlanetViewHolder holder, final int position) {
        holder.title.setText(planetaList.get(position).getTitulo());
        holder.descripcion.setText(planetaList.get(position).getDescripcion());
        holder.imagen.setImageResource(planetaList.get(position).getImagen());
        try {
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Planeta planet = planetaList.get(position);
                    planet.setFav(!planet.isFav());
                    holder.button.setImageResource(android.R.drawable.btn_star_big_on);
                }
            });
        }catch (NullPointerException ignored){
           //Log.d("Exception",ignored.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return planetaList.size();
    }

    class PlanetViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView title,descripcion;
        ImageButton button;

        PlanetViewHolder(View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.Titulo);
            descripcion = itemView.findViewById(R.id.Descripcion);
            imagen = itemView.findViewById(R.id.Imagen);
            button = itemView.findViewById(R.id.FavoritosButton);

        }
    }

    public boolean isInFav(){
        return InFav;
    }
    public void setInFav(boolean inFav){
        InFav = inFav;
    }

}
