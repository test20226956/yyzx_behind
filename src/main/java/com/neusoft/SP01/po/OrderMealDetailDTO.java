package com.neusoft.SP01.po;

public class OrderMealDetailDTO {
    private Integer mealId;
    private String mealName;
    private String mealImg;
    private Integer mealType;
    private Integer mealState;

    private Integer count;

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealImg() {
        return mealImg;
    }

    public void setMealImg(String mealImg) {
        this.mealImg = mealImg;
    }

    public Integer getMealState() {
        return mealState;
    }

    public void setMealState(Integer mealState) {
        this.mealState = mealState;
    }

    public Integer getMealType() {
        return mealType;
    }

    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}