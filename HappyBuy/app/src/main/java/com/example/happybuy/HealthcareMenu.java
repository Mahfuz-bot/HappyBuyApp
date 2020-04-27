package com.example.happybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class HealthcareMenu extends AppCompatActivity {
    
    private List<HealthCare> healthCareModel;
    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare_menu);

        logoImageView = findViewById(R.id.imageViewLogo);



        logoImageView.setOnClickListener(new View.OnClickListener()

        {

            @Override

            public void onClick(View v){

                finish();

                Intent logoIntent = new Intent(HealthcareMenu.this, MainActivity.class);

                startActivity(logoIntent);

            }

        });


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
