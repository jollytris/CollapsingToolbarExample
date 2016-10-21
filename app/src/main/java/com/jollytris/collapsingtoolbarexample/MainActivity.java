package com.jollytris.collapsingtoolbarexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jollytris.collapsingtoolbarexample.recyclerview.RecyclerData;
import com.jollytris.collapsingtoolbarexample.recyclerview.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setContentInsetsAbsolute(0, 0);

        RecyclerViewAdapter adp = new RecyclerViewAdapter();
        for (int i = 0; i < 100; i++) {
            adp.add(new RecyclerData(i + ""));
        }
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adp);
    }
}
