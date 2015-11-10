package com.salesianostriana.proyectoconjunto.weatherdam.model;

/**
 * Created by das on 10/11/2015.
 */
public class ItemCityWeather {
    //Atributos
    private String id;
    private String dt;
    private Clouds clouds;
    private Coord coord;
    private Wind wind;
    private String cod;
    private Sys sys;
    private String name;
    private String base;
    private Weather[] weather;
    private Main main;

    //Constructor
    public ItemCityWeather(String id, String dt, Clouds clouds, Coord coord, Wind wind,
                           String cod, Sys sys, String name,
                           String base, Weather[] weather, Main main) {
        this.id = id;
        this.dt = dt;
        this.clouds = clouds;
        this.coord = coord;
        this.wind = wind;
        this.cod = cod;
        this.sys = sys;
        this.name = name;
        this.base = base;
        this.weather = weather;
        this.main = main;
    }

    //Getters y setters
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getDt ()
    {
        return dt;
    }

    public void setDt (String dt)
    {
        this.dt = dt;
    }

    public Clouds getClouds ()
    {
        return clouds;
    }

    public void setClouds (Clouds clouds)
    {
        this.clouds = clouds;
    }

    public Coord getCoord ()
    {
        return coord;
    }

    public void setCoord (Coord coord)
    {
        this.coord = coord;
    }

    public Wind getWind ()
    {
        return wind;
    }

    public void setWind (Wind wind)
    {
        this.wind = wind;
    }

    public String getCod ()
    {
        return cod;
    }

    public void setCod (String cod)
    {
        this.cod = cod;
    }

    public Sys getSys ()
    {
        return sys;
    }

    public void setSys (Sys sys)
    {
        this.sys = sys;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getBase ()
    {
        return base;
    }

    public void setBase (String base)
    {
        this.base = base;
    }

    public Weather[] getWeather ()
    {
        return weather;
    }

    public void setWeather (Weather[] weather)
    {
        this.weather = weather;
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
        return "ClassPojo [id = "+id+", dt = "+dt+", clouds = "+clouds+", coord = "+coord+", wind = "+wind+", cod = "+cod+", sys = "+sys+", name = "+name+", base = "+base+", weather = "+weather+", main = "+main+"]";
    }
}
