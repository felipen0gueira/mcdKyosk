/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.controller;

import com.felipe.mckyosk.dao.ItemDao;
import com.felipe.mckyosk.model.MealModel;
import com.felipe.mckyosk.model.MenuItemModel;
import com.felipe.mckyosk.view.ItemView;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class ItemController {

    private ItemView itemView = new ItemView();
    private MenuItemModel mItemModel = new MenuItemModel();
    List<MenuItemModel> drinksList;
    List<MenuItemModel> sidesList;

    public ItemController(ItemView itemView, MenuItemModel mItemModel) {
        this.itemView = itemView;
        this.mItemModel = mItemModel;
        this.initController();
    }

    private void loadItemData() {

        itemView.getLblTotal().setText("€" + String.format("%.2f", CheckOutController.getInstance().getTotal()));

        if (mItemModel instanceof MealModel) {
            loadMealItem();
        } else {
            itemView.getLblDrink().setVisible(false);
            itemView.getLblSide().setVisible(false);
            itemView.getCbDrink().setVisible(false);
            itemView.getCbSide().setVisible(false);
            itemView.getLblTitle().setText(mItemModel.getItemName());
            itemView.getLblPrice().setText(String.format("%.2f", mItemModel.getPrice()));
            itemView.validate();
            itemView.repaint();

        }

    }

    private void loadMealItem() {

        itemView.getLblDrink().setVisible(true);
        itemView.getLblSide().setVisible(true);
        itemView.getCbSide().setVisible(true);
        itemView.getCbSide().setVisible(true);
        itemView.getLblTitle().setText(mItemModel.getItemName());
        itemView.getLblPrice().setText("€" + String.format("%.2f", mItemModel.getPrice()));
        itemView.getLblNumItem().setText("1");
        itemView.validate();
        itemView.repaint();

    }

    public void initController() {

        itemView.setVisible(true);
        itemView.getBtnCancel().addActionListener(e -> itemView.dispose());
        itemView.getBtbPlus().addActionListener(e -> incrementItems());
        itemView.getBtnMinus().addActionListener(e -> decrementItems());
        itemView.getCbDrink().addActionListener(e -> setSelectedDrink(itemView.getCbDrink().getSelectedItem(), itemView.getCbDrink().getSelectedIndex()));
        itemView.getCbSide().addActionListener(e -> setSelectedSide(itemView.getCbSide().getSelectedItem(), itemView.getCbSide().getSelectedIndex()));
        itemView.getBtnAddOrder().addActionListener(e -> addToOrder());
        loadItemData();
        loadDrinksSelection();
        loadsidesSelection();

    }

    private void incrementItems() {

        Integer numAmount = Integer.valueOf(itemView.getLblNumItem().getText());
        numAmount++;
        itemView.getLblNumItem().setText(String.valueOf(numAmount));

    }

    private void decrementItems() {

        Integer numAmount = Integer.valueOf(itemView.getLblNumItem().getText());
        if (numAmount > 1) {

            numAmount--;
            itemView.getLblNumItem().setText(String.valueOf(numAmount));

        }
    }

    private void loadDrinksSelection() {

        ItemDao dao = new ItemDao();

        drinksList = dao.getDrinksList(mItemModel.getItemSize());

        for (Iterator<MenuItemModel> iterator = drinksList.iterator(); iterator.hasNext();) {
            MenuItemModel next = iterator.next();

            itemView.getCbDrink().addItem(next.getItemName() + " - " + next.getItemSize());

        }

        itemView.validate();
        itemView.repaint();

    }

    private void loadsidesSelection() {

        ItemDao dao = new ItemDao();

        sidesList = dao.getSidesList(mItemModel.getItemSize());

        for (Iterator<MenuItemModel> iterator = sidesList.iterator(); iterator.hasNext();) {
            MenuItemModel next = iterator.next();
            String strItem = (next.getItemSize() == null) ? next.getItemName() : next.getItemName() + " - " + next.getItemSize();

            itemView.getCbSide().addItem(strItem);

        }

        itemView.validate();
        itemView.repaint();

    }

    private void setSelectedDrink(Object o, int itemCbIdex) {

        System.out.println(String.valueOf(o) + " " + itemCbIdex);

    }

    private void setSelectedSide(Object o, int itemCbIdex) {

        System.out.println(String.valueOf(o) + " " + itemCbIdex);

    }

    private boolean validateOrder() {

        if ((mItemModel instanceof MealModel)) {
            if (itemView.getCbDrink().getSelectedIndex() == 0 || itemView.getCbSide().getSelectedIndex() == 0) {
                return false;
            }

        }
        return true;

    }

    private void addToOrder() {

        if (validateOrder()) {

            float price = mItemModel.getPrice();
            int quantity = Integer.valueOf(itemView.getLblNumItem().getText());
            CheckOutController.getInstance().sumTotal(price * quantity);

            CheckOutController.getInstance().addItemToOrder(quantity, mItemModel);
            itemView.getLblTotal().setText("€" + String.format("%.2f", CheckOutController.getInstance().getTotal()));
            JOptionPane.showMessageDialog(itemView, "Item Added to Order!");
            itemView.dispose();

        } else {

            JOptionPane.showMessageDialog(itemView, "Select Drink and Side!");
        }
    }

}
