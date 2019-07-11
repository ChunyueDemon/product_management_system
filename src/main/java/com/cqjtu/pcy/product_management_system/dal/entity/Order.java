package com.cqjtu.pcy.product_management_system.dal.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="odc_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;//订单id
    private Integer productId;//所货物id
    private Integer attributeId;//所购买货物的属性id
    private Integer userName;//购买者名字
    private Date orderCreationTime;//订单创建时间
    private double orderAmount;//订单金额
    private Date productAmount;//货物数量
    private int orderCompleteTime;//订单完成时间
    private String productState;//货物的状态
    private Integer itemId;//收货地址id

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }

    public Date getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(Date orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Date productAmount) {
        this.productAmount = productAmount;
    }

    public int getOrderCompleteTime() {
        return orderCompleteTime;
    }

    public void setOrderCompleteTime(int orderCompleteTime) {
        this.orderCompleteTime = orderCompleteTime;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }
}
