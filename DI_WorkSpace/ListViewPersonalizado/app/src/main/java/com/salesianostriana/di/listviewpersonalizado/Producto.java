package com.salesianostriana.di.listviewpersonalizado;

/**
 * Created by Diego on 25/10/2015.
 */
public class Producto {
    private String nombre;
    private boolean agregado;

    public Producto(String nombre, boolean agregado){
        this.nombre = nombre;
        this.agregado = agregado;
    }

    public boolean isAgregado() {
        return agregado;
    }

    public void setAgregado(boolean agregado) {
        this.agregado = agregado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
