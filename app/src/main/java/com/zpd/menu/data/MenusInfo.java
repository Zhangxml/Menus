package com.zpd.menu.data;

import java.util.List;

public class MenusInfo {


    /**
     * foodInfo : {"foodId":0,"name":"鸡蛋炒饭","urls":[{"imageUrl":"http://123.com"}],"step":[{"id":0,"title":"小馄饨","describe":"鲜肉小馄炖"},{"id":1,"title":"小馄饨","describe":"鲜肉小馄炖"}]}
     */

    private FoodInfoBean foodInfo;

    public FoodInfoBean getFoodInfo() {
        return foodInfo;
    }

    public void setFoodInfo(FoodInfoBean foodInfo) {
        this.foodInfo = foodInfo;
    }

    public static class FoodInfoBean {
        /**
         * foodId : 0
         * name : 鸡蛋炒饭
         * urls : [{"imageUrl":"http://123.com"}]
         * step : [{"id":0,"title":"小馄饨","describe":"鲜肉小馄炖"},{"id":1,"title":"小馄饨","describe":"鲜肉小馄炖"}]
         */

        private int foodId;
        private String name;
        private List<UrlsBean> urls;
        private List<StepBean> step;

        public int getFoodId() {
            return foodId;
        }

        public void setFoodId(int foodId) {
            this.foodId = foodId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<UrlsBean> getUrls() {
            return urls;
        }

        public void setUrls(List<UrlsBean> urls) {
            this.urls = urls;
        }

        public List<StepBean> getStep() {
            return step;
        }

        public void setStep(List<StepBean> step) {
            this.step = step;
        }

        public static class UrlsBean {
            /**
             * imageUrl : http://123.com
             */

            private String imageUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }

        public static class StepBean {
            /**
             * id : 0
             * title : 小馄饨
             * describe : 鲜肉小馄炖
             */

            private int id;
            private String title;
            private String describe;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }
        }
    }
}
