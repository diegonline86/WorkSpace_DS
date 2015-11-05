package com.salesianostriana.pmdm.testwebbrowser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TestWebBrowser extends Activity implements View.OnClickListener{
    Button btnGoWebAndroid;
    Button btnGoWebXataka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web_browser);

        btnGoWebAndroid = (Button)findViewById(R.id.btnGoWebAndroid);
        btnGoWebXataka = (Button) findViewById(R.id.btnGoWebXataka);

        btnGoWebXataka.setOnClickListener(this);
        btnGoWebAndroid.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_web_browser, menu);
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
        Intent i;
        switch (v.getId()){
            case R.id.btnGoWebAndroid:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.android.com"));
                startActivity(i);
                break;
            case R.id.btnGoWebXataka:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.xataka.com"));
                startActivity(i);
                break;
        }
    }
}
