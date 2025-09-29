package com.zpd.menu.tool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class Util {

    /**
     * 图片转字符串
     * @param bitmap 要转换的图片
     * @return 图片转换后的字符串
     */
    public static String imageToBase64(Bitmap bitmap){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] buffer = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(buffer, Base64.NO_WRAP);
    }

    /**
     * 字符串转图片
     * @param bitmap64 要转换的字符串
     * @return 字符串转换后的图片
     */
    public static Bitmap base64ToImage(String bitmap64){
        byte[] bytes = Base64.decode(bitmap64, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }



    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /*
     * 去空格
     * */
    public static String trim(String info){
        if (!TextUtils.isEmpty(info)){
            return info.replace(" ","");
        }else return info;
    }
}
