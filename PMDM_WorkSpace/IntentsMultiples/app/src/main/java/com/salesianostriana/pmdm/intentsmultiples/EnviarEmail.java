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

public class EnviarEmail extends Activity {
    //Declaramos y recogemos la asociación entre vistas y objetos java
    @Bind(R.id.editTextMessage)EditText editTextMessage;
    @Bind(R.id.editTextMailTo)EditText editTextMailTo;
    @Bind(R.id.editTextSubject)EditText editTextSubject;
    @Bind(R.id.imageButtonSendEmail)ImageButton imgBtnSendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_email);

        //Vinculamos todas las declaraciones a la clase
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enviar_email, menu);
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

    @OnClick(R.id.imageButtonSendEmail)
    public void sendEmail(View v){
        String [] adresses={editTextMailTo.getText().toString()};
        Intent i = new Intent(Intent.ACTION_SENDTO);
        //verificamos que solo las aplicaciones de email gestionen este intent
        i.setData(Uri.parse("mailto:"));
        //Pasamos una lista de emails encadenados en un array de String
        i.putExtra(Intent.EXTRA_EMAIL, adresses);
        i.putExtra(Intent.EXTRA_SUBJECT, editTextSubject.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString());
        startActivity(i);
    }

}
