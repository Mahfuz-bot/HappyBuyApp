package com.example.happybuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.PostViewHolder> {


    private Context cContext;
    private List<Fashion> fashionList;

    public FashionAdapter(Context cContext ,List<Fashion> fashionList) {
        this.cContext = cContext;
        this.fashionList = fashionList;
    }

    @NonNull
    @Override
    public FashionAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater cLayoutInflater = LayoutInflater.from(cContext);
        view = cLayoutInflater.inflate(R.layout.computer_sample,parent,false);


        return new FashionAdapter.PostViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FashionAdapter.PostViewHolder holder, int position) {
        holder.setPostImage(fashionList.get(position));
    }

    @Override
    public int getItemCount() {
        return fashionList.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView postImageView;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImageView = itemView.findViewById(R.id.computerLayoutID);

        }
        void setPostImage(Fashion fashion){
            postImageView.setImageResource(fashion.getImage());
        }
    }


}
