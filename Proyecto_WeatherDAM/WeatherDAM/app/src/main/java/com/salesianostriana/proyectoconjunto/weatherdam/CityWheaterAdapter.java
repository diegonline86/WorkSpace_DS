package com.salesianostriana.proyectoconjunto.weatherdam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salesianostriana.proyectoconjunto.weatherdam.model.ItemCityWeather;
import com.salesianostriana.proyectoconjunto.weatherdam.model.Main;
import com.salesianostriana.proyectoconjunto.weatherdam.model.Weather;

import java.util.List;

/**
 * Created by das on 10/11/2015.
 */
public class CityWheaterAdapter extends RecyclerView.Adapter<CityWheaterAdapter.ViewHolder>{
    private List<ItemCityWeather> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewCityWeatherState;
        public TextView textViewCityWeatherLocation;
        public TextView textViewCityWeatherTemp;
        public ImageView imgViewCityWeatherState;

        public ViewHolder(View v) {
            super(v);
            textViewCityWeatherState = (TextView)v.findViewById(R.id.textViewCityWeatherState);
            textViewCityWeatherLocation = (TextView)v.findViewById(R.id.textViewLocation);
            textViewCityWeatherTemp = (TextView) v.findViewById(R.id.textViewTemp);
            imgViewCityWeatherState = (ImageView) v.findViewById(R.id.imgViewWeatherState);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),WeatherDetailsActivity.class);
                    v.getContext().startActivity(i);
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CityWheaterAdapter(List<ItemCityWeather> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CityWheaterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_city_weather, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ItemCityWeather itemActual = mDataset.get(position);
        Weather weather = itemActual.getWeather()[0];

        holder.textViewCityWeatherState.setText(weather.getDescription());
        holder.textViewCityWeatherLocation.setText(itemActual.getName());
        holder.textViewCityWeatherTemp.setText(itemActual.getMain().getTemp()+"º");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
