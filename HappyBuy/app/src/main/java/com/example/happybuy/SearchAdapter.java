package com.example.happybuy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    List<SearchModel> modelList;
    ArrayList<SearchModel> arrayList;

    public SearchAdapter(Context context, List<SearchModel> modelList) {
        this.mContext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(modelList);
    }

    public  class  ViewHolder {

        TextView mTitle;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return modelList.size();
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_items,null);
            holder.mTitle = view.findViewById(R.id.itemName);

            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();

        }
        holder.mTitle.setText(modelList.get(position).getTitle());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(modelList.get(position).getTitle().equals("Computer")){

                    Intent cIntent = new Intent(mContext,ComputerMenu.class);
                    mContext.startActivity(cIntent);
                }
                if(modelList.get(position).getTitle().equals("Equipment")){

                    Intent eIntent = new Intent(mContext,EquipmentMenu.class);
                    mContext.startActivity(eIntent);
                }
                if(modelList.get(position).getTitle().equals("Fashion")){

                    Intent fIntent = new Intent(mContext,FashionMenu.class);
                    mContext.startActivity(fIntent);
                }
                if(modelList.get(position).getTitle().equals("Food")){

                    Intent fdIntent = new Intent(mContext,FoodMenu.class);
                    mContext.startActivity(fdIntent);
                }
                if(modelList.get(position).getTitle().equals("HealthCare")){

                    Intent hcIntent = new Intent(mContext,HealthcareMenu.class);
                    mContext.startActivity(hcIntent);
                }
                if(modelList.get(position).getTitle().equals("Sport")){

                    Intent sIntent = new Intent(mContext,SportMenu.class);
                    mContext.startActivity(sIntent);
                }
            }
        });

        return view;
    }
    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if(charText.length()==0){
            modelList.addAll(arrayList);
        }else{
            for(SearchModel searchModel: arrayList){
                if(searchModel.getTitle().toLowerCase(Locale.getDefault()).contains(charText)){
                    modelList.add(searchModel);
                }
            }
        }
        notifyDataSetChanged();
    }
}
