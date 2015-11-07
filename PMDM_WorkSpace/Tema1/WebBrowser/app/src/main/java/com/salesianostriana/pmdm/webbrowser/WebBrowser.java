package com.salesianostriana.pmdm.webbrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebBrowser extends Activity implements View.OnClickListener{
    @Bind(R.id.webViewBrowser) WebView myWebBrowser;
    @Bind(R.id.editTextSearchBar) EditText editTextSearchBar;
    @Bind(R.id.imgBtnSearchWeb) ImageButton imgBtnSearchWeb;
    @Bind(R.id.imgBtnBookMark) ImageButton imgBtnBookMark;
    @Bind(R.id.imgBtnBookmarkSaved) ImageButton imgBtnSavedBookmars;
    AlertDialog.Builder builderBookMarks;
    List<String> listBookmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);

        //Vinculamos todas las declaraciones Bind a la clase
        ButterKnife.bind(this);

        listBookmarks = new ArrayList<>();
        //Construimos un Dialog que preguntará al usuario si desea añadir a favoritos el URL
        builderBookMarks = new AlertDialog.Builder(this);
        builderBookMarks.setTitle("Favoritos");
        builderBookMarks.setMessage("¿Guardar en favoritos?");

        //Aquí asignamos un WebClient que se encargará de mostrar el URL dentro de nuestro WebView
        myWebBrowser.setWebViewClient(new MyWebClient());
        myWebBrowser.getSettings().setJavaScriptEnabled(true);

        //Definimos los botones del Dialog Favoritos
        builderBookMarks.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Guardamos la dirección web dentro de la colección de URL
                listBookmarks.add(editTextSearchBar.getText().toString());
            }
        });
        builderBookMarks.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //Destruimos el Dialog
                dialog.cancel();
            }
        });

        //Comprobamos que un intent implícito nos envie una URL en su Data
        if(getIntent().getData()!=null){
            editTextSearchBar.setText(getIntent().getData().toString());
            imgBtnSearchWeb.performClick();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_browser, menu);
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

    //Asignación de multiples Id a un unico método OnClick
    @OnClick({R.id.imgBtnBookMark,R.id.imgBtnBookmarkSaved,R.id.imgBtnSearchWeb})
    public void onClick(View v) {
        String webAdrees = editTextSearchBar.getText().toString();
        StringBuilder strB = new StringBuilder();
        Intent i = new Intent(this,BookMarks.class);

        switch (v.getId()){
            case R.id.imgBtnSearchWeb:
                //Comprobamos si la URL comienza por http://
                if(webAdrees.startsWith("http://"))
                    myWebBrowser.loadUrl(webAdrees);
                else {
                    //En caso contrario lo concatenamos al inicio de la URL
                    myWebBrowser.loadUrl("http://" + webAdrees);
                    //y refrescamos la barra de navegación
                    editTextSearchBar.setText("http://" + webAdrees);
                }
                break;
            case R.id.imgBtnBookMark:
                builderBookMarks.show();
                break;
            case R.id.imgBtnBookmarkSaved:
                for(String e:listBookmarks){
                    strB.append(e + "\n");
                }
                i.setData(Uri.parse(strB.toString()));
                startActivity(i);
                break;

        }
    }
}
