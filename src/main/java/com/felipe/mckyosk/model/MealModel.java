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
public class MealModel extends MenuItemModel {
    private List<MenuItemModel> result = new ArrayList<>();

    public MealModel(int itemId, String itemName, List<Integer> itemCategory, String itemSize, float price) {
        super(itemId, itemName, itemCategory, itemSize, price);
    }


 

    public List<MenuItemModel> getResult() {
        return result;
    }

    public void setResult(List<MenuItemModel> result) {
        this.result = result;
    }
    
    
}
