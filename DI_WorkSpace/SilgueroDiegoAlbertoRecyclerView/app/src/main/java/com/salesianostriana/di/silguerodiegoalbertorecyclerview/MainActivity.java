package com.salesianostriana.di.silguerodiegoalbertorecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        final List<ItemCiudad> listCiudad = new ArrayList<>();
        listCiudad.add(new ItemCiudad(2890151, "Buenos Aires", 4, true));
        listCiudad.add(new ItemCiudad(3207247, "Madrid", 5, true));
        listCiudad.add(new ItemCiudad(92221,"Soria", 3, false));


        mAdapter = new CiudadAdapter(listCiudad);

        mRecyclerView.setAdapter(mAdapter);

    }
}
