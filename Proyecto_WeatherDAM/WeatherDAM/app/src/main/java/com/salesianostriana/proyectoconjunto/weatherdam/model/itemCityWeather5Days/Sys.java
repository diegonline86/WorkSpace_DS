package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;

/**
 * Created by das on 12/11/2015.
 */
public class Sys{
    private String pod;

    public String getPod ()
    {
        return pod;
    }

    public void setPod (String pod)
    {
        this.pod = pod;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pod = "+pod+"]";
    }
}
