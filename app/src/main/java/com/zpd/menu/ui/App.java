package com.zpd.menu.ui;

import android.app.Application;

import org.litepal.LitePal;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 数据库
        LitePal.initialize(getApplicationContext());
    }
}
