package com.salesianostrian.pmd.tema01_ejercicio01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("TRAZA MainActivity","Ha entrado en el método onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TRAZA MainActivity", "Ha entrado en el método onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TRAZA MainActivity", "Ha entrado en el método onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TRAZA MainActivity", "Ha entrado en el método onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TRAZA MainActivity", "Ha entrado en el método onDestroy");
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

    public void mensaje(View v){
        Intent i = new Intent(this, MensajeActivity.class);
        startActivity(i);
    }
}
