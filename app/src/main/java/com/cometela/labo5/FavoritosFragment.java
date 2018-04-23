package com.cometela.labo5;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class FavoritosFragment extends Fragment {

    private TextView titulo, descripcion;
    private ImageView Imagen;
    private ImageButton button;
    private List<Planeta> planetaList;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Bundle args = this.getArguments();

        if (args != null) {
            Planeta planeta = args.getParcelable("Planeta");
            titulo.setText(planeta.titulo);
            descripcion.setText(planeta.descripcion);
            Imagen.setImageResource(planeta.Imagen);

            if(!planetaList.contains(planeta)){
                planetaList.add(planeta);
            }
        }
        recyclerView = container.findViewById(R.id.FragmentrecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new FragmentPlanetAdapter(container.getContext(),planetaList));


        return inflater.inflate(R.layout.fragment_favoritos, container, false);

    }

}
