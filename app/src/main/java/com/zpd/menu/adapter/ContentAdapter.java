package com.zpd.menu.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zpd.menu.R;
import com.zpd.menu.data.MenusInfo;
import com.zpd.menu.db.FoodInfo;

import java.util.List;

public class ContentAdapter extends BaseQuickAdapter<FoodInfo, ContentAdapter.ViewHolder> {

    private String TAG = ContentAdapter.class.getSimpleName();

    public ContentAdapter(@Nullable List<FoodInfo> data) {
        super(R.layout.recycler_view_content_item, data);
    }

    @Override
    protected void convert(@NonNull ViewHolder baseViewHolder, FoodInfo foodInfo) {
        baseViewHolder.mTextView.setText(" "+ foodInfo.fName);
        Log.e(TAG, "convert: " + baseViewHolder.getLayoutPosition());
    }

    public class ViewHolder extends BaseViewHolder{

        public TextView mTextView;

        public ViewHolder(@NonNull View view) {
            super(view);
            mTextView = view.findViewById(R.id.title);
        }
    }
}
