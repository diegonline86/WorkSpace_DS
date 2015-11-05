package com.salesianostriana.ad.tema01_ejercicio02;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends Activity {
    private InputStream myInput;
    private int c,contBytes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Recuperamos el fichero descargado en un InputStream
        myInput = getInputStreamFromURL("http://www.tuxradar.com/files/linux_starter_pack.zip");

        try {
            //leemos los bytes del fichero
            while((c=myInput.read())!= -1){
                //contamos los bytes en cada iteración
                contBytes++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                myInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.i("DESCARGA TAM",Integer.toString(contBytes)+" bytes");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Método que recupera un InputStream desde una URL
    public InputStream getInputStreamFromURL(String url) {
        URL u = null;
        URLConnection con = null;
        InputStream is = null;

        try {
            Log.i("DESCARGA","Descargando fichero...");
            u = new URL(url);
            con = u.openConnection();
            is = con.getInputStream();
        } catch (java.io.IOException e) {
            Log.e("ERROR DESCARGA","ERROR en la descarga del fichero");
            e.printStackTrace();
        }

        return is;
    }
}
