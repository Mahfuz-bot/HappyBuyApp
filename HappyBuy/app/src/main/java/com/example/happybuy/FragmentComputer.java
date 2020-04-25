package com.example.happybuy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class FragmentComputer extends Fragment {

    View v;
    private List<Computer> computerModel;

    public FragmentComputer() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.computer_fragment,container,false);
        RecyclerView cRecyclerView = v.findViewById(R.id.computerRecyclerViewID);
        ComputerAdapter computerAdapter = new ComputerAdapter(getContext(),computerModel);

        StaggeredGridLayoutManager cStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        cRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
        cRecyclerView.setAdapter(computerAdapter);

//        //computer list
//        ComputerAdapter computerAdapter = new ComputerAdapter(this,computerModel);
//        computerRecyclerView.setLayoutManager(cStaggeredGridLayoutManager);
//        computerRecyclerView.setAdapter(computerAdapter);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.computer_fragment);

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
    }
}
