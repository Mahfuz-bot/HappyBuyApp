package com.example.happybuy;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class EquipmentAdapter extends RecyclerView.Adapter<EquipmentAdapter.PostViewHolder> {


    private Context cContext;
    private List<Equipment> equipmentList;

    public EquipmentAdapter(Context cContext ,List<Equipment> equipmentList) {
        this.cContext = cContext;
        this.equipmentList = equipmentList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater cLayoutInflater = LayoutInflater.from(cContext);
        view = cLayoutInflater.inflate(R.layout.computer_sample,parent,false);


        return new PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setPostImage(equipmentList.get(position));
    }

    @Override
    public int getItemCount() {
        return equipmentList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView postImageView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.computerLayoutID);

        }
        void setPostImage(Equipment equipment){
            postImageView.setImageResource(equipment.getImage());
        }
    }

}
