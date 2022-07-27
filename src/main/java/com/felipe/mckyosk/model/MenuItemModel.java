/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.model;

import java.util.List;

/**
 *
 * @author felip
 */
public class MenuItemModel {

    private int itemId;
    private String itemName;
    private List<Integer> itemCategory;
    private String itemSize;
    private float price;

    public MenuItemModel(int itemId, String itemName, List<Integer> itemCategory, String itemSize, float price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemSize = itemSize;
        this.price = price;
    }
    
    public MenuItemModel(){
        
    }

    /**
     * @return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemCategory
     */
    public List<Integer> getItemCategory() {
        return itemCategory;
    }

    /**
     * @param itemCategory the itemCategory to set
     */
    public void setItemCategory(List<Integer> itemCategory) {
        this.itemCategory = itemCategory;
    }

    /**
     * @return the itemSize
     */
    public String getItemSize() {
        return itemSize;
    }

    /**
     * @param itemSize the itemSize to set
     */
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

}
