package com.zpd.menu.db;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class FoodInfo extends LitePalSupport {

    public long fId;

    public long pId;

    public String fName;

    public String url;

    public String method;


    public static List<FoodInfo> findAll(){
        return  LitePal.findAll(FoodInfo.class);
    }

    public static int findPosition(long pId){
        List<FoodInfo> foodInfos = LitePal.where("pId = ?", String.valueOf(pId)).find(FoodInfo.class);
        return foodInfos.size();
    }

    public static FoodInfo findOne(long fId){
        List<FoodInfo> foodInfos = LitePal.where("fId = ?", String.valueOf(fId)).find(FoodInfo.class);
        if (foodInfos !=null && foodInfos.size()>0){
            return foodInfos.get(0);
        }else return null;
    }


}
