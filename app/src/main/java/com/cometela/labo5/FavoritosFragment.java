package com.cometela.labo5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class FavoritosFragment extends Fragment {

    private TextView titulo, descripcion;
    private ImageView Imagen;
    private ImageButton button;
    private Planeta [] planetas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        titulo = container.findViewById(R.id.Titulo);
        descripcion = container.findViewById(R.id.Descripcion);
        Imagen = container.findViewById(R.id.Imagen);
        button = container.findViewById(R.id.FavoritosButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Bundle args = this.getArguments();

        if (args != null) {
            Planeta planeta = args.getParcelable("Planeta");
            titulo.setText(planeta.titulo);
            descripcion.setText(planeta.descripcion);
            Imagen.setImageResource(planeta.Imagen);
        }


        return inflater.inflate(R.layout.fragment_favoritos, container, false);

    }

}
