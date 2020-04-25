package com.example.happybuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.PostViewHolder> {
    private Context cContext;
    private List<Sport> sportList;

    public SportAdapter(Context cContext ,List<Sport> sportList) {
        this.cContext = cContext;
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater cLayoutInflater = LayoutInflater.from(cContext);
        view = cLayoutInflater.inflate(R.layout.computer_sample,parent,false);


        return new SportAdapter.PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.PostViewHolder holder, int position) {
        holder.setPostImage(sportList.get(position));
    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView postImageView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.computerLayoutID);

        }
        void setPostImage(Sport sport){
            postImageView.setImageResource(sport.getImage());
        }
    }
}
