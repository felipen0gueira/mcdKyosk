/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.felipe.mckyosk.enums;

/**
 *
 * @author felip
 */
public enum CategoryEnum {
    MEAL(1), 
    NEW(2),
    MILKSHAKES_AND_COLD_DRINKS(3),
    REDUCED_PRICE(4),
    MCCAFE(5),
    WRAPS_AND_SALADS(6),
    BREAKFAST_MENU(7),
    DESSERTS(8),
    FRIES_AND_SIDES(9),
    VEGETARIAN(10),
    BURGERS(11);
    
    private final int id;
    
    private CategoryEnum(int id){
        this.id=id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
}
