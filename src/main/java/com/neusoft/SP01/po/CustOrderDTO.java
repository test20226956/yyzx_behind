package com.neusoft.SP01.po;

import java.util.List;

public class CustOrderDTO {
    private Integer orderId;
    private Integer customerId;
    private Integer mealType;
    private String date;
    private String request;
    private List<OrderMealDetailDTO> orderDetails;

    public Integer getMealType() {
        return mealType;
    }

    public void setMealType(Integer mealType) {
        this.mealType = mealType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public List<OrderMealDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderMealDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
