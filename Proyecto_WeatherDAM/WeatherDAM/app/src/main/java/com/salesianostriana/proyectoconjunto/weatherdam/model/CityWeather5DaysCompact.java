package com.salesianostriana.proyectoconjunto.weatherdam.model;

/**
 * Created by Diego on 12/11/2015.
 */
public class CityWeather5DaysCompact {
    String day, maxTemp, minTemp,humity, state;

    public CityWeather5DaysCompact(String day, String maxTemp, String minTemp, String humity, String state) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humity = humity;
        this.state = state;
    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getHumity() {
        return humity;
    }

    public void setHumity(String humity) {
        this.humity = humity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
