package com.salesianostriana.di.silguerodiegoalbertorecyclerview;

import android.media.Rating;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Diego on 04/11/2015.
 */
public class CiudadAdapter extends RecyclerView.Adapter<CiudadAdapter.ViewHolder> {
    private List<ItemCiudad> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textViewNombreCiudad, textViewNumHab;
        public ImageView imageViewAeropuerto;
        public RatingBar ratingBar;

        public ViewHolder(View v) {
            super(v);
            textViewNombreCiudad = (TextView)v.findViewById(R.id.editTextNombreCiudad);
            textViewNumHab = (TextView)v.findViewById(R.id.editTextN_habitantes);
            imageViewAeropuerto = (ImageView)v.findViewById(R.id.imgViewAirport);
            ratingBar = (RatingBar)v.findViewById(R.id.ratingBar);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CiudadAdapter(List<ItemCiudad> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CiudadAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_ciudad, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ItemCiudad ciudadActual = mDataset.get(position);

        holder.textViewNombreCiudad.setText(ciudadActual.getNombre());
        holder.textViewNumHab.setText(Integer.toString(ciudadActual.getN_hanbitantes())+" hab");

        if(ciudadActual.isAeropuerto())
            holder.imageViewAeropuerto.setImageResource(R.drawable.ic_aeropuerto);
        else
            holder.imageViewAeropuerto.setImageBitmap(null);

        holder.ratingBar.setRating(new Float(ciudadActual.getRating()));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
