package com.salesianostriana.ad.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Welcome extends Activity {
    SharedPreferences prefs;
    SharedPreferences.Editor editPrefs;
    CheckBox ckCheckBoxStillRemind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editPrefs = prefs.edit();
        ckCheckBoxStillRemind = (CheckBox) findViewById(R.id.checkBoxStillRemind);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
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
    public void onBackPressed() {
        super.onBackPressed();
        if(ckCheckBoxStillRemind.isChecked()){
            //Si no queremos ser recordados
            //Borramos la preferencia
            editPrefs.remove(Login.user);
            editPrefs.remove(Login.pass);
        }
    }
}
