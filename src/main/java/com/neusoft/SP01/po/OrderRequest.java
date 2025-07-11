package com.neusoft.SP01.po;

import java.util.List;

public class OrderRequest {
    private Integer customerId;
    private Integer mealType; // 1:早餐, 2:午餐, 3:晚餐
    private String date; // 直接使用Date类型
    private String request;
    private List<OrderDetail> orderDetails;
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getMealType() {
        return mealType;
    }
    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getRequest() {
        return request;
    }
    public void setRequest(String request) {
        this.request = request;
    }
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
