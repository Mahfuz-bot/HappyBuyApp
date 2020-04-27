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

public class ComputerMenu extends AppCompatActivity {


    private List<Computer> computerModel;
    private ImageView logoImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_menu);

        logoImageView = findViewById(R.id.imageViewLogo);

        logoImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                finish();
                Intent logoIntent = new Intent(ComputerMenu.this, MainActivity.class);
                startActivity(logoIntent);
            }
        });

        computerModel = new ArrayList<>();
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.see));
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.see));
        computerModel.add(new Computer(R.drawable.see));
        computerModel.add(new Computer(R.drawable.mac));
        computerModel.add(new Computer(R.drawable.laptop));
        computerModel.add(new Computer(R.drawable.laptop));
        computerModel.add(new Computer(R.drawable.laptop));
        computerModel.add(new Computer(R.drawable.mac));

        RecyclerView cRecyclerView = findViewById(R.id.computerRecyclerViewID);
        ComputerAdapter computerAdapter = new ComputerAdapter(this,computerModel);

        StaggeredGridLayoutManager cStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        cRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
        cRecyclerView.setAdapter(computerAdapter);




    }
}
