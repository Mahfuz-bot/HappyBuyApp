package com.example.happybuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.PostViewHolder> {

    private Context cContext;
    private List<Food> foodList;

    public FoodAdapter(Context cContext ,List<Food> foodList) {
        this.cContext = cContext;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater cLayoutInflater = LayoutInflater.from(cContext);
        view = cLayoutInflater.inflate(R.layout.computer_sample,parent,false);


        return new FoodAdapter.PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.PostViewHolder holder, int position) {
        holder.setPostImage(foodList.get(position));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView postImageView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.computerLayoutID);

        }
        void setPostImage(Food food){
            postImageView.setImageResource(food.getImage());
        }
    }


}
