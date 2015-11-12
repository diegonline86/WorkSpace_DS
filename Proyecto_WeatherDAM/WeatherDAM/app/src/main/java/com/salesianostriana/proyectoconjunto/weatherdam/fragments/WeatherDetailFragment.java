package com.salesianostriana.proyectoconjunto.weatherdam.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather.ItemCityWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class WeatherDetailFragment extends Fragment{
    ImageView imageViewIconWeather;
    TextView textViewLocation,textViewTemp, textViewTempMax,
            textViewTempMin,textViewWind, textViewHumidity, textViewPressure ;
    String id;

    public WeatherDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Obtenemos el id del intent y el extra del activity contenedor
        Bundle extra = getActivity().getIntent().getExtras();
        id = extra.getString("weatherID");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Aqui recuperamos los elementos del fragment
        View v = inflater.inflate(R.layout.fragment_weather_detail, container, false);

        textViewLocation = (TextView)v.findViewById(R.id.textViewLocation);
        textViewHumidity = (TextView)v.findViewById(R.id.textViewHumidity);
        textViewTemp = (TextView)v.findViewById(R.id.textViewTemp);
        textViewTempMax = (TextView)v.findViewById(R.id.textViewTempMax);
        textViewTempMin = (TextView)v.findViewById(R.id.textViewTempMin);
        textViewWind = (TextView)v.findViewById(R.id.textViewWind);
        textViewPressure = (TextView)v.findViewById(R.id.textViewPressure);
        imageViewIconWeather = (ImageView)v.findViewById(R.id.imageViewIconWeather);

        new GetItemCityWeather().execute();

        return v;
    }


    private class GetItemCityWeather extends AsyncTask<Void,Void,ItemCityWeather> {

        @Override
        protected ItemCityWeather doInBackground(Void... params) {
            URL url = null;
            BufferedReader br = null;
            ItemCityWeather result = null;


            try {
                //encajamos la variable en el parametro de ciudades
                url = new URL("http://api.openweathermap.org/data/2.5/weather?id="+id+"&units=metric&appid=616440c75d43cf432ff5518ff8b6ee33");
                br = new BufferedReader(new InputStreamReader(url.openStream()));

                Gson gson = new Gson();

                result = gson.fromJson(br, ItemCityWeather.class);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(ItemCityWeather itemCityWeather) {
            super.onPostExecute(itemCityWeather);
            ItemCityWeather weather = itemCityWeather;

            textViewTemp.setText(weather.getMain().getTemp()+"º");
            textViewLocation.setText(weather.getName());
            textViewTempMax.setText(weather.getMain().getTemp_max()+"º");
            textViewTempMin.setText(weather.getMain().getTemp_min()+"º");
            textViewWind.setText(weather.getWind().getSpeed()+"KMH");
            textViewHumidity.setText(weather.getMain().getHumidity()+"%");
            textViewPressure.setText(weather.getMain().getPressure()+"MB");
        }
    }
}