package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class
ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private ArrayList<uploadinfo> imageList;

    public ImageAdapter(ArrayList<uploadinfo> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    private Context context;
    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        // loading the images from the position

        holder.desc.setText(imageList.get(position).getImageName());
        //Glide.with(showallimages.this).load(imageList.get(position).getImageURL()).dontAnimate().into(holder.imageView);
        System.out.println(imageList.get(position).getImageURL());
        Glide.with(holder.itemView.getContext()).load(imageList.get(position).getImageURL()).into(holder.imageView);

        //Picasso.get().load(imageList.get(position).getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desc = (TextView) itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.item);
        }
    }
}
