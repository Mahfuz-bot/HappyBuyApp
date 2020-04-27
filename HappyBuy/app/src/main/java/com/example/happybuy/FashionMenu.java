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

public class FashionMenu extends AppCompatActivity {
    
    private List<Fashion> fashionModel;
    private ImageView logoImageView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_menu);

        logoImageView = findViewById(R.id.imageViewLogo);



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
