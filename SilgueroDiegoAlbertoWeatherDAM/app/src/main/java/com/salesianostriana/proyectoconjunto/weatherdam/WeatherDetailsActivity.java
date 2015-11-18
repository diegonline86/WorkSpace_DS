package com.salesianostriana.proyectoconjunto.weatherdam;

import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.salesianostriana.proyectoconjunto.weatherdam.adapter.CityWheaterAdapter;
import com.salesianostriana.proyectoconjunto.weatherdam.fragments.Weather5DaysFragment;
import com.salesianostriana.proyectoconjunto.weatherdam.fragments.Weather5DaysHourFragment;
import com.salesianostriana.proyectoconjunto.weatherdam.fragments.WeatherDetailFragment;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCity.ItemCity;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather.ItemCityWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherDetailsActivity extends AppCompatActivity{
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private AutoCompleteTextView autoSearchText;
    private Fragment fragmentDetail,fragment5Days,fragment5DaysHour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Personalizo los colores de la barra de acción y de estado
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff2196f3));
        getWindow().setStatusBarColor(0xff1565c0);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setBackground(new ColorDrawable(0xff2196f3));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        autoSearchText = (AutoCompleteTextView) searchItem.getActionView();
        autoSearchText.setHint("Search city");
        autoSearchText.setWidth(1000);

        fragmentDetail = new WeatherDetailFragment();
        fragment5Days = new Weather5DaysFragment();
        fragment5DaysHour = new Weather5DaysHourFragment();

        autoSearchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                new GetItemCity(s.toString().replace(" ", "")).execute();
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
        }else if(id == R.id.action_refresh){
            //lo que hacemos para refrescar es recrear el activity
            WeatherDetailsActivity.this.recreate();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position==0) {
                return new WeatherDetailFragment();
            } else if(position==1) {
                return new Weather5DaysFragment();
            } else if(position==2){
               return new Weather5DaysHourFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Detail";
                case 1:
                    return "5 Days";
                case 2:
                    return "Hours";
            }
            return null;
        }
    }

    private class GetItemCity extends AsyncTask<Void,Void,ItemCity> {
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
                url = new URL("https://maps.googleapis.com/maps/api/place/autocomplete/json?input="+city+"&types=%28cities%29&key=AIzaSyAKlKgw0xcUOGqWvSo2qOn_zdjXgY8xi3M");
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
                for (int i = 0; i < itemCity.getPredictions().size(); i++) {
                    //Voy agregando las ciudades del array de predicciones
                    listCities.add(itemCity.getPredictions().get(i).getDescription());
                }
            }

            autoSearchText.setAdapter(new ArrayAdapter<String>(WeatherDetailsActivity.this,android.R.layout.simple_dropdown_item_1line, listCities));
            autoSearchText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Guardo en la propiedad la variable buscada
                    city = listCities.get(position);
                    //Actualizo el extra que se propaga en los fragments
                    getIntent().removeExtra("city");
                    getIntent().putExtra("city",city);
                    //refresco el activity
                    WeatherDetailsActivity.this.recreate();
                }
            });
        }
    }
}
