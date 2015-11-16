package com.salesianostriana.proyectoconjunto.weatherdam.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.adapter.CityWeather5DaysHourAdapter;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5Days;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5DaysHours;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5DaysHoursCompact;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.Weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Weather5DaysHourFragment extends Fragment {
    RecyclerView recyclerView5DaysHours;
    String city;

    public Weather5DaysHourFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extra = getActivity().getIntent().getExtras();
        city = extra.getString("city");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weather5_days_hour, container, false);

        recyclerView5DaysHours = (RecyclerView)v.findViewById(R.id.rv5DaysHours);
        //recyclerView5DaysHours.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView5DaysHours.setLayoutManager(llm);

        new GetWheater5DaysHours().execute();

        return v;
    }

    private class GetWheater5DaysHours extends AsyncTask<Void,Void,ItemCityWeather5Days>{

        @Override
        protected ItemCityWeather5Days doInBackground(Void... params) {
            URL url = null;
            BufferedReader br = null;
            ItemCityWeather5Days result = null;


            try {
                //encajamos la variable en el parametro de ciudades
                url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="+city+"&units=metric&appid=616440c75d43cf432ff5518ff8b6ee33");
                br = new BufferedReader(new InputStreamReader(url.openStream()));

                Gson gson = new Gson();

                result = gson.fromJson(br, ItemCityWeather5Days.class);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(ItemCityWeather5Days itemCity5Days) {
            super.onPostExecute(itemCity5Days);
            recyclerView5DaysHours.setAdapter(new CityWeather5DaysHourAdapter(getCompactWeatherDataList(itemCity5Days)));
        }


        private List<ItemCityWeather5DaysHours> getCompactWeatherDataList(ItemCityWeather5Days itemCity5Days) {
            List<ItemCityWeather5DaysHours> res = new ArrayList<>();

                for(String dayStr:getStrDays(itemCity5Days)){
                    res.add(new ItemCityWeather5DaysHours(dayStr,getWeatherByHour(itemCity5Days,dayStr)));
                }

            return res;
        }

        private Set<String> getStrDays(ItemCityWeather5Days itemCity5Days){
            Set<String> days = new LinkedHashSet<>();
            String day;

            for (com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.List l:itemCity5Days.getList()){
                day = l.getDtTxt();
                days.add(day.substring(0, day.indexOf(' ')));
            }

            return days;
        }

        private List<ItemCityWeather5DaysHoursCompact> getWeatherByHour(ItemCityWeather5Days itemCity5Days, String date){
            List<ItemCityWeather5DaysHoursCompact> res = new LinkedList<>();
            String hour = "",
                    icon ="",
                    hum = "",
                    wind = "",
                    temp = "";

                for(com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.List l:itemCity5Days.getList()){
                    if(l.getDtTxt().contains(date)){
                        hour = l.getDtTxt();
                        icon = l.getWeather().get(0).getIcon();
                        hum = String.valueOf(l.getMain().getHumidity())+"%";
                        wind = String.valueOf(l.getWind().getSpeed())+"Km/H";
                        temp = String.valueOf(l.getMain().getTemp())+"º";
                        res.add(new ItemCityWeather5DaysHoursCompact(hour.substring(hour.indexOf(' '),hour.length()-1),icon,hum,wind,temp));
                    }

                }

            return res;
        }
    }







}
