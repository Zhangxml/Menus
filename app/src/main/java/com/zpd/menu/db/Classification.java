package com.zpd.menu.db;

import android.database.Cursor;

import com.zpd.menu.tool.MLog;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

/*
* 食物分类
* */
public class Classification extends LitePalSupport {

    public long cId;
    public String cName;

    public static List<Classification> findAll(){
        return  LitePal.findAll(Classification.class);
    }

    public static Classification findOneById(long index){
        List<Classification> classifications = LitePal.where("cId=?", String.valueOf(index)).find(Classification.class);
        if (classifications !=null && classifications.size()>0){
            return classifications.get(0);
        }else return null;
    }

    public static Classification findOneByName(String cName){
        List<Classification> classifications = LitePal.where("cName=?", String.valueOf(cName)).find(Classification.class);
        if (classifications !=null && classifications.size()>0){
            return classifications.get(0);
        }else return null;
    }
}
