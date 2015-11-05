package com.salesianostriana.di.ad_calendario;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class MainActivity extends Activity implements View.OnClickListener{
    List<Integer> cantidades;
    List<String> conceptos;
    Button btn_add, btn_save, btn_reset;
    EditText editTextCantidad, editTextConcepto;
    TextView textViewListaCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantidades = new ArrayList<>();
        conceptos = new ArrayList<>();

        btn_add = (Button)findViewById(R.id.button_add);
        btn_save = (Button)findViewById(R.id.button_save);
        btn_reset = (Button)findViewById(R.id.button_reset);
        editTextCantidad = (EditText)findViewById(R.id.editTextCantidad);
        editTextConcepto = (EditText)findViewById(R.id.editTextConcepto);
        textViewListaCompra = (TextView)findViewById(R.id.textViewListaCompra);

        btn_add.setOnClickListener(this);
        btn_save.setOnClickListener(this);
        btn_reset.setOnClickListener(this);

        leerListaCompra();
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_add:
                cantidades.add(Integer.valueOf(editTextCantidad.getText().toString()));
                conceptos.add(editTextConcepto.getText().toString());
                mostrarCompra();
                break;
            case R.id.button_save:
                escribirListaCompra();
                break;
            case R.id.button_reset:
                cantidades.clear();
                conceptos.clear();
                textViewListaCompra.setText("");
                break;
        }
    }

    public void escribirListaCompra(){
        DataOutputStream fSalida = null;
        StringBuilder strB = new StringBuilder();

        try {
            fSalida = new DataOutputStream(openFileOutput("listaCompra.dat", Context.MODE_PRIVATE));
            for(int i =0 ; i < cantidades.size(); i++){
                strB.append("["+cantidades.get(i).toString()+"] "+conceptos.get(i)+ "\n");
                Log.i("COMPRA",strB.toString());
            }
            fSalida.writeUTF(strB.toString());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fSalida!= null)
                    fSalida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void leerListaCompra(){
        DataInputStream fEntrada = null;
        StringBuilder strB = new StringBuilder();
        String compra;

        try {
            fEntrada = new DataInputStream(openFileInput("listaCompra.dat"));

            while((compra=fEntrada.readUTF())!=null){
                strB.append(compra + "\n");
            }

            textViewListaCompra.setText(strB.toString());
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

    public void mostrarCompra(){
        StringBuilder strB = new StringBuilder();

        for(int i =0 ; i < cantidades.size(); i++){
            strB.append("["+cantidades.get(i).toString()+"] "+conceptos.get(i)+ "\n");
        }
        textViewListaCompra.setText(strB.toString());
    }
}
