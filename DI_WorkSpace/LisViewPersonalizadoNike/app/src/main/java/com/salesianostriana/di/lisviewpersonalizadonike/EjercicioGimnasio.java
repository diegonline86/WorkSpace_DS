package com.salesianostriana.di.lisviewpersonalizadonike;

/**
 * Created by Diego on 26/10/2015.
 */
public class EjercicioGimnasio {
    private String exersice;
    private int duration;

    public EjercicioGimnasio(String exersice, int duration) {
        this.exersice = exersice;
        this.duration = duration;
    }

    public String getExersice() {
        return exersice;
    }

    public void setExersice(String exersice) {
        this.exersice = exersice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
