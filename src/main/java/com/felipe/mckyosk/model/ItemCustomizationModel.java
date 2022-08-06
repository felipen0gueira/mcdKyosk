/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.model;

/**
 *
 * @author felip
 */
public class ItemCustomizationModel {
    int idCustom;
    float price;
    String title;

    public ItemCustomizationModel(int idCustom, float price, String title) {
        this.idCustom = idCustom;
        this.price = price;
        this.title = title;
    }
    

    public int getIdCustom() {
        return idCustom;
    }

    public void setIdCustom(int idCustom) {
        this.idCustom = idCustom;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
}
