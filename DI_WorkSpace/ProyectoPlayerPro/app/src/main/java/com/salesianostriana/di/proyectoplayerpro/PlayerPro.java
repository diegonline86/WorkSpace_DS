package com.salesianostriana.di.proyectoplayerpro;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PlayerPro extends Activity implements View.OnClickListener{
    private ImageButton btnPlayPause;
    private boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_pro);

        clicked = true;
        btnPlayPause = (ImageButton)findViewById(R.id.btn_pause_play);
        btnPlayPause.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player, menu);
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
        if(clicked) {
            btnPlayPause.setBackgroundResource(R.drawable.pause);
            clicked = false;
        }else {
            btnPlayPause.setBackgroundResource(R.drawable.play);
            clicked = true;
        }

    }
}
