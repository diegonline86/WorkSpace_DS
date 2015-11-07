package com.salesianostriana.pmdm.reproductormusica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Diego on 02/11/2015.
 */
public class CancionAdapter extends ArrayAdapter<ItemCancion>{
    private final Context context;
    private final ArrayList<ItemCancion> values;


    public CancionAdapter(Context context, ArrayList<ItemCancion> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View layoutCancion = inflater.inflate(R.layout.layout_list_cancion, parent, false);

        // Busco en el layout los elementos a modificar
        TextView nombreCancion = (TextView) layoutCancion.findViewById(R.id.textViewTituloCancion);
        TextView nombreGrupo = (TextView) layoutCancion.findViewById(R.id.textViewGrupo);
        TextView duracion = (TextView) layoutCancion.findViewById(R.id.textViewDuracion);

        // Para poder llenar los elementos del Layout de contenido, necesito obtener
        // los datos de la canción que estoy recorriendo en esta iteración
        ItemCancion cancionActual = values.get(position);

        nombreCancion.setText(cancionActual.getTitulo());
        nombreGrupo.setText(cancionActual.getGrupo());
        duracion.setText(formatTimeSong(cancionActual.getDuracion()));

        return layoutCancion;
    }

    private String formatTimeSong(long duration){
        return String.format("%d : %d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
    }
}
