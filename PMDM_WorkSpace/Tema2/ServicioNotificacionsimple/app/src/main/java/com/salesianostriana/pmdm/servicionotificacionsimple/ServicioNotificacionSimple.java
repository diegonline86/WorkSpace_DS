package com.salesianostriana.pmdm.servicionotificacionsimple;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ServicioNotificacionSimple extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinnerSongs;
    Button btn_iniciar,btn_parar;
    String cancionSeleccionada;
    ArrayAdapter<CharSequence> myAdapter;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_notificacion_simple);

        spinnerSongs = (Spinner) findViewById(R.id.spinnerSongs);
        btn_iniciar = (Button) findViewById(R.id.btnIniciar);
        btn_parar = (Button) findViewById(R.id.btn_parar);

        myAdapter = ArrayAdapter.createFromResource(this, R.array.song_list, android.R.layout.simple_spinner_item);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSongs.setAdapter(myAdapter);
        spinnerSongs.setOnItemSelectedListener(this);

        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(ServicioNotificacionSimple.this,ServicioCancion.class);
                i.putExtra("cancion", cancionSeleccionada);
                startService(i);
            }
        });

        btn_parar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        cancionSeleccionada = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
