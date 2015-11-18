
package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Clouds {

    @SerializedName("all")
    @Expose
    private long all;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Clouds() {
    }

    /**
     * 
     * @param all
     */
    public Clouds(long all) {
        this.all = all;
    }

    /**
     * 
     * @return
     *     The all
     */
    public long getAll() {
        return all;
    }

    /**
     * 
     * @param all
     *     The all
     */
    public void setAll(long all) {
        this.all = all;
    }


}
