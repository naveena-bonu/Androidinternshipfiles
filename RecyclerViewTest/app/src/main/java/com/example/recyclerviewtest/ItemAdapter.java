package com.example.recyclerviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyviewHolder> {
    Context ct;
    int[] myImages;
    String[] myNames,myPrices;

    public ItemAdapter(MainActivity mainActivity, int[] images, String[] itemnames, String[] price) {
        ct= mainActivity;

        myImages=images;
        myNames=itemnames;
        myPrices=price;
    }

    @NonNull
    @org.jetbrains.annotations.Notnull
    @Override
    public ItemAdapter.MyviewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.item_row,parent,false);
       MyviewHolder holder= new MyviewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ItemAdapter.MyviewHolder holder, int position) {
    holder.iv.setImageResource(myImages[position]);
    holder.tv1.setText(myNames[position]);
    holder.tv2.setText(myPrices[position]);
    holder.button.setOnClickListener(new ElegantNumberButton.OnClickListener()){
        public void onClick(View view){
            String num=holder.button.getNumber
            }
        }
    }

    @Override
    public int getItemCount() {
        return myImages.length;//returns count of items to view
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            TextView tv1,tv2;
        public MyviewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            iv= itemView.findViewById(R.id.itemimage);
            tv1=itemView.findViewById(R.id.item_name);
            tv2 = itemView.findViewById(R.id.item_price);
        }
    }
}
