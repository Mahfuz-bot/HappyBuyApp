package com.example.happybuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class SportMenu extends AppCompatActivity {
    
    private List<Sport> sportModel;
    private ImageView logoImageView,searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_menu);

        logoImageView = findViewById(R.id.imageViewLogo);
        searchText = findViewById(R.id.searchViewID);
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(SportMenu.this, Search.class);
                startActivity(searchIntent);
                finish();

            }
        });



        logoImageView.setOnClickListener(new View.OnClickListener()

        {

            @Override

            public void onClick(View v){

                finish();

                Intent logoIntent = new Intent(SportMenu.this, MainActivity.class);

                startActivity(logoIntent);

            }

        });


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
