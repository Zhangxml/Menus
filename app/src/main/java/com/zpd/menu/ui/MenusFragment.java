package com.zpd.menu.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zpd.menu.MenusActivity;
import com.zpd.menu.R;
import com.zpd.menu.adapter.ContentAdapter;
import com.zpd.menu.adapter.FoodAdapter;
import com.zpd.menu.data.MenusInfo;
import com.zpd.menu.db.Classification;
import com.zpd.menu.tool.MLog;
import com.zpd.menu.widget.RandomView;

import java.util.ArrayList;
import java.util.List;


public class MenusFragment extends Fragment {

    private String TAG = MenusFragment.class.getSimpleName();
    private MenusActivity activity;

    private RecyclerView mContentRecyclerView,mFoodRecyclerView;
    private FoodAdapter foodAdapter;
    private ContentAdapter contentAdapter;

    public static MenusFragment newInstance() {
        MenusFragment fragment = new MenusFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach: ");
        activity = (MenusActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_menus, container, false);
        initView(view);
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    private void initView(View view) {
        startToAdd(view);
        clickRandomView(view);
        foodView(view);
        contentView(view);

    }

    private void clickRandomView(View view) {
        view.findViewById(R.id.day_food).setOnClickListener((v)->{
            RandomView randomView = view.findViewById(R.id.random_view);
            randomView.refreshView();
        });
    }

    private void startToAdd(View view) {
        view.findViewById(R.id.start_to_add).setOnClickListener((v)->{
            activity.goEdit();
        });
    }

    private void foodView(View view) {
        // 初始化
        mFoodRecyclerView = view.findViewById(R.id.scroll_view);
        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false);
        mFoodRecyclerView.setLayoutManager(linearLayoutManager);
        foodAdapter = new FoodAdapter(null);
        mFoodRecyclerView.setAdapter(foodAdapter);
        // 点击
        addFoodRecyclerViewClick();
        // 添加数据
        addFoodData();
    }

    private void addFoodData() {
        List<Classification> all = Classification.findAll();
        if (all == null) return;

        List<MenusInfo> menusInfoList = new ArrayList<>();

        for (int i = 0; i < all.size(); i++) {
            MenusInfo menusInfo = new MenusInfo();
            MenusInfo.FoodInfoBean foodInfoBean = new MenusInfo.FoodInfoBean();
            foodInfoBean.setFoodId(i);
            foodInfoBean.setName(all.get(i).cName);
            menusInfo.setFoodInfo(foodInfoBean);
            menusInfoList.add(menusInfo);
        }

        foodAdapter.setList(menusInfoList);
    }

    private void addFoodRecyclerViewClick() {
        foodAdapter.setOnItemClickListener((adapter, view, position) -> {
            MLog.d("view = "+view + "   "+position + "   "+ contentAdapter.getData().get(position));
            clickScroller(mContentRecyclerView,position);
        });
    }

    private void contentView(View view) {
        // 初始化
        mContentRecyclerView = view.findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false);
        mContentRecyclerView.setLayoutManager(linearLayoutManager);
        contentAdapter = new ContentAdapter(null);
        mContentRecyclerView.setAdapter(contentAdapter);
        // 点击
        addContentRecyclerViewClick();
        // 添加数据
        addContentData();
    }

    private void addContentData(){
        List<MenusInfo> menusInfoList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            MenusInfo menusInfo = new MenusInfo();
            MenusInfo.FoodInfoBean foodInfoBean = new MenusInfo.FoodInfoBean();
            foodInfoBean.setFoodId(i);
            foodInfoBean.setName("做法 - " + i);
            menusInfo.setFoodInfo(foodInfoBean);
            menusInfoList.add(menusInfo);
        }

        contentAdapter.setList(menusInfoList);
    }



    private void addContentRecyclerViewClick(){
        contentAdapter.setOnItemClickListener((adapter, view, position) -> {
            MLog.d("view = "+view + "   "+position + "   "+ contentAdapter.getData().get(position));
        });
        mContentRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    //获取最后一个完全显示的ItemPosition
                    int position = manager.findFirstCompletelyVisibleItemPosition();
                    clickScroller(mFoodRecyclerView,position);
                }
            }
        });
    }

    private void clickScroller(RecyclerView recyclerView,int count){
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int firstItem = layoutManager.findFirstVisibleItemPosition();
        int lastItem = layoutManager.findLastVisibleItemPosition();
        //然后区分情况
        if (count <= firstItem ){
            //当要置顶的项在当前显示的第一个项的前面时
            recyclerView.scrollToPosition(count);
        }else if ( count <= lastItem ){
            //当要置顶的项已经在屏幕上显示时
            int top = recyclerView.getChildAt(count - firstItem).getTop();
            recyclerView.scrollBy(0, top);
        }else{
            //当要置顶的项在当前显示的最后一项的后面时
            recyclerView.scrollToPosition(count);
        }
    }

}