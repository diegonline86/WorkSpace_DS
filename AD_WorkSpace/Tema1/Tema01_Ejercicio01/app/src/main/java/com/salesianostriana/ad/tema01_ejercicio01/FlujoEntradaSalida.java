package com.salesianostriana.ad.tema01_ejercicio01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FlujoEntradaSalida extends Activity {
    private FileOutputStream fich_sal;
    private File fich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flujo_entrada_salida);

        //Flujo de salida
        try {
            fich = new File("data/data/com.salesianostriana.ad.tema01_ejercicio01/numeros.dat");
            fich_sal = new FileOutputStream(fich);
            for (int i=0; i<=255; i++){
                Log.i("ESCRITURA FICHERO","Escribiendo: "+i);
                fich_sal.write(Byte.valueOf(Integer.toString(i)));

            }
        } catch (IOException e) {
            Log.e("ERROR FICHERO","Ocurrio un error en el fichero");
            e.printStackTrace();
        }finally {
            try {
                if(fich_sal!=null)
                    fich_sal.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_flujo_entrada_salida, menu);
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
}
