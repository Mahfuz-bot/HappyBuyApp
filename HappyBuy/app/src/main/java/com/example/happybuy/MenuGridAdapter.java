package com.example.happybuy;

import android.content.Context;
import android.content.Intent;
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
    ItemClickListener itemClickListener;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.menuTitle.setText(mData.get(position).getTitle());
        holder.menuImage.setImageResource(mData.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mData.get(position).getTitle().equals("Computer")){

                    Intent cIntent = new Intent(mContext,ComputerMenu.class);
                    mContext.startActivity(cIntent);
                }
                 if(mData.get(position).getTitle().equals("Equipment")){

                                    Intent eIntent = new Intent(mContext,EquipmentMenu.class);
                                    mContext.startActivity(eIntent);
                                }
                 if(mData.get(position).getTitle().equals("Fashion")){

                                    Intent fIntent = new Intent(mContext,FashionMenu.class);
                                    mContext.startActivity(fIntent);
                                }
                 if(mData.get(position).getTitle().equals("Food")){

                                    Intent fdIntent = new Intent(mContext,FoodMenu.class);
                                    mContext.startActivity(fdIntent);
                                }
                 if(mData.get(position).getTitle().equals("HealthCare")){

                                    Intent hcIntent = new Intent(mContext,HealthcareMenu.class);
                                    mContext.startActivity(hcIntent);
                                }
                 if(mData.get(position).getTitle().equals("Sport")){

                                    Intent sIntent = new Intent(mContext,SportMenu.class);
                                    mContext.startActivity(sIntent);
                                }

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
