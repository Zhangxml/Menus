package com.zpd.menu.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.zpd.menu.MenusActivity;
import com.zpd.menu.R;
import com.zpd.menu.db.Classification;

import java.util.Date;

/**
 * 增加数据
 */
public class EditFragment extends Fragment {

    private String TAG = EditFragment.class.getSimpleName();

    private MenusActivity activity;

    private EditText cFoodClassification = null;

    public EditFragment() {}

    public static EditFragment newInstance() {
        EditFragment fragment = new EditFragment();
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
        View view = inflater.inflate(R.layout.fragment_edit, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        // 返回
        view.findViewById(R.id.edit_back).setOnClickListener(this::onClick);
        //保存
        view.findViewById(R.id.edit_save).setOnClickListener(this::onClick);
        // 食物分类
        cFoodClassification = view.findViewById(R.id.c_food_classification);
    }

    private void onClick(View view) {
        if (view.getId() == R.id.edit_back){
            activity.getSupportFragmentManager().popBackStack();
        }else if (view.getId() == R.id.edit_save){
            save();
        }
    }

    private void save(){
        Classification classification = new Classification();
        classification.cId = SystemClock.elapsedRealtime();
        classification.cName = " "+ cFoodClassification.getText().toString();
        classification.save();
        activity.getSupportFragmentManager().popBackStack();
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


}