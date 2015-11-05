package com.salesianostriana.ad.des_mem_int;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends Activity {
    private InputStream myInput;
    private BufferedInputStream myBfInput;
    private DataOutputStream myDOS;
    private byte [] buffer;
    private final int TAM = 64 * 1024;
    private int c,contBytes;
    private long inicio, fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //definimos el tamaño de arrays de buffer
        buffer = new byte[TAM];

        //Capturamos el tiempo de inicio de la descarga
        inicio=System.currentTimeMillis();
        //Recuperamos el fichero descargado en un InputStream
        myInput = getInputStreamFromURL("http://www.tuxradar.com/files/linux_starter_pack.zip");
        //Capturamos el tiempo final de la descarga
        fin=System.currentTimeMillis();

        //Enlazamos el flujo input dentro del bufferInputStream
        myBfInput = new BufferedInputStream(myInput);

        try {
            //Creamos el flujo de escritura
            myDOS = new DataOutputStream(openFileOutput("download.file",MODE_PRIVATE));
            //leemos los bytes del fichero almacenado dentro del buffer
            while((c=myBfInput.read(buffer,0,TAM))!= -1){
                //Guardamos el fichero en memoria teniendo en cuenta el tamaño de bytes devueltos
                //en la lectura
                myDOS.write(buffer,0,c);
                //Sumamos el tamaño leido por cada iteración
                contBytes += c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                myInput.close();
                myBfInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Log.i("DESCARGA TAM", Integer.toString(contBytes) + " bytes");
        Log.i("DESCARGA TIEMPO",formatTime(fin-inicio));

    }


    private String formatTime(Long millis){
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;

        String time = String.format("%02d H:%02d M:%02d S:%d Ms", hour, minute, second, millis);
        return time;
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
