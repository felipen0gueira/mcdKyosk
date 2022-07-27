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
public class MainMenuModel {
    
    private List<MenuItemModel> items = new ArrayList<MenuItemModel>();
    
    public MainMenuModel(List<MenuItemModel> items){
        this.items = items;
    }

    public MainMenuModel() {

    }

    /**
     * @return the items
     */
    public List<MenuItemModel> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<MenuItemModel> items) {
        this.items = items;
    }
    
}
