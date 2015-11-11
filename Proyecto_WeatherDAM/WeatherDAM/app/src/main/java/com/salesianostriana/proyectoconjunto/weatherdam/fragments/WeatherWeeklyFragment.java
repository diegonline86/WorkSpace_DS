package com.salesianostriana.proyectoconjunto.weatherdam.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.proyectoconjunto.weatherdam.R;


public class WeatherWeeklyFragment extends Fragment {

    public WeatherWeeklyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Aqui recuperamos los elementos del fragment
        View v = inflater.inflate(R.layout.fragment_weather_weekly, container, false);

        return v;
    }
}
