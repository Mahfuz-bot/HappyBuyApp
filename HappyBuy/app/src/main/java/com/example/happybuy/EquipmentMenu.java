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

public class EquipmentMenu extends AppCompatActivity {

    private List<Equipment> equipmentModel;
    private ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_menu);


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
