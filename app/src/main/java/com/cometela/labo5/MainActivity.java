package com.cometela.labo5;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

        adapter = new PlanetAdapter(this, planetaList);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Planeta> fillLista (){
        ArrayList<Planeta> l = new ArrayList<>();
        String [] desc = getResources().getStringArray(R.array.Parrafos);
        String [] titulos = getResources().getStringArray(R.array.Planets);
        TypedArray imagenes = getResources().obtainTypedArray(R.array.ImagenesPlanetas);

        Planeta planet;
        for(int i = 0;i<desc.length;i++){
            planet = new Planeta(titulos[i],desc[i],imagenes.getResourceId(i,-1), false);
            l.add(planet);
        }
        imagenes.recycle();
        return l;

    }

    public void cambiarAFavs(View v){
        recyclerView.setAdapter(new PlanetAdapter(v.getContext(), fillList(planetaList)));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private ArrayList<Planeta> fillList(List<Planeta> l){
        ArrayList<Planeta> aux = new ArrayList<>();
        for (Planeta p: l) {
            if (p.isFav())
                aux.add(p);
        }
        return aux;
    }
}
