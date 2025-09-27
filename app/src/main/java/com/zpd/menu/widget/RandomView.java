package com.zpd.menu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zpd.menu.R;
import com.zpd.menu.tool.MLog;

import java.util.Random;

public class RandomView extends FrameLayout {

    private int min = 0;
    private int max = 33;
    private Random random = new Random();

    public RandomView(@NonNull Context context) {
        this(context,null);
    }

    public RandomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RandomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public RandomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View content = LayoutInflater.from(getContext()).inflate(R.layout.random_view_layout, this);
        content.setOnClickListener(this::onClick);
    }

    private void onClick(View view){
        int num = random.nextInt(max)%(max-min+1) + min;
        MLog.d("   num =  " + num);
    }
}
