package com.example.happybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HealthcareMenu extends AppCompatActivity {
    
    private List<HealthCare> healthCareModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare_menu);

        healthCareModel = new ArrayList<>();
        healthCareModel.add(new HealthCare(R.drawable.mac));
        healthCareModel.add(new HealthCare(R.drawable.mac));
        healthCareModel.add(new HealthCare(R.drawable.mac));
        healthCareModel.add(new HealthCare(R.drawable.mac));
        healthCareModel.add(new HealthCare(R.drawable.laptop));
        healthCareModel.add(new HealthCare(R.drawable.laptop));
        healthCareModel.add(new HealthCare(R.drawable.laptop));
        healthCareModel.add(new HealthCare(R.drawable.mac));

        RecyclerView cRecyclerView = findViewById(R.id.healthCareRecyclerViewID);
        HealthCareAdapter healthCareAdapter = new HealthCareAdapter(this,healthCareModel);

        StaggeredGridLayoutManager cStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        cRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
        cRecyclerView.setAdapter(healthCareAdapter);

    }
}
