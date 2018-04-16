package com.cometela.labo5;

/**
 * Created by uca on 04-16-18.
 */

public class Planeta {
    String titulo,descripcion;
    int Imagen;

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

}
