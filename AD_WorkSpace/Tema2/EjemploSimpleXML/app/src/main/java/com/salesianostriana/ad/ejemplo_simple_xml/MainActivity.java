package com.salesianostriana.ad.ejemplo_simple_xml;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.StringWriter;

public class MainActivity extends Activity {

    TextView text, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);

        Serializer serializer = new Persister();
        Example example = new Example("Miarma",1);
        StringWriter writer = new StringWriter();

        try {
            serializer.write(example,writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

        text.setText(writer.toString());

        Example example2 = null;
        String xml = writer.toString();
        try {
            example2 = serializer.read(Example.class,xml);
        } catch (Exception e) {
            e.printStackTrace();
        }


        text2.setText(example2.toString());

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
}
