package com.zpd.menu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zpd.menu.R;
import com.zpd.menu.db.Classification;
import com.zpd.menu.loopadapter.AutoPollRecyclerView;
import com.zpd.menu.loopadapter.LooperLayoutManager;
import com.zpd.menu.loopadapter.LoopAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomView extends FrameLayout {

    private List<Long> listRandom = new ArrayList<>();

    private AutoPollRecyclerView loopView;

    private List<Classification> allClassification =null;

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

        loopView = content.findViewById(R.id.head_loop_view);
        loopView.setAdapter(new LoopAdapter(null));
        LooperLayoutManager layoutManager = new LooperLayoutManager();
        layoutManager.setLooperEnable(true);
        loopView.setLayoutManager(layoutManager);

        refreshView();

        postDelayed(()->{
            loopView.start();
        },1000);
    }

    public void refreshView(){
        allClassification = Classification.findAll();
        if (allClassification.size() == 0) return;
        new Thread(()->{
            for (int i = 0; i < 3; i++) {
                randomNum(0, allClassification.size());
            }
            post(this::refreshView_);
        }).start();
    }

    private void refreshView_() {
        List<Classification> all = new ArrayList<>();
        for (int i = 0; i < listRandom.size(); i++) {
            long id = listRandom.get(i);
            Classification one = Classification.findOneById(id);
            if (one !=null) all.add(one);
        }
        LoopAdapter adapter = (LoopAdapter) loopView.getAdapter();
        adapter.setList(all);
    }

    /*
    * 参考： https://blog.csdn.net/qq_28845393/article/details/87255711
    * */
    private void randomNum(int min,int max){
        if (listRandom.size() == 3) listRandom.clear();
        final Random random = new Random();
        int num = random.nextInt(max)%(max-min+1) + min;
        listRandom.add(allClassification.get(num).cId);
    }


}
