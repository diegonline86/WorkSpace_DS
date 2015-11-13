package com.salesianostriana.proyectoconjunto.weatherdam;

import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.gson.Gson;
import com.salesianostriana.proyectoconjunto.weatherdam.adapter.CityWheaterAdapter;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCity.ItemCity;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather.ItemCityWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherMainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private SearchView.SearchAutoComplete mSearchView;
    private AutoCompleteTextView autoSearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff2196f3));

        rv = (RecyclerView)findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        autoSearchText = (AutoCompleteTextView) searchItem.getActionView();
        autoSearchText.setHint("Search city");
        autoSearchText.setWidth(600);

        autoSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new GetItemCity(s.toString().replace(" ","")).execute();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_configuration) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetItemCityWeather extends AsyncTask<Void,Void,ItemCityWeather>{
        String city;

        public GetItemCityWeather(String _city){
            city = _city;
        }

        @Override
        protected ItemCityWeather doInBackground(Void... params) {
            URL url = null;
            BufferedReader br = null;
            ItemCityWeather result = null;


            try {
                //quitamos los espacios para adaptarlo al formato url
                city.replace(" ","");
                //encajamos la variable en el parametro de ciudades
                url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=616440c75d43cf432ff5518ff8b6ee33");
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


            rv.setAdapter(new CityWheaterAdapter(itemCityWeather));
        }
    }


    private class GetItemCity extends AsyncTask<Void,Void,ItemCity>{
        String city;

        public GetItemCity(String _city){
            city = _city.toString();
        }

        @Override
        protected ItemCity doInBackground(Void... params) {
            URL url = null;
            BufferedReader br = null;
            ItemCity result = null;


            try {
                //encajamos la variable en el parametro de ciudades
                url = new URL("https://maps.googleapis.com/maps/api/place/autocomplete/json?input="+city+"&types=%28cities%29&language=es_ES&key=AIzaSyAKlKgw0xcUOGqWvSo2qOn_zdjXgY8xi3M");
                br = new BufferedReader(new InputStreamReader(url.openStream()));

                Gson gson = new Gson();

                result = gson.fromJson(br, ItemCity.class);


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(br!=null){
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return result;
        }

        @Override
        protected void onPostExecute(ItemCity itemCity) {
            super.onPostExecute(itemCity);
            final List<String> listCities = new ArrayList<>();

            if(itemCity != null) {
                for (int i = 0; i < itemCity.getPredictions().length; i++) {
                    //Voy agregando las ciudades del array de predicciones
                    listCities.add(itemCity.getPredictions()[i].getDescription());
                }
            }

            autoSearchText.setAdapter(new ArrayAdapter<String>(WeatherMainActivity.this,android.R.layout.simple_dropdown_item_1line, listCities));
            autoSearchText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Ejecuto la busqueda de la ciudad seleccionada
                    new GetItemCityWeather(listCities.get(position).replace(" ","")).execute();
                }
            });
        }
    }
}
