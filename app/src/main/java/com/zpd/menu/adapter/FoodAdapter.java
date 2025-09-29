package com.zpd.menu.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zpd.menu.R;
import com.zpd.menu.db.Classification;

import java.util.List;

public class FoodAdapter extends BaseQuickAdapter<Classification, FoodAdapter.ViewHolder> {

    private String TAG = FoodAdapter.class.getSimpleName();

    public FoodAdapter(@Nullable List<Classification> data) {
        super(R.layout.recycler_view_food_item, data);
    }

    @Override
    protected void convert(@NonNull ViewHolder baseViewHolder, Classification classification) {
        baseViewHolder.mTextView.setText(" "+ classification.cName);
        Log.e(TAG, "convert: " + baseViewHolder.getLayoutPosition());
    }

    public class ViewHolder extends BaseViewHolder{

        public TextView mTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            mTextView = view.findViewById(R.id.food);
        }
    }
}
