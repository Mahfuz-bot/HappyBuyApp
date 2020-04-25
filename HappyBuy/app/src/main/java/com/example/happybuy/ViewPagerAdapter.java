package com.example.happybuy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private  final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentComputer();
            case 1:
                return new FragmentEquipment();
            case 2:
                return new FragmentFashion();
            case 3:
                return new FragmentFood();
            case 4:
                return new FragmentHealthCare();
            case 5:
                return new FragmentSport();
        }
        return null;
    }
    @Override
    public int getItemCount() {
        return 6;
    }
}
