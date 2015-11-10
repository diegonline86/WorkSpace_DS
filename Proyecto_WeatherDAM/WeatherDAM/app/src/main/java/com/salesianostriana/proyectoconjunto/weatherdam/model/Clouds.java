package com.salesianostriana.proyectoconjunto.weatherdam.model;

/**
 * Created by das on 10/11/2015.
 */
public class Clouds
{
    private String all;

    public String getAll ()
    {
        return all;
    }

    public void setAll (String all)
    {
        this.all = all;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [all = "+all+"]";
    }
}