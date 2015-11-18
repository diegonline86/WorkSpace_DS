package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;
import java.util.List;

/**
 * Created by Diego on 15/11/2015.
 */
public class ItemCityWeather5DaysHours {
    private String day;
    private List<ItemCityWeather5DaysHoursCompact> listHourWeather;

    public ItemCityWeather5DaysHours(String day, List hours) {
        this.day = day;
        this.listHourWeather = hours;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<ItemCityWeather5DaysHoursCompact> getListHourWeather() {
        return listHourWeather;
    }

    public void setListHourWeather(List<ItemCityWeather5DaysHoursCompact> listHourWeather) {
        this.listHourWeather = listHourWeather;
    }
}
