package com.example.happybuy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MenuGridAdapter extends RecyclerView.Adapter<MenuGridAdapter.MyViewHolder> {


    private Context mContext;
    private List<HomeMenu> mData;

    public MenuGridAdapter(Context mContext, List<HomeMenu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.menu_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.menuTitle.setText(mData.get(position).getTitle());
        holder.menuImage.setImageResource(mData.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView menuTitle;
        ImageView menuImage;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            menuTitle = itemView.findViewById(R.id.menuTitleID);
            menuImage = itemView.findViewById(R.id.menuImageID);
            cardView = itemView.findViewById(R.id.menuMainID);
        }
    }
}
