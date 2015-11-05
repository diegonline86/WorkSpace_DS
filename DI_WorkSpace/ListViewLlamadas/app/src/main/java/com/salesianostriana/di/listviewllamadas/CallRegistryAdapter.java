package com.salesianostriana.di.listviewllamadas;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/**
 * Created by Diego on 27/10/2015.
 */
public class CallRegistryAdapter extends ArrayAdapter<RegistroLlamada>{
    private Context context;
    private ArrayList<RegistroLlamada> listCallRegister;

    public CallRegistryAdapter(Context context, ArrayList<RegistroLlamada> resource) {
        super(context, -1, resource);
        this.context = context;
        this.listCallRegister = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutCallRegister = inflater.inflate(R.layout.list_item_callregistry, parent, false);

        SimpleDateFormat sdfCallDuration = new SimpleDateFormat("dd/MM/yyyy  H:mm");

        ImageView iconoCallState = (ImageView) layoutCallRegister.findViewById(R.id.imageViewCallState);
        TextView textViewTelNumber = (TextView) layoutCallRegister.findViewById(R.id.textViewTelNumber);
        TextView textViewCallDuration = (TextView) layoutCallRegister.findViewById(R.id.textViewCallDuration);
        TextView textViewCallDateTime = (TextView) layoutCallRegister.findViewById(R.id.textViewCallDateTime);

        RegistroLlamada registroActual = listCallRegister.get(position);

        switch (registroActual.getEstado()){
            case 0:
                iconoCallState.setImageResource(R.drawable.ic_call_incoming);
                break;
            case 1:
                iconoCallState.setImageResource(R.drawable.ic_call_outcoming);
                break;
            case 2:
                iconoCallState.setImageResource(R.drawable.ic_call_rejected);
                break;
        }

        textViewTelNumber.setText(registroActual.getNumTelefono());
        textViewCallDateTime.setText(sdfCallDuration.format(registroActual.getFechaHora().getTimeInMillis()));
        textViewCallDuration.setText(timeFormat(registroActual.getDuracion()));

        return layoutCallRegister;
    }

    private String timeFormat(long duracionLlamada){
        String res = null;
        int seconds = (int) (duracionLlamada / 1000) % 60 ;
        int minutes = (int) ((duracionLlamada / (1000*60)) % 60);
        int hours   = (int) ((duracionLlamada / (1000*60*60)) % 24);

        if(minutes>0){
            res = minutes+"m "+seconds+"s ";
        }else if(hours>0){
            res = hours+"h "+minutes+"m "+seconds+"s ";
        }else{
            res = minutes+"m "+seconds+"s ";
        }
        return res;
    }
}
