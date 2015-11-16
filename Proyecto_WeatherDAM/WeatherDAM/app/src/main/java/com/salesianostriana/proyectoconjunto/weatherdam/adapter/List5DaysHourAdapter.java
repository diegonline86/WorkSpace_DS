package com.salesianostriana.proyectoconjunto.weatherdam.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5DaysHoursCompact;
import com.salesianostriana.proyectoconjunto.weatherdam.utils.ImageUtils;

import java.util.List;

/**
 * Created by Diego on 15/11/2015.
 */
public class List5DaysHourAdapter extends RecyclerView.Adapter<List5DaysHourAdapter.ViewHolder>{
    private List<ItemCityWeather5DaysHoursCompact> data;
    private View v;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        View layoutAlumnoAInyectar;
        TextView textView5DaysHour;
        TextView textView5DaysHum;
        TextView textView5DaysWind;
        TextView textView5DaysTemp;
        ImageView imgView5DaysCond;

        public ViewHolder(View v) {
            super(v);
            textView5DaysHour = (TextView) v.findViewById(R.id.textView5DaysHourValue);
            textView5DaysHum = (TextView) v.findViewById(R.id.textView5DaysHumValue);
            textView5DaysWind = (TextView) v.findViewById(R.id.textView5DaysWindValue);
            textView5DaysTemp = (TextView) v.findViewById(R.id.textView5DaysTempValue);
            imgView5DaysCond = (ImageView) v.findViewById(R.id.imgView5DaysCondValue);
        }
    }

    public List5DaysHourAdapter(List<ItemCityWeather5DaysHoursCompact> values) {
        this.data = values;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_detail_weather_5days_hour, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemCityWeather5DaysHoursCompact itemActual = data.get(position);

        if(position%2==0){
            v.setBackground(new ColorDrawable(0X592196f3));
        }else{
            v.setBackground(new ColorDrawable(0X262196f3));
        }

        holder.textView5DaysHour.setText(itemActual.getHour());
        holder.textView5DaysHum.setText(itemActual.getHumidity());
        holder.textView5DaysWind.setText(itemActual.getWind());
        holder.textView5DaysTemp.setText(itemActual.getTemp());
        ImageUtils.setViewImage(holder.imgView5DaysCond,25,25,itemActual.getIcon());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }
}
