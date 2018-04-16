package com.cometela.labo5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Planeta> planetaList;
    RecyclerView recyclerView;
    PlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planetaList = fillLista();

        //setting recycler view
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new PlanetAdapter(this,planetaList);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Planeta> fillLista (){
        ArrayList<Planeta> l = new ArrayList<>();
        String desc = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. " +
                "Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un " +
                "impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal " +
                "manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto " +
                "de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la " +
                "creación de las hojas \"Letraset\"";

        l.add(new Planeta("Ella",desc));
        l.add(new Planeta("El retorno de Ella",desc));
        l.add(new Planeta("Ella contraraca",desc));

        return l;
    }
}
