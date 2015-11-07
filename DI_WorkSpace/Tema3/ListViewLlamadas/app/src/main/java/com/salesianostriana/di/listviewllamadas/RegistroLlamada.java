package com.salesianostriana.di.listviewllamadas;

import java.util.Calendar;

/**
 * Created by Diego on 27/10/2015.
 */
public class RegistroLlamada {
    private String numTelefono;
    private Calendar fechaHora;
    private long duracion;
    private int estado;

    public RegistroLlamada( String numTelefono,Calendar fechaHora, long duracion, int estado) {
        this.numTelefono = numTelefono;
        this.fechaHora = fechaHora;
        this.duracion = duracion;
        this.estado = estado;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
