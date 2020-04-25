package com.example.happybuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.PostViewHolder> {

    private Context cContext;
    private  List<Computer> computerList;

    public ComputerAdapter(Context cContext ,List<Computer> computerList) {
        this.cContext = cContext;
        this.computerList = computerList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater cLayoutInflater =LayoutInflater.from(cContext);
        view = cLayoutInflater.inflate(R.layout.computer_sample,parent,false);


        return new PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.setPostImage(computerList.get(position));
    }

    @Override
    public int getItemCount() {
        return computerList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView postImageView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.computerLayoutID);

        }
        void setPostImage(Computer computer){
            postImageView.setImageResource(computer.getImage());
        }
    }

}
