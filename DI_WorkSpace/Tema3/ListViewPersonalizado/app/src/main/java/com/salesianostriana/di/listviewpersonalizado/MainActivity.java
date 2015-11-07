package com.salesianostriana.di.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewCompra;
    private boolean agregado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregado = false;
        final ArrayList<Producto> listaCompra = new ArrayList<>();

        listaCompra.add(new Producto("2 docenas de huevos",false));
        listaCompra.add(new Producto("1 kg de patatas",false));
        listaCompra.add(new Producto("3 barras de pan",false));
        listaCompra.add(new Producto("1 queso burgos",false));
        listaCompra.add(new Producto("1 vino tinto",false));
        listaCompra.add(new Producto("1 pack brick de leche",false));

        final MyAdapter adaptador = new MyAdapter(this, listaCompra);

        listViewCompra = (ListView) findViewById(R.id.listViewCompra);
        listViewCompra.setAdapter(adaptador);

        listViewCompra.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Producto productoActual = listaCompra.get(position);

                if(productoActual.isAgregado()){
                    productoActual.setAgregado(false);
                }else{
                    productoActual.setAgregado(true);
                }

                adaptador.notifyDataSetChanged();
            }
        });


    }
}
