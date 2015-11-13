package com.salesianostriana.proyectoconjunto.weatherdam.adapter;

import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.WeatherDetailsActivity;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather.ItemCityWeather;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather.Weather;

/**
 * Created by das on 10/11/2015.
 */
public class CityWheaterAdapter extends RecyclerView.Adapter<CityWheaterAdapter.ViewHolder>{
    private ItemCityWeather mDataset;
    private boolean bookmakrClicked;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewCityWeatherState;
        public TextView textViewCityWeatherLocation;
        public TextView textViewCityWeatherTemp;
        public ImageView imgViewCityWeatherState;
        public ImageButton imgBtnBookmark;
        public String id;

        public ViewHolder(View v) {
            super(v);
            textViewCityWeatherState = (TextView)v.findViewById(R.id.textViewCityWeatherState);
            textViewCityWeatherLocation = (TextView)v.findViewById(R.id.textViewLocation);
            textViewCityWeatherTemp = (TextView) v.findViewById(R.id.textViewTemp);
            imgViewCityWeatherState = (ImageView) v.findViewById(R.id.imgViewWeatherState);
            imgBtnBookmark = (ImageButton) v.findViewById(R.id.imgBtnBookMark);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), WeatherDetailsActivity.class);
                    i.putExtra("weatherID",id);
                    v.getContext().startActivity(i);
                }
            });
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CityWheaterAdapter(ItemCityWeather myDataset) {
        mDataset = myDataset;
        bookmakrClicked = false;
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
        ItemCityWeather itemActual = mDataset;
        Weather weather = itemActual.getWeather().get(0);

        holder.textViewCityWeatherState.setText(weather.getDescription());
        holder.textViewCityWeatherLocation.setText(itemActual.getName());
        holder.textViewCityWeatherTemp.setText(String.valueOf(itemActual.getMain().getTemp())+"º");
        holder.id = String.valueOf(itemActual.getId());

        holder.imgBtnBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton imgBtnBookMark= (ImageButton)v;
                    if(bookmakrClicked) {
                        imgBtnBookMark.setImageResource(android.R.drawable.star_big_on);
                        Toast.makeText(v.getContext(), "Agregado a favoritos", Toast.LENGTH_SHORT).show();
                        bookmakrClicked = false;
                    }else{
                        imgBtnBookMark.setImageResource(android.R.drawable.star_big_off);
                        bookmakrClicked = true;
                    }
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 1;
    }

}
