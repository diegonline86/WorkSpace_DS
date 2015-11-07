package com.salesianostriana.psp.fuerzabruta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ExecutorService myES;
    boolean passfound;
    long inicio, fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos los elementos del layout
        final Button btnFindPass = (Button)findViewById(R.id.btn_findPass);
        final EditText editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        passfound = false;

        btnFindPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myES = Executors.newFixedThreadPool(1);


                myES.execute(new Runnable() {
                    @Override
                    public void run() {
                        int i=0;
                        String cad="",password = editTextPassword.getText().toString();

                        inicio = System.currentTimeMillis();
                        while(!passfound){
                            cad=UtilRandomString.getCadenaAlfanumAleatoria(password.length());
                            i++;
                            if(i%500 == 0)
                                Log.i("PASS INTENTOS",Integer.toString(i));
                            else if(password.equals(cad))
                                passfound = true;
                        }
                        fin = System.currentTimeMillis();
                        Log.i("PASS ENCONTRADO",cad);
                        Log.i("PASS TIEMPO DE BUSQUEDA",formatTime(fin-inicio));

                    }
                });

                myES.shutdown();

            }
        });

    }

    private String formatTime(Long millis){
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;

        String time = String.format("%02d hs: %02d min: %02d seg: %d milseg", hour, minute, second, millis);
        return time;
    }

}
