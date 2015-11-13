package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;

/**
 * Created by das on 12/11/2015.
 */
public class List
{
    private Clouds clouds;

    private String dt;

    private Wind wind;

    private Sys sys;

    private Snow snow;

    private Weather[] weather;

    private String dt_txt;

    private Rain rain;

    private Main main;

    public Clouds getClouds ()
    {
        return clouds;
    }

    public void setClouds (Clouds clouds)
    {
        this.clouds = clouds;
    }

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public Sys getSys ()
    {
        return sys;
    }

    public void setSys (Sys sys)
    {
        this.sys = sys;
    }

    public Snow getSnow ()
    {
        return snow;
    }

    public void setSnow (Snow snow)
    {
        this.snow = snow;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
    }

    public String getDt_txt ()
    {
        return dt_txt;
    }

    public void setDt_txt (String dt_txt)
    {
        this.dt_txt = dt_txt;
    }

    public Rain getRain ()
    {
        return rain;
    }

    public void setRain (Rain rain)
    {
        this.rain = rain;
    }

    public Main getMain ()
    {
        return main;
    }

    public void setMain (Main main)
    {
        this.main = main;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [clouds = "+clouds+", dt = "+dt+", wind = "+wind+", sys = "+sys+", snow = "+snow+", weather = "+weather+", dt_txt = "+dt_txt+", rain = "+rain+", main = "+main+"]";
    }
}
