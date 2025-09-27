package com.zpd.menu.tool;

public class MLog {

    public static final boolean  isDebug = true;

    public static final String TAG = "MLog";

    public static void d(String s) {
        if (isDebug) {
            android.util.Log.d(TAG, s);
        }
    }

    public static void d(String TAG,String s) {
        if (isDebug) {
            android.util.Log.d(TAG, s);
        }
    }







}
