package com.salesianostriana.di.toastmejorado;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ToastMejorado extends Activity implements View.OnClickListener{
    private EditText editTextName,editTextAge;
    private Button btn_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_mejorado);
        btn_toast = (Button)findViewById(R.id.button_toast);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextAge = (EditText)findViewById(R.id.editTextAge);

        btn_toast.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toast_mejorado, menu);
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
        String nombre = editTextName.getText().toString();
        int edad = Integer.valueOf(editTextAge.getText().toString());

        if(nombre.isEmpty())
            Toast.makeText(this,"No sé como te llamas",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Hola "+nombre,Toast.LENGTH_LONG).show();

        if(edad<18)
            Toast.makeText(this,"Eres un yogurín",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Qué puretilla",Toast.LENGTH_SHORT).show();

    }
}
