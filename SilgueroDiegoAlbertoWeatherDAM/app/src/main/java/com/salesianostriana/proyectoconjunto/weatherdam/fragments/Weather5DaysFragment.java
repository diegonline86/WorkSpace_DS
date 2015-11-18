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
import com.salesianostriana.proyectoconjunto.weatherdam.adapter.CityWeather5DaysAdapter;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5Days;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5DaysCompact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


public class Weather5DaysFragment extends Fragment {
    RecyclerView recyclerView5Days;
    String city;

    public Weather5DaysFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extra = getActivity().getIntent().getExtras();
        city = extra.getString("city");

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
                //encajamos la variable en el parametro URL de ciudades y adaptamos la variable city al formato URL
                url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="+URLEncoder.encode(city,"UTF-8")+"&units=metric&appid=616440c75d43cf432ff5518ff8b6ee33");
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
            recyclerView5Days.setAdapter(new CityWeather5DaysAdapter(getCompactWeatherDataList(itemCity5Days)));
        }

        //En este método comprimimos la informacion necesaria para mostrar en el
        //pronostico de 5 días simplicado
        private List<ItemCityWeather5DaysCompact> getCompactWeatherDataList(ItemCityWeather5Days ic5d){
            List<ItemCityWeather5DaysCompact> list5Days = new ArrayList<>();
            Set<String> days = new LinkedHashSet<>(), days2 = new LinkedHashSet<>();
            List<Double> listMaxTemps = new LinkedList<>();
            List<Double> listMinTemps = new LinkedList<>();
            List<String> listIcons = new ArrayList<>();
            int k = 0;

            for(int i=0; i<ic5d.getList().size();i++){
                String day = ic5d.getList().get(i).getDtTxt();
                days.add(getDayOfWeek(day));
                days2.add(day.substring(0, day.indexOf(' ')));
                listIcons.add(getMaxIcon(ic5d,day));
            }

            for(String d:days2){
                listMaxTemps.add(getTemps(ic5d,d,1));
                listMinTemps.add(getTemps(ic5d,d,2));
            }

            for(String d:days){
                list5Days.add(new ItemCityWeather5DaysCompact(d,String.valueOf(listMaxTemps.get(k))+"º",String.valueOf(listMinTemps.get(k))+"º",listIcons.get(k)));
                k++;
            }

            return  list5Days;
        }

        //En este método obtenemos el formato cadena del dia de la fecha
        //a mostrar en el pronostico diario
        private String getDayOfWeek(String date) {
            Calendar cal = Calendar.getInstance();
            String day = "";
            String[] array_date = date.substring(0, date.indexOf(' ')).split("-");

            cal.set(Calendar.YEAR, Integer.valueOf(array_date[0]));
            cal.set(Calendar.MONTH, Integer.valueOf(array_date[1]) - 1);
            cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(array_date[2]));

            switch (cal.get(Calendar.DAY_OF_WEEK)) {
                case 1:
                    day = "SUN";
                    break;
                case 2:
                    day = "MON";
                    break;
                case 3:
                    day = "TUE";
                    break;
                case 4:
                    day = "WED";
                    break;
                case 5:
                    day = "THU";
                    break;
                case 6:
                    day = "FRI";
                    break;
                case 7:
                    day = "SAT";
                    break;
            }
            return day;
        }

        //En este método filramos las temperaturas por una fecha dada por parametro
        //y devolvemos el valor maximo o minimo segun el modo elegido, 1 maximo y 2 minimo
        public double getTemps(ItemCityWeather5Days weather, String date,int mode){
            List<Double> aux = new LinkedList<>();
            double res;

            for(com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.List w:weather.getList()){
                if(w.getDtTxt().contains(date) && mode==1){
                    aux.add(w.getMain().getTempMax());
                }else if(w.getDtTxt().contains(date) && mode==2){
                    aux.add(w.getMain().getTempMin());
                }
            }

            if(mode==1){
                res= Collections.max(aux);
            }else{
                res = Collections.min(aux);
            }

            return res;
        }

        public String getMaxIcon(ItemCityWeather5Days ic5D, String date){
            Map<String,Integer> valuesCont = new LinkedHashMap<>();
            Set<String> setIcons = new LinkedHashSet<>();
            List<String> listIcon= new ArrayList<>();
            int cont = 0;

            for (com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.List  w: ic5D.getList()) {
                //Almacenamos los iconos de una fecha determinada en parametro
                //y en dentro del horario de dia
                if (w.getDtTxt().equals(date)) {
                    listIcon.add(w.getWeather().get(0).getIcon());
                }
            }
            //Filtramos los elementos repetidos
            setIcons.addAll(listIcon);

            //Contamos la concurrencias de cada icono de la lista
            //con los elementos no repetidos
            for (String icon : setIcons) {
                for (String iconFind : listIcon) {
                    if (icon.equals(iconFind)) {
                        cont++;
                        valuesCont.put(icon, cont);
                    }
                }
                //reseteamos el contador para la proxima busqueda
                cont = 0;
            }

            //Nos quedamos con el valor maximo del contador
            cont = Collections.max(valuesCont.values());

            //Buscamos en el hashMap la llave asociada al valor maximo
            for (Map.Entry<String, Integer>  entry: valuesCont.entrySet()) {
                if(Objects.equals(cont,entry.getValue())){
                    return entry.getKey();
                }
            }

            return "";
        }
    }
}



