package com.salesianostriana.proyectoconjunto.weatherdam.adapter;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days.ItemCityWeather5DaysCompact;
import com.salesianostriana.proyectoconjunto.weatherdam.utils.ImageUtils;

import java.util.List;


/**
 * Created by das on 12/11/2015.
 */
public class CityWeather5DaysAdapter extends RecyclerView.Adapter<CityWeather5DaysAdapter.ViewHolder>{
    private List<ItemCityWeather5DaysCompact> mDataset;
    private View v;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewDay5Days;
        public TextView textViewMaxTemp5Days;
        public TextView textViewMinTemp5Days;
        public ImageView imgView5Days;

        public ViewHolder(View v) {
            super(v);
            textViewDay5Days = (TextView)v.findViewById(R.id.editTextDay5Days);
            textViewMaxTemp5Days = (TextView)v.findViewById(R.id.editTextMaxTemp5Days);
            textViewMinTemp5Days = (TextView) v.findViewById(R.id.textViewMinTemp5Days);
            imgView5Days = (ImageView) v.findViewById(R.id.imageView5Days);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CityWeather5DaysAdapter(List<ItemCityWeather5DaysCompact> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CityWeather5DaysAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_weather_5days, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        if(position%2==0){
            v.setBackground(new ColorDrawable(0X262196f3));
        }

        ItemCityWeather5DaysCompact itemActual = mDataset.get(position);
        holder.textViewDay5Days.setText(itemActual.getDay());
        holder.textViewMaxTemp5Days.setText(itemActual.getMaxTemp());
        holder.textViewMinTemp5Days.setText(itemActual.getMinTemp());
        ImageUtils.setViewImage(holder.imgView5Days,500,500,itemActual.getIcon());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
