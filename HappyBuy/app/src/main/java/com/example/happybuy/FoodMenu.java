package com.example.happybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FoodMenu extends AppCompatActivity {

    private List<Food> foodModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

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
