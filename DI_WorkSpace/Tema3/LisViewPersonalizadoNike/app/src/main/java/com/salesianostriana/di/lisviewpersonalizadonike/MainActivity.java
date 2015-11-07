package com.salesianostriana.di.lisviewpersonalizadonike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.listViewWorkouts);

        final ArrayList<EjercicioGimnasio> listEjercicios = new ArrayList<>();

        listEjercicios.add(new EjercicioGimnasio("SWEAT + SHAPE",30));
        listEjercicios.add(new EjercicioGimnasio("SLIM CHANCE",30));
        listEjercicios.add(new EjercicioGimnasio("FIGHTER FIT",30));
        listEjercicios.add(new EjercicioGimnasio("JUMP STAR",30));
        listEjercicios.add(new EjercicioGimnasio("HURRICANE",45));
        listEjercicios.add(new EjercicioGimnasio("CRUNCH + BURN",45));
        listEjercicios.add(new EjercicioGimnasio("CARDIO SURGE",45));

        final WorkoutAdapter adapter = new WorkoutAdapter(this,listEjercicios);

        myListView.setAdapter(adapter);
    }
}
