/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.controller;

import com.felipe.mckyosk.dao.ItemDao;
import com.felipe.mckyosk.enums.CategoryEnum;
import com.felipe.mckyosk.model.MainMenuModel;
import com.felipe.mckyosk.model.MenuItemModel;
import com.felipe.mckyosk.view.ItemView;
import com.felipe.mckyosk.view.MainMenuView;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author felip
 */
public class MainMenuController {

    private MainMenuModel mMenuModel = new MainMenuModel();
    private MainMenuView mMenuView = new MainMenuView();

    public MainMenuController(MainMenuModel mMenuModel, MainMenuView mMenuView) {
        this.mMenuModel = mMenuModel;
        this.mMenuView = mMenuView;
    }

    public MainMenuModel getmMenuModel() {
        return mMenuModel;
    }

    public void setmMenuModel(MainMenuModel mMenuModel) {
        this.mMenuModel = mMenuModel;
    }

    public MainMenuView getmMenuMiew() {
        return mMenuView;
    }

    public void setmMenuMiew(MainMenuView mMenuView) {
        this.mMenuView = mMenuView;
    }

    public void initController() {
        mMenuView.getwNewBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.NEW, mMenuView.getwNewBtn().getText()));
        mMenuView.getMeaslBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.MEAL, mMenuView.getMeaslBtn().getText()));
        mMenuView.getBurgersBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.BURGERS, mMenuView.getBurgersBtn().getText()));
        mMenuView.getMilkShakeCDrinksBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.MILKSHAKES_AND_COLD_DRINKS, mMenuView.getMilkShakeCDrinksBtn().getText()));
        mMenuView.getReducedPriceBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.REDUCED_PRICE, mMenuView.getReducedPriceBtn().getText()));
        mMenuView.getMcCafeBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.MCCAFE, mMenuView.getMcCafeBtn().getText()));
        mMenuView.getWrapSaladsBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.WRAPS_AND_SALADS, mMenuView.getWrapSaladsBtn().getText()));
        mMenuView.getVegetarianBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.VEGETARIAN, mMenuView.getVegetarianBtn().getText()));
        mMenuView.getFriesSidesBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.FRIES_AND_SIDES, mMenuView.getFriesSidesBtn().getText()));
        mMenuView.getDesssertsBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.DESSERTS, mMenuView.getDesssertsBtn().getText()));
        mMenuView.getBreakfastBtn().addActionListener(e -> setMenuByCategory(CategoryEnum.BREAKFAST_MENU, mMenuView.getBreakfastBtn().getText()));

        mMenuView.setVisible(true);

    }

    public void setMenuByCategory(CategoryEnum category, String menuTitle) {

        System.out.println(category.getId());
        mMenuView.getCentralMenuPanel().removeAll();
        loadMainMenuContent(category.getId());
        mMenuView.revalidate();
        mMenuView.repaint();
        mMenuView.getTitleLabel().setText(menuTitle);
        System.out.println(category);

    }

    private void loadMainMenuContent(int ItemId) {

        ItemDao dao = new ItemDao();
        List<MenuItemModel> result = dao.selectAllItemsByCategory(ItemId);

        for (Iterator<MenuItemModel> iterator = result.iterator(); iterator.hasNext();) {
            MenuItemModel next = iterator.next();
            System.out.println("NAME " + next.getItemName());

            javax.swing.JButton jButton1 = new JButton();
            String itemBtnTitle = (next.getItemSize() == null) ? next.getItemName() : next.getItemName() + " - " + next.getItemSize();
            jButton1.setText(itemBtnTitle);
            jButton1.addActionListener(e -> {
                loadSelectedItem(next.getItemId());
            });
            mMenuView.getCentralMenuPanel().add(jButton1);

        }

    }

    private void loadSelectedItem(int itemId) {
        ItemDao dao = new ItemDao();
        MenuItemModel item = dao.getItemById(itemId);

        ItemView itemView = new ItemView();
        ItemController itemContr = new ItemController(itemView, item);

        System.out.println(item.getItemName());
        System.out.println(item.getItemSize());
        System.out.println(item.getPrice());

    }

}
