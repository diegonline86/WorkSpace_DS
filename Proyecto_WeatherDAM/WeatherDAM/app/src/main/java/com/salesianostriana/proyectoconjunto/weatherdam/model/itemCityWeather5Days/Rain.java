package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;

/**
 * Created by Diego on 12/11/2015.
 */
public class Rain {
    private String _3h;

    public String get3h ()
    {
        return _3h;
    }

    public void set3h (String _3h)
    {
        this._3h = _3h;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [3h = "+_3h+"]";
    }
}
