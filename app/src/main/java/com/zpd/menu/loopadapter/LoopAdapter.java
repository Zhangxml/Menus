package com.zpd.menu.loopadapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zpd.menu.R;
import com.zpd.menu.data.MenusInfo;
import com.zpd.menu.db.Classification;

import java.util.ArrayList;
import java.util.List;

public class LoopAdapter extends BaseQuickAdapter<Classification, LoopAdapter.ViewHolder>{

    public LoopAdapter(@Nullable List<Classification> data) {
        super(R.layout.head_item_view, data);
    }

    @Override
    protected void convert(@NonNull LoopAdapter.ViewHolder baseViewHolder, Classification menusInfo) {
        baseViewHolder.mTextView.setText(" "+ menusInfo.cName);
    }



    public class ViewHolder extends BaseViewHolder {

        public TextView mTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            mTextView = view.findViewById(R.id.name);
        }
    }
}
