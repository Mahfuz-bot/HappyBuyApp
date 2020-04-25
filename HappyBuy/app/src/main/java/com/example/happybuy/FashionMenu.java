package com.example.happybuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FashionMenu extends AppCompatActivity {
    
    private List<Fashion> fashionModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_menu);

        fashionModel = new ArrayList<>();
        fashionModel.add(new Fashion(R.drawable.mac));
        fashionModel.add(new Fashion(R.drawable.mac));
        fashionModel.add(new Fashion(R.drawable.mac));
        fashionModel.add(new Fashion(R.drawable.mac));
        fashionModel.add(new Fashion(R.drawable.laptop));
        fashionModel.add(new Fashion(R.drawable.laptop));
        fashionModel.add(new Fashion(R.drawable.laptop));
        fashionModel.add(new Fashion(R.drawable.mac));

        RecyclerView cRecyclerView = findViewById(R.id.fashionRecyclerViewID);
        FashionAdapter fashionAdapter = new FashionAdapter(this,fashionModel);

        StaggeredGridLayoutManager cStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        cRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
        cRecyclerView.setAdapter(fashionAdapter);

    }
}
