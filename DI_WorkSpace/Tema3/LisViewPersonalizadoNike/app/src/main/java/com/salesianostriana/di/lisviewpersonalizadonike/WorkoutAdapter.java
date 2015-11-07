package com.salesianostriana.di.lisviewpersonalizadonike;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 26/10/2015.
 */
public class WorkoutAdapter extends ArrayAdapter<EjercicioGimnasio>{
    private final Context context;
    private final ArrayList<EjercicioGimnasio> values;

    public WorkoutAdapter(Context context, ArrayList<EjercicioGimnasio> resource) {
        super(context, -1, resource);
        this.context = context;
        this.values = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutEjercicios = inflater.inflate(R.layout.list_item_workout, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView icDuration = (ImageView) layoutEjercicios.findViewById(R.id.imageViewDuration);
        TextView textViewNombreEjercicio = (TextView) layoutEjercicios.findViewById(R.id.textViewWorkout);
        ImageButton imgBtnmore = (ImageButton) layoutEjercicios.findViewById(R.id.imgBtnMore);


        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos del alumno que estoy recorriendo en esta iteración
        EjercicioGimnasio ejercicioActual = values.get(position);

        if(ejercicioActual.getDuration() == 30) {
            icDuration.setImageResource(R.drawable.ic_time_30);
        } else {
            icDuration.setImageResource(R.drawable.ic_time_45);
        }

        textViewNombreEjercicio.setText(ejercicioActual.getExersice());
        imgBtnmore.setImageResource(R.drawable.ic_action_more);

        return layoutEjercicios;


    }
}
