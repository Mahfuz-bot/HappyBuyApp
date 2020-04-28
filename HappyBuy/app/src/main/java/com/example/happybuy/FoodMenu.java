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

public class FoodMenu extends AppCompatActivity {

    private List<Food> foodModel;
    private ImageView logoImageView, searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        logoImageView = findViewById(R.id.imageViewLogo);
        searchText = findViewById(R.id.searchViewID);
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(FoodMenu.this, Search.class);
                startActivity(searchIntent);
                finish();

            }
        });



        logoImageView.setOnClickListener(new View.OnClickListener()

        {

            @Override

            public void onClick(View v){

                finish();

                Intent logoIntent = new Intent(FoodMenu.this, MainActivity.class);

                startActivity(logoIntent);

            }

        });



        foodModel = new ArrayList<>();
        foodModel.add(new Food(R.drawable.mac));
        foodModel.add(new Food(R.drawable.mac));
        foodModel.add(new Food(R.drawable.mac));
        foodModel.add(new Food(R.drawable.mac));
        foodModel.add(new Food(R.drawable.laptop));
        foodModel.add(new Food(R.drawable.laptop));
        foodModel.add(new Food(R.drawable.laptop));
        foodModel.add(new Food(R.drawable.mac));

        RecyclerView cRecyclerView = findViewById(R.id.foodRecyclerViewID);
        FoodAdapter foodAdapter = new FoodAdapter(this,foodModel);

        StaggeredGridLayoutManager cStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        cRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
        cRecyclerView.setAdapter(foodAdapter);

    }
}
