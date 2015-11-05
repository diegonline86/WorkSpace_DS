package com.salesianostriana.di.listviewllamadas;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<RegistroLlamada> listCallRegister = new ArrayList<>();

        listCallRegister.add(new RegistroLlamada("+919008113781", new GregorianCalendar(2015,1,23,11,51),363000,0));
        listCallRegister.add(new RegistroLlamada("+919008123489", new GregorianCalendar(2015,1,23,6,12), 60000,1));
        listCallRegister.add(new RegistroLlamada("+919008116896", new GregorianCalendar(2015,1,22,10,30),0, 2));

        CallRegistryAdapter adapter = new CallRegistryAdapter(this,listCallRegister);

        setListAdapter(adapter);
    }
}
