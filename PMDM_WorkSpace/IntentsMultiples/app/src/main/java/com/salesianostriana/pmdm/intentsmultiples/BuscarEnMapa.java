package com.salesianostriana.pmdm.intentsmultiples;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuscarEnMapa extends Activity {
    //Declaramos y recogemos la asociación entre vistas y objetos java
    @Bind(R.id.editTextAdress)EditText editTextAdress;
    @Bind(R.id.imageButtonSearchMAp)ImageButton imageButtonSearchMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_en_mapa);

        //Vinculamos todas las declaraciones a la clase
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buscar_en_mapa, menu);
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

    @OnClick(R.id.imageButtonSearchMAp)
    public void searchMap(View v){
        //Fiajamos la dirección de busqueda en el Uri
        //Al ser una dirección exacta los parametros de altitud y latitud se quedan en cero
        Uri uri = Uri.parse("geo:0,0?q="+editTextAdress.getText().toString());
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        //Especificamos el paquete de google maps que manejará el intent
        i.setPackage("com.google.android.apps.maps");
        startActivity(i);
    }
}
