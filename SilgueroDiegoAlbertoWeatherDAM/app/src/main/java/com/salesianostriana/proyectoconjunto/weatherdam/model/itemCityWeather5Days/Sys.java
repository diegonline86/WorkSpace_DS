
package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Sys {

    @SerializedName("population")
    @Expose
    private long population;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sys() {
    }

    /**
     * 
     * @param population
     */
    public Sys(long population) {
        this.population = population;
    }

    /**
     * 
     * @return
     *     The population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * 
     * @param population
     *     The population
     */
    public void setPopulation(long population) {
        this.population = population;
    }



}
