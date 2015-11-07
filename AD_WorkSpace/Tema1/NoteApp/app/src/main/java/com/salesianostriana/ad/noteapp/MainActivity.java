package com.salesianostriana.ad.noteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends Activity {

    final int FILE_CHOOSER = 1;

    Button btn_abrir, btn_guardar;
    String filePathSelected;
    EditText editTextFileName,editTextFileContent;
    OutputStreamWriter oStrW;
    BufferedReader bffR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_abrir = (Button) findViewById(R.id.btn_abrir);
        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        editTextFileName = (EditText) findViewById(R.id.editTextFileName);
        editTextFileContent = (EditText) findViewById(R.id.editTextFileContent);

        btn_abrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FileChooser.class);
                ArrayList<String> extensions = new ArrayList<String>();
                extensions.add(".txt");
                intent.putStringArrayListExtra("filterFileExtension", extensions);
                startActivityForResult(intent, FILE_CHOOSER);

            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Obtenemos la ruta de la tarjeta SD
                    File ruta_sd = Environment.getExternalStorageDirectory();
                    File f = new File(ruta_sd.getPath(),editTextFileName.getText().toString());
                    oStrW = new OutputStreamWriter(
                                        new FileOutputStream(f));

                    oStrW.write(editTextFileContent.getText().toString());
                    Toast.makeText(MainActivity.this, "Guardado "+f.getName(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    if(oStrW != null) {
                        try {
                            oStrW.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == FILE_CHOOSER) && (resultCode == -1)) {
            String fileSelected = data.getStringExtra("fileSelected");
            filePathSelected = fileSelected;
            Toast.makeText(this, fileSelected, Toast.LENGTH_SHORT).show();

            File f = new File(filePathSelected);
            //Leemos el fichero capturado
            String c;
            StringBuilder strBuilder= new StringBuilder();

                try {
                    bffR = new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(f)));

                    while((c = bffR.readLine()) != null){
                        strBuilder.append(c);
                    }

                    editTextFileContent.setText(strBuilder.toString());
                    editTextFileName.setText(f.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(bffR != null){
                        try {
                            bffR.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}
