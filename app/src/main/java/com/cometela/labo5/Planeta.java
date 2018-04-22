package com.cometela.labo5;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by uca on 04-16-18.
 */

public class Planeta implements Parcelable{
    String titulo,descripcion;
    int Imagen;
    int id;

    public Planeta(String titulo,String descripcion,int Imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.Imagen = Imagen;
    }

    public Planeta(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Planeta(Parcel in){
        String[] data= new String[3];

        in.readStringArray(data);
        this.titulo= data[0];
        this.descripcion= data[1];
        this.Imagen= Integer.parseInt(data[2]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.titulo,this.descripcion,String.valueOf(this.Imagen)});

    }
    public static final Parcelable.Creator<Planeta> CREATOR= new Parcelable.Creator<Planeta>() {

        @Override
        public Planeta createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Planeta(source);  //using parcelable constructor
        }

        @Override
        public Planeta[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Planeta[size];
        }
    };
}
