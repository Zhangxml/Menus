package com.zpd.menu.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zpd.menu.R;
import com.zpd.menu.db.FoodInfo;
import com.zpd.menu.tool.MLog;

public class ContentAdapter extends BaseMultiItemQuickAdapter<FoodInfo, BaseViewHolder> {

    private String TAG = ContentAdapter.class.getSimpleName();

    public ContentAdapter() {
        addItemType(0,R.layout.recycler_content_item_type0);
        addItemType(1,R.layout.recycler_content_item_type1);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, FoodInfo foodInfo) {
        switch (foodInfo.getItemType()){
            case 0:{
//                ViewHolder0 viewHolder0 = (ViewHolder0) baseViewHolder;
//                viewHolder0.mName.setText(" "+ foodInfo.fName);
//                Log.e(TAG, "convert: " + baseViewHolder.getLayoutPosition());
                baseViewHolder.<TextView>findView(R.id.title).setText("分类："+ foodInfo.fName);
                break;
            }
            case 1:{
//                ViewHolder1 viewHolder1 = (ViewHolder1) baseViewHolder;
//                viewHolder1.mName.setText(" "+ foodInfo.fName);
//                viewHolder1.method.setText(" "+ foodInfo.method);
//                Log.e(TAG, "convert: " + baseViewHolder.getLayoutPosition());
                baseViewHolder.<TextView>findView(R.id.title).setText("名称："+ foodInfo.fName);
                baseViewHolder.<TextView>findView(R.id.method).setText("做法："+ foodInfo.method);
                break;
            }
        }

    }

//    public class ViewHolder0 extends BaseViewHolder{
//
//        public TextView mName;
//
//        public ViewHolder0(@NonNull View view) {
//            super(view);
//            mName = view.findViewById(R.id.title);
//        }
//    }
//
//    public class ViewHolder1 extends BaseViewHolder{
//
//        public TextView mName,method;
//
//        public ViewHolder1(@NonNull View view) {
//            super(view);
//            mName = view.findViewById(R.id.title);
//            method = view.findViewById(R.id.method);
//        }
//    }
}
