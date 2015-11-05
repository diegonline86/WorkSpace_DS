package com.salesianostriana.di.gridviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Diego on 27/10/2015.
 */
public class AppsAdapter extends ArrayAdapter<App>{
    Context context;
    ArrayList<App> listApp;

    public AppsAdapter(Context context, ArrayList<App> resource) {
        super(context, -1, resource);

        this.context = context;
        this.listApp = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutApps = inflater.inflate("");

        App appActual = listApp.get(position);

        return layoutApps;
    }
}
