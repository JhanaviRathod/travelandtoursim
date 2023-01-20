package com.safarsathi.backend.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String orderFullName;
    private String orderFullOrder;
    private String orderContactNumber;
    private String orderAlternateNumber;
    private String orderStatus;
    private Integer orderAmount;
    @OneToOne
    private Package pack;
    @OneToOne
    private User user;

    public OrderDetail(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateNumber, String orderStatus, Integer orderAmount, Package pack, User user) {
        this.orderFullName = orderFullName;
        this.orderFullOrder = orderFullOrder;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateNumber = orderAlternateNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.pack = pack;
        this.user = user;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderDetail(){

    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderFullName() {
        return orderFullName;
    }

    public void setOrderFullName(String orderFullName) {
        this.orderFullName = orderFullName;
    }

    public String getOrderFullOrder() {
        return orderFullOrder;
    }

    public void setOrderFullOrder(String orderFullOrder) {
        this.orderFullOrder = orderFullOrder;
    }

    public String getOrderContactNumber() {
        return orderContactNumber;
    }

    public void setOrderContactNumber(String orderContactNumber) {
        this.orderContactNumber = orderContactNumber;
    }

    public String getOrderAlternateNumber() {
        return orderAlternateNumber;
    }

    public void setOrderAlternateNumber(String orderAlternateNumber) {
        this.orderAlternateNumber = orderAlternateNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }
}
