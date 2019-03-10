package com.dsc.android.bootcamp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context context;
    private LayoutInflater layoutInflater;
    private List<RecyclerViewData> recyclerViewDataList = new ArrayList<>();

    public void setRecyclerViewDataList(List<RecyclerViewData> recyclerViewDataList) {
        this.recyclerViewDataList = recyclerViewDataList;
    }

    //constructor
    public RecyclerViewAdapter(Context context) {
        this.context = context;
        layoutInflater =LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //return null; Need to connect card xml
        View view = layoutInflater.inflate(R.layout.recycler_view_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
    // for loop, python starts with 1; C,C++,Java starts with 0
        final RecyclerViewData data = recyclerViewDataList.get(i);
        // final to  freeze for current loop
        holder.txtName.setText(data.getName());

        // holder.txtName.setText("Pratik");
        holder.txtPhone.setText(data.getNumber());


        //holder.img.setImageResource(); hang hogaa

        // glide or picaso (gif file too, degrades quality)  library
        Glide.with(context).load(data.getImage()).apply(RequestOptions.circleCropTransform()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        //return 0;
        return recyclerViewDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        //dont give private here !!!

        TextView txtName, txtPhone;
        ImageView img;

    // constructor
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        // RecyclerViewActivity.ViewHolder is the superClass
        txtName = itemView.findViewById(R.id.txt_name);
        txtPhone = itemView.findViewById(R.id.txt_number);
        img = itemView.findViewById(R.id.img);
    }

}
}
