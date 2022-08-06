/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class OrderModel {

    private float total = 0;
    private List<Object[]> orderList = new ArrayList<>();
    //1 takeawaya
    //0 Eat In
    private Integer orderType = null;
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<Object[]> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Object[]> orderList) {
        this.orderList = orderList;
    }

    public Integer getOrderType() {
        return orderType;
    }


    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }


}
