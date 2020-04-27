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

public class FoodMenu extends AppCompatActivity {

    private List<Food> foodModel;
    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        logoImageView = findViewById(R.id.imageViewLogo);



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
