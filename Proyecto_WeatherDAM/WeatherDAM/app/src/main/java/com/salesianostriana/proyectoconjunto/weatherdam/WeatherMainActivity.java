package com.salesianostriana.proyectoconjunto.weatherdam;


import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.salesianostriana.proyectoconjunto.weatherdam.adapter.CityWheaterAdapter;
import com.salesianostriana.proyectoconjunto.weatherdam.model.ItemCityWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherMainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView rv;
    //private List<ItemCityWeather> listItemWeatherCity;
    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff2196f3));
        //listItemWeatherCity = new ArrayList<>();

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
        mSearchView = (SearchView) searchItem.getActionView();
        mSearchView.setQueryHint("Type city...");
        mSearchView.setOnQueryTextListener(this);

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

    @Override
    public boolean onQueryTextSubmit(String query) {
        new GetItemCityWeather(query).execute();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
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
}
