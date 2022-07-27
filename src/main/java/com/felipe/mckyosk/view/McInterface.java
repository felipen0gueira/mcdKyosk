/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.felipe.mckyosk.view;

import com.felipe.mckyosk.controller.MainMenuController;
import com.felipe.mckyosk.enums.MealSizeEnum;
import com.felipe.mckyosk.model.MainMenuModel;
import com.felipe.mckyosk.model.MealModel;
import com.felipe.mckyosk.model.MenuItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author felip
 */
public class McInterface {

    public static void main(String[] args) {
        MainMenuView view = new MainMenuView();
        MainMenuModel model = new MainMenuModel();
        MainMenuController controller = new MainMenuController(model, view);
        controller.initController();
        
        List<Integer> test = new ArrayList<>();

        MealModel mealm = new MealModel(10, "MealModel", test, "itemSize", 10);
        MenuItemModel menuI = new MenuItemModel(0, "MenuItemModel", test, "itemSize", 0);

        List<MenuItemModel> items = new ArrayList<>();
        items.add(menuI);
        items.add(mealm);
        

        for (Iterator<MenuItemModel> iterator = items.iterator(); iterator.hasNext();) {

            MenuItemModel next = iterator.next();
            if (next instanceof MealModel) {
                System.out.println("sim!!");
                System.out.println(next.getItemName());

            } else {
                System.out.println("nao!!");
                System.out.println(next.getItemName());
            }

        }

    }

    public void checkType(MenuItemModel mm) {

    }
}
