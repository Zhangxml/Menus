package com.zpd.menu.tool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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


}
