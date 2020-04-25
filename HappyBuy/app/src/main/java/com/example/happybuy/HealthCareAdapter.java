package com.example.happybuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class HealthCareAdapter extends RecyclerView.Adapter<HealthCareAdapter.PostViewHolder> {


    private Context cContext;
    private List<HealthCare> healthCareList;

    public HealthCareAdapter(Context cContext ,List<HealthCare> healthCareList) {
        this.cContext = cContext;
        this.healthCareList = healthCareList;
    }

    @NonNull
    @Override
    public HealthCareAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater cLayoutInflater = LayoutInflater.from(cContext);
        view = cLayoutInflater.inflate(R.layout.computer_sample,parent,false);


        return new HealthCareAdapter.PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HealthCareAdapter.PostViewHolder holder, int position) {
        holder.setPostImage(healthCareList.get(position));
    }

    @Override
    public int getItemCount() {
        return healthCareList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView postImageView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.computerLayoutID);

        }
        void setPostImage(HealthCare healthCare){
            postImageView.setImageResource(healthCare.getImage());
        }
    }
}
