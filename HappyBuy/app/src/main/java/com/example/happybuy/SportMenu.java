package com.example.happybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SportMenu extends AppCompatActivity {
    
    private List<Sport> sportModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_menu);

        sportModel = new ArrayList<>();
        sportModel.add(new Sport(R.drawable.mac));
        sportModel.add(new Sport(R.drawable.mac));
        sportModel.add(new Sport(R.drawable.mac));
        sportModel.add(new Sport(R.drawable.mac));
        sportModel.add(new Sport(R.drawable.laptop));
        sportModel.add(new Sport(R.drawable.laptop));
        sportModel.add(new Sport(R.drawable.laptop));
        sportModel.add(new Sport(R.drawable.mac));

        RecyclerView cRecyclerView = findViewById(R.id.sportRecyclerViewID);
        SportAdapter sportAdapter = new SportAdapter(this,sportModel);

        StaggeredGridLayoutManager cStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        cRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
        cRecyclerView.setAdapter(sportAdapter);


    }
}
