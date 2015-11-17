package com.salesianostriana.proyectoconjunto.weatherdam.utils;

import android.view.View;
import android.widget.ImageView;

import com.salesianostriana.proyectoconjunto.weatherdam.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Diego on 15/11/2015.
 */
public class ImageUtils {

    public static void setViewImage(View v, int width, int height, String icon){
        ImageView view = (ImageView) v;
        int resource = 0;

        switch (icon){
            case "01d":
                resource = R.drawable.ic_01d;
                break;
            case "01n":
                resource = R.drawable.ic_01n;
                break;
            case "02d":
                resource = R.drawable.ic_02d;
                break;
            case "02n":
                resource = R.drawable.ic_02n;
                break;
            case "03d":
                resource = R.drawable.ic_03d;
                break;
            case "03n":
                resource = R.drawable.ic_03n;
                break;
            case "04d":
                resource = R.drawable.ic_04d;
                break;
            case "04n":
                resource = R.drawable.ic_04n;
                break;
            case "09d":
                resource = R.drawable.ic_09d;
                break;
            case "09n":
                resource = R.drawable.ic_09n;
                break;
            case "10d":
                resource = R.drawable.ic_10d;
                break;
            case "10n":
                resource = R.drawable.ic_10n;
                break;
            case "11d":
                resource = R.drawable.ic_11d;
                break;
            case "11n":
                resource = R.drawable.ic_11n;
                break;
            case "13d":
                resource = R.drawable.ic_13d;
                break;
            case "13n":
                resource = R.drawable.ic_13n;
                break;
            case "50d":
                resource = R.drawable.ic_50d;
                break;
            case "50n":
                resource = R.drawable.ic_50n;
                break;
        }

        Picasso.with(v.getContext()).load(resource)
                .resize(width,height)
                .centerCrop()
                .into(view);
    }

    public static void setViewImage(View v, String icon){
        ImageView view = (ImageView) v;
        int resource = 0;

        switch (icon){
            case "01d":
                resource = R.drawable.ic_01d;
                break;
            case "01n":
                resource = R.drawable.ic_01n;
                break;
            case "02d":
                resource = R.drawable.ic_02d;
                break;
            case "02n":
                resource = R.drawable.ic_02n;
                break;
            case "03d":
                resource = R.drawable.ic_03d;
                break;
            case "03n":
                resource = R.drawable.ic_03n;
                break;
            case "04d":
                resource = R.drawable.ic_04d;
                break;
            case "04n":
                resource = R.drawable.ic_04n;
                break;
            case "09d":
                resource = R.drawable.ic_09d;
                break;
            case "09n":
                resource = R.drawable.ic_09n;
                break;
            case "10d":
                resource = R.drawable.ic_10d;
                break;
            case "10n":
                resource = R.drawable.ic_10n;
                break;
            case "11d":
                resource = R.drawable.ic_11d;
                break;
            case "11n":
                resource = R.drawable.ic_11n;
                break;
            case "13d":
                resource = R.drawable.ic_13d;
                break;
            case "13n":
                resource = R.drawable.ic_13n;
                break;
            case "50d":
                resource = R.drawable.ic_50d;
                break;
            case "50n":
                resource = R.drawable.ic_50n;
                break;
        }

        Picasso.with(v.getContext()).load(resource)
                .into(view);
    }
}
