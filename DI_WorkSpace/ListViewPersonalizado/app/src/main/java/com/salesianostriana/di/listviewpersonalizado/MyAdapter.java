package com.salesianostriana.di.listviewpersonalizado;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Diego on 24/10/2015.
 */
public class MyAdapter extends ArrayAdapter<Producto>{
    private final Context context;
    private final ArrayList<Producto> values;


    public MyAdapter(Context context, ArrayList<Producto> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutProducto = inflater.inflate(R.layout.list_item_compra, parent, false);

        // Busco en el layout los elementos a modificar
        ImageView imageViewAgregado = (ImageView) layoutProducto.findViewById(R.id.imageViewAgregado);
        TextView textViewProducto = (TextView) layoutProducto.findViewById(R.id.textViewProducto);

        //Obtenemos el producto a mostrar en cada iteración
        Producto productoActual = values.get(position);

        //Implementamos cebreado de fondo
        if(position%2==0){
            layoutProducto.setBackgroundColor(Color.parseColor("gray"));
        }else{
            layoutProducto.setBackgroundColor(Color.parseColor("lightgray"));
        }

        //Alternamos el icono de agregado ó no agregado
        if(!productoActual.isAgregado()) {
            imageViewAgregado.setImageResource(R.drawable.ic_action_no_agregado);
        }else{
            imageViewAgregado.setImageResource(R.drawable.ic_action_agregado);
        }
        //Mostramos el producto actual.
        textViewProducto.setText(productoActual.getNombre());

        return layoutProducto;
    }
}
