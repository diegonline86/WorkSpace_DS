
package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Weather {

    @SerializedName("city")
    @Expose
    private long id;
    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("icon")
    @Expose
    private String icon;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weather() {
    }

    /**
     * 
     * @param id
     * @param icon
     * @param description
     * @param main
     */
    public Weather(long id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    /**
     * 
     * @return
     *     The city
     */
    public long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The city
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The main
     */
    public String getMain() {
        return main;
    }

    /**
     * 
     * @param main
     *     The main
     */
    public void setMain(String main) {
        this.main = main;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon
     *     The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }



}
