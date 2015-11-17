package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;

/**
 * Created by Diego on 15/11/2015.
 */
public class ItemCityWeather5DaysHoursCompact {
    private String hour,icon,humidity,wind,temp;

    public ItemCityWeather5DaysHoursCompact(String hour, String icon, String humidity, String wind, String temp) {
        this.hour = hour;
        this.icon = icon;
        this.humidity = humidity;
        this.wind = wind;
        this.temp = temp;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
