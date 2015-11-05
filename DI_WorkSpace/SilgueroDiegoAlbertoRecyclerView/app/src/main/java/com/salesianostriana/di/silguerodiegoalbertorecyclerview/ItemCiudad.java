package com.salesianostriana.di.silguerodiegoalbertorecyclerview;

/**
 * Created by Diego on 04/11/2015.
 */
public class ItemCiudad {

    private int imagen;
    private String nombre;

    public ItemCiudad(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
