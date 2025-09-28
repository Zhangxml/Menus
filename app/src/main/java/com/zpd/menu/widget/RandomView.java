package com.zpd.menu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zpd.menu.R;
import com.zpd.menu.loopadapter.AutoPollRecyclerView;
import com.zpd.menu.loopadapter.LooperLayoutManager;
import com.zpd.menu.loopadapter.LoopAdapter;
import com.zpd.menu.tool.MLog;

import java.util.Random;

public class RandomView extends FrameLayout {

    private AutoPollRecyclerView loopView;

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

        loopView = content.findViewById(R.id.head_loop_view);
        loopView.setAdapter(new LoopAdapter());
        LooperLayoutManager layoutManager = new LooperLayoutManager();
        layoutManager.setLooperEnable(true);
        loopView.setLayoutManager(layoutManager);
        loopView.start();
    }

    private void onClick(View view){

    }

    /*
    * 参考： https://blog.csdn.net/qq_28845393/article/details/87255711
    * */
    private void randomNum(int min,int max){
        final Random random = new Random();
        int num = random.nextInt(max)%(max-min+1) + min;
        MLog.d("random num  = "+ num);
    }


}
