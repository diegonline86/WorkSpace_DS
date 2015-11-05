package com.salesianostriana.psp.descargaimagen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by das on 21/10/2015.
 */
public class Utiles {

    public static Bitmap descargarImagen(String url){
        Bitmap img = null;

        try {
            URL myUrl = new URL(url);
            img = BitmapFactory.decodeStream(myUrl.openStream());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}
