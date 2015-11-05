package com.salesianostriana.ad.lecutraficheroimagenespecial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataInputStream fEntrada = null;
    ImagenE imgE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            fEntrada = new DataInputStream(openFileInput("fichero1.dat"));
            List<Byte> listBytes = new ArrayList<>();

            imgE = new ImagenE(fEntrada.readInt(),fEntrada.readUTF(),fEntrada.readInt(),fEntrada.readInt(),fEntrada.readByte());

            Log.i("IMAGEN CODIGO", Integer.toString(imgE.getCodigo()));
            Log.i("IMAGEN COMENTARIO", imgE.getComentario());
            Log.i("IMAGEN ALTO", Integer.toString(imgE.getAlto()));
            Log.i("IMAGEN ANCHO", Integer.toString(imgE.getAncho()));

            for(int b:imgE.getContenido()) {
                Log.i("IMAGEN BYTES", Integer.toBinaryString(b));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fEntrada!=null)
                    fEntrada.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
