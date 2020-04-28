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

public class FashionMenu extends AppCompatActivity {
    
    private List<Fashion> fashionModel;
    private ImageView logoImageView,searchText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_menu);

        logoImageView = findViewById(R.id.imageViewLogo);

        searchText = findViewById(R.id.searchViewID);
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(FashionMenu.this, Search.class);
                startActivity(searchIntent);
                finish();

            }
        });



        logoImageView.setOnClickListener(new View.OnClickListener()

        {

            @Override

            public void onClick(View v){

                finish();

                Intent logoIntent = new Intent(FashionMenu.this, MainActivity.class);

                startActivity(logoIntent);

            }

        });


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
