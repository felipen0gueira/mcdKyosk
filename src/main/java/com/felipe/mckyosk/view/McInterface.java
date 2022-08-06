/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.felipe.mckyosk.view;

import com.felipe.mckyosk.controller.MainMenuController;
import com.felipe.mckyosk.model.MainMenuModel;
import com.felipe.mckyosk.model.MenuItemModel;


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
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    }

    public void checkType(MenuItemModel mm) {

    }
}
