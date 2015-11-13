package com.salesianostriana.proyectoconjunto.weatherdam.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.adapter.CityWeather5DaysAdapter;
import com.salesianostriana.proyectoconjunto.weatherdam.model.CityWeather5DaysCompact;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5Days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Weather5DaysFragment extends Fragment {
    RecyclerView recyclerView5Days;
    String id;

    public Weather5DaysFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extra = getActivity().getIntent().getExtras();
        id = extra.getString("weatherID");

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Aqui recuperamos los elementos del fragment
        View v = inflater.inflate(R.layout.fragment_weather_5days, container, false);

        recyclerView5Days = (RecyclerView)v.findViewById(R.id.rv5Days);
        recyclerView5Days.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView5Days.setLayoutManager(llm);

        new GetWheater5Days().execute();

        return v;
    }

    private class GetWheater5Days extends AsyncTask<Void,Void,ItemCityWeather5Days> {
        @Override
        protected ItemCityWeather5Days doInBackground(Void... params) {
            URL url = null;
            BufferedReader br = null;
            ItemCityWeather5Days result = null;


            try {
                //encajamos la variable en el parametro de ciudades
                url = new URL("http://http://api.openweathermap.org/data/2.5/forecast?"+id+"=524901&appid=616440c75d43cf432ff5518ff8b6ee33");
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
            ;
            ItemCityWeather5Days w5d = itemCity5Days;



            recyclerView5Days.setAdapter(new CityWeather5DaysAdapter(itemCity5Days));

        }

        private List<CityWeather5DaysCompact> compactWeatherData(ItemCityWeather5Days ic5d){
            List<CityWeather5DaysCompact> list5Days = new ArrayList<>();
            Set<String> dates = new HashSet<>();
            List<String> maxTemps = new ArrayList<>();
            List<String> minTemps = new ArrayList<>();

            for(int i=0; i<ic5d.getList().length;i++){
                dates.add(getDayOfWeek(ic5d.getList()[i].getDt_txt()));
                maxTemps.add(ic5d.getList()[i].getMain().getTemp_max());
                minTemps.add(ic5d.getList()[i].getMain().getTemp_min());
            }

            return  list5Days;
        }

        private String getDayOfWeek(String date) {
            Calendar cal = Calendar.getInstance();
            String day = "";
            String[] array_date = date.substring(0, date.indexOf(' ')).split("-");

            cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(array_date[0]));
            cal.set(Calendar.MONTH, Integer.valueOf(array_date[1]) - 1);
            cal.set(Calendar.YEAR, Integer.valueOf(array_date[2]));

            switch (cal.get(Calendar.DAY_OF_WEEK)) {
                case 1:
                    day = "Sun";
                    break;
                case 2:
                    day = "Mon";
                    break;
                case 3:
                    day = "Tue";
                    break;
                case 4:
                    day = "Wed";
                    break;
                case 5:
                    day = "Thu";
                    break;
                case 6:
                    day = "Fri";
                    break;
                case 7:
                    day = "Sat";
                    break;
            }
            return day;
        }

        public List<String> getTemps(List<String> temps,int mode){
            List<String> res = new ArrayList<>();
            List<String> aux = new ArrayList<>();

            int cont = 1;
                for(String s:temps){
                    if(cont==8 && mode==1){
                        res.add(Collections.max(aux));
                        aux.clear();
                    }else if(cont==8 && mode==2){
                        res.add(Collections.min(aux));
                        aux.clear();
                    }else{
                        aux.add(s);
                        cont++;
                    }
                }
            return res;
        }
    }


}
