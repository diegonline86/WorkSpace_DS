package com.salesianostriana.ad.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Login extends Activity {
    EditText editTextUser, editTextPass;
    CheckBox checkBoxRemind;
    Button btn_login;
    SharedPreferences prefs;
    SharedPreferences.Editor prefsEdit;
    public static final String user= "diego", pass ="123498";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPass = (EditText) findViewById(R.id.editTextPassword);
        checkBoxRemind = (CheckBox) findViewById(R.id.checkBoxRemindUserPass);
        btn_login = (Button) findViewById(R.id.btn_login);

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        prefsEdit = prefs.edit();

        if(!prefs.getString("user",user).isEmpty() &&
                !prefs.getString("password",pass).isEmpty()){
            Intent i = new Intent(Login.this, Welcome.class);
            startActivity(i);
            finish();
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxRemind.isChecked()){
                    //Comprobamos si ya estan guardadas los nombres de usuario y contraseña
                    //En caso contrario
                    //Guardamos el usuario en un nuevo elemento de la preferencia
                    prefsEdit.putString("user", editTextUser.getText().toString());
                    prefsEdit.putString("password", editTextPass.getText().toString());
                    prefsEdit.commit();
                }

                Intent i = new Intent(Login.this, Welcome.class);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
