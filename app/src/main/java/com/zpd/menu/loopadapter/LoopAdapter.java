package com.zpd.menu.loopadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zpd.menu.R;

import java.util.ArrayList;

public class LoopAdapter extends RecyclerView.Adapter {
    ArrayList<String> data = new ArrayList<String>();

    public LoopAdapter() {
        initData();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.head_item_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder) holder).name.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }

    private void initData(){
        String[] str = new String[]{"AAAAAAA","BBBBBBBBB","CCCCCCCCCC"};
        for (int i = 0; i < 3; i++) {
            data.add(i, str[i % 3]);
        }
    }
}
