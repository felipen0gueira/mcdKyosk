/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.controller;

import com.felipe.mckyosk.model.MenuItemModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */
public class CheckOutController {
    
    private static CheckOutController checkOutCrtl = null;
    private float total = 0;
    private List<Object[]> orderList = new ArrayList<>();
    
    private CheckOutController(){
        
    }
    
    public void sumTotal(float price){
        
        total = total + price;
        
    }
    
    public  float getTotal(){
        return total;
    }
    
    public static CheckOutController getInstance(){
        if(checkOutCrtl == null){
            checkOutCrtl = new CheckOutController();
            
        }
        
        return checkOutCrtl;
    }
    
    public void addItemToOrder(int quantity, MenuItemModel menuItemM){
        
       
        
        Object[] itemData = {quantity, menuItemM};
        orderList.add(itemData);
        
    }
            
    
}
