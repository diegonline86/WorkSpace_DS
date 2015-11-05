package com.salesianostriana.ad.contadorletrasporpalabra;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends Activity {
    private Button btn_go,btn_reset;
    private EditText editTextPhrase;
    private TextView textViewResult;
    private List<Future<Integer>> nLetras;
    ExecutorService eS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go = (Button)findViewById(R.id.button_go);
        btn_reset = (Button)findViewById(R.id.button_reset);
        editTextPhrase = (EditText)findViewById(R.id.editTextPhrase);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        nLetras = new ArrayList<Future<Integer>>();
        eS = Executors.newFixedThreadPool(3);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Instanciamos un ExecutorSerice con un pool de 3 hilos

                //Contamos el número de palabras en total del texto.
                int nPalabras = contadorPalabras(editTextPhrase.getText().toString());
                Integer totalLetras = 0;

                //Ejecutamos el ExecutorService
                eS.execute(new Runnable() {

                    @Override
                    public void run() {
                        //Extraemos cada palabra del texto por cada iteración
                        for (String p : extraerPalabras(editTextPhrase.getText().toString())) {
                            try {
                                nLetras.add(eS.submit(new ContadorLetras(p)));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });

                for (Future<Integer> n:nLetras){
                    try {
                        totalLetras += n.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                textViewResult.setText("Nº palabras: " + nPalabras + "\n" +
                            "Nº de caracteres: " + totalLetras+"\n"+
                            "Media de letras: ");


            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nLetras.clear();
                textViewResult.setText("");
            }
        });
    }

    public int contadorPalabras(String texto){
        StringTokenizer contP = new StringTokenizer(texto);
        return contP.countTokens();
    }

    public String[] extraerPalabras(String texto){
        String delims = "[ .,;?!¡¿\'\"\\[\\]]+";
        return texto.split(delims);
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
}
