package com.salesianostriana.proyectoconjunto.weatherdam.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCity5Days;


/**
 * Created by das on 12/11/2015.
 */
public class CityWeather5DaysAdapter extends RecyclerView.Adapter<CityWeather5DaysAdapter.ViewHolder>{
    private ItemCity5Days mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        /*public TextView textViewCityWeatherState;
        public TextView textViewCityWeatherLocation;
        public TextView textViewCityWeatherTemp;
        public ImageView imgViewCityWeatherState;*/

        public ViewHolder(View v) {
            super(v);
            /*textViewCityWeatherState = (TextView)v.findViewById(R.id.textViewCityWeatherState);
            textViewCityWeatherLocation = (TextView)v.findViewById(R.id.textViewLocation);
            textViewCityWeatherTemp = (TextView) v.findViewById(R.id.textViewTemp);
            imgViewCityWeatherState = (ImageView) v.findViewById(R.id.imgViewWeatherState);*/

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CityWeather5DaysAdapter(ItemCity5Days myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CityWeather5DaysAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_city_weather, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ItemCity5Days itemActual = mDataset;

        /*holder.textViewCityWeatherState.setText(weather.getDescription());
        holder.textViewCityWeatherLocation.setText(itemActual.getName());
        holder.textViewCityWeatherTemp.setText(itemActual.getMain().getTemp()+"º");*/


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 1;
    }

}
