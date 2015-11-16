package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;

/**
 * Created by Diego on 12/11/2015.
 */
public class ItemCityWeather5DaysCompact {
    String day, maxTemp, minTemp, icon;

    public ItemCityWeather5DaysCompact(String day, String maxTemp, String minTemp, String icon) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.icon = icon;
    }

    public String getDay() {
        return day;
    }

    public String getMaxTemp() {
        return maxTemp;
    }


    public String getMinTemp() {
        return minTemp;
    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
