package com.example.proyectochasqui;

public class Anuncios {


    private String Nombre;
    private String categoria;
    private String zona;
    private String contenido;
    private int fotoafiliado;

    public Anuncios(String nombre, String categoria, String zona, String contenido, int fotoafiliado) {
        Nombre = nombre;
        this.categoria = categoria;
        this.zona = zona;
        this.contenido = contenido;
        this.fotoafiliado = fotoafiliado;

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getFotoafiliado() {
        return fotoafiliado;
    }

    public void setFotoafiliado(int fotoafiliado) {
        this.fotoafiliado = fotoafiliado;
    }
}
