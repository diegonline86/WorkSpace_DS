package com.salesianostriana.pmdm.reproductormusica;

/**
 * Created by Diego on 02/11/2015.
 */
public class ItemCancion {
    //Atributos
    private String grupo, titulo;
    private long duracion;

    //Constructor
    public ItemCancion(String grupo, String titulo, long duracion) {
        this.grupo = grupo;
        this.titulo = titulo;
        this.duracion = duracion;
    }

    //Getters y setters
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
