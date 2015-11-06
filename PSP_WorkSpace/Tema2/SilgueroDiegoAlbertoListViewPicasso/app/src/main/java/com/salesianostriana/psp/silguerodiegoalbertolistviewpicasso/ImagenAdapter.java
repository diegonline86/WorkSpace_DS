package com.salesianostriana.psp.silguerodiegoalbertolistviewpicasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by das on 06/11/2015.
 */
public class ImagenAdapter extends ArrayAdapter<ItemImagen> {
    private Context context;
    private List<ItemImagen> values;

    public ImagenAdapter(Context context, List<ItemImagen> resource) {
        super(context,-1, resource);
        this.context = context;
        this.values = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutImagen = inflater.inflate(R.layout.list_item_imagen, parent, false);
        TextView editText = (TextView) layoutImagen.findViewById(R.id.textViewNombre);
        ImageView imageViewFoto = (ImageView) layoutImagen.findViewById(R.id.imageViewFoto);

        ItemImagen imagenActual = values.get(position);

        // Modificaciones a realizar en el layout...
        editText.setText(imagenActual.getNombreImagen());
        Picasso.with(context)
                .load(imagenActual.getImgRsrc())
                .resize(200,200)
                .into(imageViewFoto);

        return layoutImagen;
    }
}
