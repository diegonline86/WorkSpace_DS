package com.salesianostriana.proyectoconjunto.weatherdam.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5DaysHours;

import java.util.List;

/**
 * Created by Diego on 15/11/2015.
 */
public class CityWeather5DaysHourAdapter extends RecyclerView.Adapter<CityWeather5DaysHourAdapter.ViewHolder>{
    private List<ItemCityWeather5DaysHours> mDataset;
    private View v;

    public CityWeather5DaysHourAdapter(List<ItemCityWeather5DaysHours> values) {
        mDataset = values;
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView5DaysDate;
        public RecyclerView myRecyclerView;


        public ViewHolder(View v) {
            super(v);
            textView5DaysDate = (TextView) v.findViewById(R.id.textView5DaysDateTitle);
            myRecyclerView = (RecyclerView) v.findViewById(R.id.rv5DaysHoursContent);
            myRecyclerView.setLayoutManager(new CustomLinearlayoutManager(v.getContext()));
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_weather_5days_hour, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemCityWeather5DaysHours itemActual = mDataset.get(position);

        holder.textView5DaysDate.setText(itemActual.getDay());
        holder.myRecyclerView.setAdapter(new List5DaysHourAdapter(itemActual.getListHourWeather()));
    }

    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}
