/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.controller;

import com.felipe.mckyosk.model.MenuItemModel;
import com.felipe.mckyosk.model.OrderModel;
import java.util.List;

/**
 *
 * @author felip
 */
public class OrderListController {

    private static OrderListController checkOutCrtl = null;
    //private float total = 0;
    //private List<Object[]> orderList = new ArrayList<>();
    OrderModel orderModel = new OrderModel();

    public List<Object[]> getOrderList() {
        return orderModel.getOrderList();
    }

    private OrderListController() {

    }

    public void sumTotal(float price) {

        orderModel.setTotal(orderModel.getTotal() + price);
    }
    
    public void removeItemTotal(float price) {

        orderModel.setTotal(orderModel.getTotal() - price);
    }

    public float getTotal() {
        return orderModel.getTotal();
    }

    public static OrderListController getInstance() {
        if (checkOutCrtl == null) {
            checkOutCrtl = new OrderListController();

        }

        return checkOutCrtl;
    }
    
    public static void resetInstance(){
        checkOutCrtl = null;
    }

    public void addItemToOrder(int quantity, MenuItemModel menuItemM) {

        Object[] itemData = {quantity, menuItemM};
        orderModel.getOrderList().add(itemData);

    }

    public void removeItem(int index) {
        Object[] it = orderModel.getOrderList().get(index);
        int quantity = (int) it[0];
        MenuItemModel item = (MenuItemModel) it[1];
        orderModel.setTotal(orderModel.getTotal() - (item.getPrice() * quantity));
        orderModel.getOrderList().remove(index);

    }

    public Integer getOrderType() {
        return orderModel.getOrderType();
    }

    public void setOrderType(Integer t) {
        orderModel.setOrderType(t);
        System.out.println(t);
    }
    
    

}
