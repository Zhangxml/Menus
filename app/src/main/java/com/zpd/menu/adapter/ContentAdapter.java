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

import java.util.List;

public class ContentAdapter extends BaseQuickAdapter<MenusInfo, ContentAdapter.ViewHolder> {

    private String TAG = ContentAdapter.class.getSimpleName();

    public ContentAdapter(@Nullable List<MenusInfo> data) {
        super(R.layout.recycler_view_content_item, data);
    }

    @Override
    protected void convert(@NonNull ViewHolder baseViewHolder, MenusInfo menusInfo) {
        baseViewHolder.mTextView.setText(" "+ menusInfo.getFoodInfo().getName());
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
