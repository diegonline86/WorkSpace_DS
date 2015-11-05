package com.salesianostriana.pmdm.reproductormusica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CancionesActivity extends AppCompatActivity {
    ListView listViewItemSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canciones);

        listViewItemSong = (ListView) findViewById(R.id.listViewItemSong);
        final ArrayList<ItemCancion> listaCanciones = new ArrayList<>();
        listaCanciones.add(new ItemCancion("Dan Quin Band", "Ayo Technology", 330000));
        listaCanciones.add(new ItemCancion("Dan Quin Band", "Stronger", 300000));

        final CancionAdapter adapter = new CancionAdapter(this,listaCanciones);

        listViewItemSong.setAdapter(adapter);

        listViewItemSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemCancion cancionActual = listaCanciones.get(position);

                Intent i = new Intent(CancionesActivity.this, ServicioMusica.class);

                i.putExtra("cancion",cancionActual.getTitulo());
                startService(i);
            }
        });
    }
}
