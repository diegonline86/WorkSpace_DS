package com.salesianostriana.di.silguerodiegoalbertorecyclerview;

/**
 * Created by Diego on 04/11/2015.
 */
public class ItemCiudad {

    private int n_hanbitantes, rating;
    private String nombre;
    private boolean aeropuerto;

    public ItemCiudad(int n_habitantes, String nombre, int rating, boolean aeropuerto) {
        this.n_hanbitantes = n_habitantes;
        this.nombre = nombre;
        this.rating = rating;
        this.aeropuerto = aeropuerto;
    }

    public int getN_hanbitantes() {
        return n_hanbitantes;
    }

    public void setN_hanbitantes(int n_hanbitantes) {
        this.n_hanbitantes = n_hanbitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(boolean aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
}
