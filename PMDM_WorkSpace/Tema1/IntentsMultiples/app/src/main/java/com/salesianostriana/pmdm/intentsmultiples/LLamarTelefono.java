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

public class LLamarTelefono extends Activity {
    //Declaramos y recogemos la asociación entre vistas y objetos java
    @Bind(R.id.editTextCallPhone)EditText editTextCallPhone;
    @Bind(R.id.imageButtonCallPhone)ImageButton imageButtonCallPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llamar_telefono);

        //Vinculamos todas las declaraciones a la clase
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_llamar_telefono, menu);
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

    @OnClick(R.id.imageButtonCallPhone)
    public void dialPhone(View v){
        Uri uri = Uri.parse("tel:"+editTextCallPhone.getText().toString());
        Intent i = new Intent(Intent.ACTION_DIAL,uri);
        i.setData(uri);
        startActivity(i);
    }
}
