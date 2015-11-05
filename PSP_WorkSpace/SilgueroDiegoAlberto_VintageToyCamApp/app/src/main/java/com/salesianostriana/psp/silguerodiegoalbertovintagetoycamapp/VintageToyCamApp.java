package com.salesianostriana.psp.silguerodiegoalbertovintagetoycamapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class VintageToyCamApp extends AppCompatActivity {
    ImageView imageViewPhoto;
    Button btnAnterior, btnSiguiente;
    List<Integer> listPhotos;
    int fotoActual, i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vintage_toy_cam_app);

        listPhotos = new ArrayList<>();
        listPhotos.add(R.drawable.alcazaba_almeria);
        listPhotos.add(R.drawable.alcazaba_malaga);
        listPhotos.add(R.drawable.alhambra);
        listPhotos.add(R.drawable.catedral_jaen);
        listPhotos.add(R.drawable.giralda);
        listPhotos.add(R.drawable.mezquita_de_cordoba);
        listPhotos.add(R.drawable.monasterio_rabida);
        listPhotos.add(R.drawable.salvador_ubeda);
        listPhotos.add(R.drawable.torre_del_oro);

        fotoActual = listPhotos.get(new Random().nextInt(9));
        i = listPhotos.indexOf(fotoActual);

        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        btnAnterior = (Button) findViewById(R.id.btnAnterior);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        Picasso.with(VintageToyCamApp.this).load(fotoActual)
                .resize(500, 500)
                .centerCrop()
                .into(imageViewPhoto);


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 0)
                    i = listPhotos.size()-1;
                fotoActual = listPhotos.get(i);
                Picasso.with(VintageToyCamApp.this)
                        .load(fotoActual)
                        .resize(500, 500)
                        .centerCrop()
                        .into(imageViewPhoto);
                i--;
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==listPhotos.size())
                    i = 0;
                fotoActual = listPhotos.get(i);
                Picasso.with(VintageToyCamApp.this)
                        .load(fotoActual)
                        .resize(500, 500)
                        .centerCrop()
                        .into(imageViewPhoto);
                i++;
            }
        });
    }
}
