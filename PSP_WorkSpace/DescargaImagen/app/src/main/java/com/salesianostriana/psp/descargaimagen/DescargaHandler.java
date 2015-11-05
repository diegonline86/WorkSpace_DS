package com.salesianostriana.psp.descargaimagen;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class DescargaHandler extends Activity {
    Button btnDownload;
    ImageView imageViewHandler;
    ProgressDialog progressDialog;
    Bitmap img;

    //Clase Handler
    Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int progreso = (int) msg.obj;
            int TAM = img.getByteCount()/1024;
            progressDialog.setProgress(progreso);
                if (progreso == TAM) {
                    progressDialog.dismiss();
                    imageViewHandler.setImageBitmap(img);
                    Toast.makeText(DescargaHandler.this, "TAMAÑO DE IMAGEN: "+TAM+"Kb", Toast.LENGTH_SHORT).show();
                }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descarga_handler);


        btnDownload = (Button) findViewById(R.id.btnDownloadHandler);
        final EditText editTextUrlHandler = (EditText) findViewById(R.id.editTextDownloadHandler);
        imageViewHandler = (ImageView) findViewById(R.id.imageViewPhotoHandler);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(DescargaHandler.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMessage("Descargando...");
                progressDialog.setProgress(0);
                progressDialog.setCancelable(false);
                progressDialog.show();

                //Tarea en segundo plano
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Capturamos la imagen descargada
                        img = Utiles.descargarImagen(editTextUrlHandler.getText().toString());
                        //Contamos el tamaño en kilobytes
                        int TAM = img.getByteCount()/1024;
                        progressDialog.setMax(TAM);

                        for(int i = 1; i<=TAM; i++){
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            int contador = i;

                            //Enviamos cada número por mensaje
                            Message m2 = new Message();
                            m2.obj = contador;
                            myHandler.sendMessage(m2);
                        }
                    }
                }).start();


                //Toast.makeText(DescargaHandler.this,"Tamaño imagen: "+ String.valueOf(img.getByteCount()/1024)+" Kb", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_descarga_handler, menu);
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
