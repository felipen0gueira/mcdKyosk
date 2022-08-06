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

    private List<MenuItemModel> mealAditionalItems = new ArrayList<>();

    public MealModel(int itemId, String itemName, List<Integer> itemCategory, String itemSize, float price, int groupId) {
        super(itemId, itemName, itemCategory, itemSize, price, groupId);
    }

    public List<MenuItemModel> getMealAditionalItems() {
        return mealAditionalItems;
    }

    public void setMealAditionalItems(List<MenuItemModel> result) {
        this.mealAditionalItems = result;
    }

}
