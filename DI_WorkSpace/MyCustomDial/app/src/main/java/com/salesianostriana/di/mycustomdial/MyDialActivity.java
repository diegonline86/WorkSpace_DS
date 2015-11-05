package com.salesianostriana.di.mycustomdial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyDialActivity extends Activity implements View.OnClickListener{
    private TextView textViewDial;
    private Button btn_del,btn_one,btn_two,btn_three,
            btn_four,btn_five,btn_six,btn_seven,
            btn_eight,btn_nine,btn_zero,btn_asterisk,btn_pad,btn_call;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dial);

        textViewDial = (TextView)findViewById(R.id.textViewDialer);
        btn_del = (Button)findViewById(R.id.button_del);
        btn_one = (Button)findViewById(R.id.button_one);
        btn_two = (Button)findViewById(R.id.button_two);
        btn_three = (Button)findViewById(R.id.button_three);
        btn_four = (Button)findViewById(R.id.button_four);
        btn_five = (Button)findViewById(R.id.button_five);
        btn_six = (Button)findViewById(R.id.button_six);
        btn_seven = (Button)findViewById(R.id.button_seven);
        btn_eight = (Button)findViewById(R.id.button_eight);
        btn_nine = (Button)findViewById(R.id.button_nine);
        btn_zero = (Button)findViewById(R.id.button_zero);
        btn_pad = (Button)findViewById(R.id.button_pad);
        btn_asterisk = (Button)findViewById(R.id.button_asterisk);
        btn_call = (Button)findViewById(R.id.button_call);

        btn_del.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_asterisk.setOnClickListener(this);
        btn_pad.setOnClickListener(this);
        btn_call.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle numero = intent.getExtras();

        if(numero != null){
            textViewDial.setText(numero.getString("tel"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_dial, menu);
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
        String dial = textViewDial.getText().toString();

        switch (v.getId()){
            case R.id.button_del:
                if(!textViewDial.getText().toString().isEmpty()) {
                    textViewDial.setText(dial.substring(0, dial.length() - 1));
                }
                break;
            case R.id.button_one:
                textViewDial.setText(dial.concat("1"));
                break;
            case R.id.button_two:
                textViewDial.setText(dial.concat("2"));
                break;
            case R.id.button_three:
                textViewDial.setText(dial.concat("3"));
                break;
            case R.id.button_four:
                textViewDial.setText(dial.concat("4"));
                break;
            case R.id.button_five:
                textViewDial.setText(dial.concat("5"));
                break;
            case R.id.button_six:
                textViewDial.setText(dial.concat("6"));
                break;
            case R.id.button_seven:
                textViewDial.setText(dial.concat("7"));
                break;
            case R.id.button_eight:
                textViewDial.setText(dial.concat("8"));
                break;
            case R.id.button_nine:
                textViewDial.setText(dial.concat("9"));
                break;
            case R.id.button_zero:
                textViewDial.setText(dial.concat("0"));
                break;
            case R.id.button_asterisk:
                textViewDial.setText(dial.concat("*"));
                break;
            case R.id.button_pad:
                textViewDial.setText(dial.concat("#"));
                break;
            case R.id.button_call:
                Toast.makeText(this,"Llamando...",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
