package com.zpd.menu.db;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

/*
* 食物分类
* */
public class Classification extends LitePalSupport {

    public long cId;
    public String cName;

    public List<FoodInfo> foodInfoAll;


    public static List<Classification> findAll(){
        return  LitePal.findAll(Classification.class);
    }

    public static Classification findOne(long index){
        List<Classification> classifications = LitePal.where("cId = ?", String.valueOf(index)).find(Classification.class);
        if (classifications !=null){
            return classifications.get(0);
        }else return null;
    }
}
