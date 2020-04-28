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

public class EquipmentMenu extends AppCompatActivity {

    private List<Equipment> equipmentModel;
    private ImageView logoImageView, searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_menu);
        searchText = findViewById(R.id.searchViewID);
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent = new Intent(EquipmentMenu.this, Search.class);
                startActivity(searchIntent);
                finish();
            }
        });


        logoImageView = findViewById(R.id.imageViewLogo);



        logoImageView.setOnClickListener(new View.OnClickListener()

        {

            @Override

            public void onClick(View v){

                finish();

                Intent logoIntent = new Intent(EquipmentMenu.this, MainActivity.class);

                startActivity(logoIntent);

            }

        });


        equipmentModel = new ArrayList<>();
        equipmentModel.add(new Equipment(R.drawable.mac));
        equipmentModel.add(new Equipment(R.drawable.mac));
        equipmentModel.add(new Equipment(R.drawable.mac));
        equipmentModel.add(new Equipment(R.drawable.mac));
        equipmentModel.add(new Equipment(R.drawable.laptop));
        equipmentModel.add(new Equipment(R.drawable.laptop));
        equipmentModel.add(new Equipment(R.drawable.laptop));
        equipmentModel.add(new Equipment(R.drawable.mac));

        RecyclerView cRecyclerView = findViewById(R.id.equipmentRecyclerViewID);
        EquipmentAdapter equipmentAdapter = new EquipmentAdapter(this,equipmentModel);

        StaggeredGridLayoutManager cStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        cRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
        cRecyclerView.setAdapter(equipmentAdapter);



    }
}
