package com.example.happybuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {

    public ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        TabLayout tabLayout = findViewById(R.id.tabLayoutID);
        ViewPager2 viewPager = findViewById(R.id.viewPagerID);
//        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(new ViewPagerAdapter(this));
        //computer recycle

        //set text here
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:{
                        tab.setText("Computer");
//                        tab.setIcon(R.drawable.computer);
                        break;
                    }
                    case 1:{
                        tab.setText("Equipment");
//                        tab.setIcon(R.drawable.computer);
                        break;
                    }
                    case 2:{
                        tab.setText("Fashion");
//                        tab.setIcon(R.drawable.computer);
                        break;
                    }
                    case 3:{
                        tab.setText("Food");
//                        tab.setIcon(R.drawable.computer);
                        break;
                    }
                    case 4:{
                        tab.setText("Health Care");
//                        tab.setIcon(R.drawable.computer);
                        break;
                    }
                    case 5:{
                        tab.setText("Sports");
//                        tab.setIcon(R.drawable.computer);
                        break;
                    }
                }
            }
        }
        );
        tabLayoutMediator.attach();


//        computerRecyclerView.setAdapter(new ComputerAdapter(computerList));

//        computerRecyclerView.setLayoutManager(
//                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        );




        //Add Fragment here

//        viewPagerAdapter.AddFragment(new FragmentComputer(),"Computer");
//        viewPagerAdapter.AddFragment(new FragmentEquipment(),"Equipment");
//        viewPagerAdapter.AddFragment(new FragmentFashion(),"Fashion");
//        viewPagerAdapter.AddFragment(new FragmentFood(),"Food");
//        viewPagerAdapter.AddFragment(new FragmentHealthCare(),"Health Care");
//        viewPagerAdapter.AddFragment(new FragmentSport(),"Sports");


//        viewPager.setAdapter(new ViewPagerAdapter(this));
//        tabLayout.setupWithViewPager(viewPager);
//        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);

//        tabLayout.getTabAt(0).setIcon(R.drawable);


    }
}
