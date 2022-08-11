/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.controller;

import com.felipe.mckyosk.dao.ItemDao;
import com.felipe.mckyosk.enums.MealSizeEnum;
import com.felipe.mckyosk.model.ItemCustomizationModel;
import com.felipe.mckyosk.model.MainMenuModel;
import com.felipe.mckyosk.model.MealModel;
import com.felipe.mckyosk.model.MenuItemModel;
import com.felipe.mckyosk.view.ItemView;
import com.felipe.mckyosk.view.MainMenuView;
import java.util.Iterator;
import java.util.List;
import javax.swing.JCheckBox;
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
    List<MenuItemModel> itemsRangeOption;
    MenuItemModel selectedDrink;
    MenuItemModel selectedSide;
    boolean loadingMeal = false;

    public ItemController(ItemView itemView, MenuItemModel mItemModel) {
        this.itemView = itemView;
        this.mItemModel = mItemModel;
        this.initController();
    }

    private void loadItemData() {

        if (mItemModel.getGroupId() != null) {
            ItemDao dao = new ItemDao();
            itemsRangeOption = dao.selectItemsByGroupId(mItemModel.getGroupId());

            for (MenuItemModel menuItemModel : itemsRangeOption) {
                System.out.println("EHHHHHHHHHHHHHHHHHHHH " + menuItemModel.getItemName() + " " + menuItemModel.getItemSize());
                if (menuItemModel instanceof MealModel) {
                    loadingMeal = true;
                    itemView.getRdBtnMeal().setVisible(true);
                    itemView.getRdBtnOnlyBurger().setVisible(true);
                }

                if (menuItemModel.getItemSize().equals(String.valueOf(MealSizeEnum.Large))) {
                    itemView.getRdBtnLg().setVisible(true);

                }
                if (menuItemModel.getItemSize().equals(String.valueOf(MealSizeEnum.Medium))) {
                    itemView.getRdBtnMd().setVisible(true);

                }
                if (menuItemModel.getItemSize().equals(String.valueOf(MealSizeEnum.Small))) {
                    itemView.getRdBtnSml().setVisible(true);

                }

            }

//            MenuItemModel l = itemsRangeOption.stream().filter(p -> p.getItemSize().equals(String.valueOf(MealSizeEnum.Large))).findFirst().get();
//            MenuItemModel m = itemsRangeOption.stream().filter(p -> p.getItemSize().equals(String.valueOf(MealSizeEnum.Medium))).findFirst().get();
//            MenuItemModel nonSize = itemsRangeOption.stream().filter(p -> p.getItemSize().isEmpty()).findFirst().get();
        }

        itemView.getLblTotal().setText("€" + String.format("%.2f", OrderListSingleton.getInstance().getTotal()));

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
        selectSize(MealSizeEnum.Medium);
        itemView.getLblTitle().setText(mItemModel.getItemName());
        itemView.getLblPrice().setText("€" + String.format("%.2f", mItemModel.getPrice()));
        itemView.getLblNumItem().setText("1");
        itemView.validate();
        itemView.repaint();

    }

    public void initController() {

        itemView.setVisible(true);
        itemView.getBtnCancel().addActionListener(e -> cancel());
        itemView.getBtbPlus().addActionListener(e -> incrementItems());
        itemView.getBtnMinus().addActionListener(e -> decrementItems());
        itemView.getCbDrink().addActionListener(e -> setSelectedDrink(itemView.getCbDrink().getSelectedItem(), itemView.getCbDrink().getSelectedIndex()));
        itemView.getCbSide().addActionListener(e -> setSelectedSide(itemView.getCbSide().getSelectedItem(), itemView.getCbSide().getSelectedIndex()));
        itemView.getBtnAddOrder().addActionListener(e -> addToOrder());
        itemView.getBtnCustomize().addActionListener(e -> toggleCustomBtn());

        itemView.getRdBtnOnlyBurger().addActionListener(e -> {
            setBurgerOnlyView();
            selectBurgerOnly();
        });
        itemView.getRdBtnMeal().addActionListener(e -> setMealView());

        itemView.getRdBtnSml().addActionListener(e -> {
            loadDrinksSelection(String.valueOf(MealSizeEnum.Small));
            loadsidesSelection(String.valueOf(MealSizeEnum.Small));
            selectSize(MealSizeEnum.Small);
        });
        itemView.getRdBtnMd().addActionListener(e -> {
            loadDrinksSelection(String.valueOf(MealSizeEnum.Medium));
            loadsidesSelection(String.valueOf(MealSizeEnum.Medium));
            selectSize(MealSizeEnum.Medium);
        });

        itemView.getRdBtnLg().addActionListener(e -> {
            loadDrinksSelection(String.valueOf(MealSizeEnum.Large));
            loadsidesSelection(String.valueOf(MealSizeEnum.Large));
            selectSize(MealSizeEnum.Large);
        });

        loadItemData();
        loadDrinksSelection();
        loadsidesSelection();
        loadCustomizationOpt();

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

    private void loadDrinksSelection(String itemSize) {

        System.out.println("loadDrinksSelection(String itemSize)");

        itemView.getCbDrink().removeAllItems();

        itemView.getCbDrink().addItem("Select a Drink");

        ItemDao dao = new ItemDao();

        drinksList = dao.getDrinksList(itemSize);

        for (Iterator<MenuItemModel> iterator = drinksList.iterator(); iterator.hasNext();) {
            MenuItemModel next = iterator.next();

            itemView.getCbDrink().addItem(next.getItemName() + " - " + next.getItemSize());

        }

        itemView.validate();
        itemView.repaint();

    }

    private void loadsidesSelection(String itemSize) {

        System.out.println("loadsidesSelection(String itemSize)");

        itemView.getCbSide().removeAllItems();
        itemView.getCbSide().addItem("Select a Side");

        ItemDao dao = new ItemDao();

        sidesList = dao.getSidesList(itemSize);

        for (Iterator<MenuItemModel> iterator = sidesList.iterator(); iterator.hasNext();) {
            MenuItemModel next = iterator.next();
            String strItem = (next.getItemSize() == null) ? next.getItemName() : next.getItemName() + " - " + next.getItemSize();

            itemView.getCbSide().addItem(strItem);

        }

        itemView.validate();
        itemView.repaint();

    }

    private void loadCustomizationOpt() {

        ItemDao dao = new ItemDao();
        List<ItemCustomizationModel> list = dao.getCustomizationOptions();
        for (ItemCustomizationModel objects : list) {
            String c = objects.getTitle();
            float price = objects.getPrice();
            JCheckBox opt = new JCheckBox();
            String txt = (price == 0) ? c : c + " + €" + String.format("%.2f", price);
            opt.addActionListener(e -> checkCustomizationItem(opt.isSelected(), objects));
            opt.setText(txt);
            opt.setFont(new java.awt.Font("Segoe UI", 0, 18));
            itemView.getPnlCustom().add(opt);

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

        if (itemCbIdex > 0) {
            System.out.println(drinksList.get(itemCbIdex - 1).getItemName());
            selectedDrink = drinksList.get(itemCbIdex - 1);
            System.out.println(String.valueOf(o) + " " + itemCbIdex);

        }

    }

    private void setSelectedSide(Object o, int itemCbIdex) {
        if (itemCbIdex > 0) {
            System.out.println(sidesList.get(itemCbIdex - 1).getItemName());
            selectedSide = sidesList.get(itemCbIdex - 1);

            System.out.println(String.valueOf(o) + " " + itemCbIdex);
        }
    }

    private boolean validateOrder() {

        if (itemView.getRdBtnOnlyBurger().isSelected()) {
            return true;
        }

        if ((mItemModel instanceof MealModel)) {
            if (itemView.getCbDrink().getSelectedIndex() == 0 || itemView.getCbSide().getSelectedIndex() == 0) {
                return false;
            }

        }
        return true;

    }

    private void addToOrder() {

        if (validateOrder()) {

            if (mItemModel instanceof MealModel) {
                MealModel meal = (MealModel) mItemModel;
                meal.getMealAditionalItems().add(selectedDrink);
                meal.getMealAditionalItems().add(selectedSide);

                mItemModel = meal;
            }

            float price = mItemModel.getPrice();
            int quantity = Integer.valueOf(itemView.getLblNumItem().getText());
            OrderListSingleton.getInstance().sumTotal(price * quantity);

            OrderListSingleton.getInstance().addItemToOrder(quantity, mItemModel);
            itemView.getLblTotal().setText("€" + String.format("%.2f", OrderListSingleton.getInstance().getTotal()));
            JOptionPane.showMessageDialog(itemView, "Item Added to Order!");
            MainMenuView view = new MainMenuView();
            MainMenuModel model = new MainMenuModel();
            MainMenuController controller = new MainMenuController(model, view);
            controller.initController();
            itemView.dispose();

        } else {

            JOptionPane.showMessageDialog(itemView, "Select Drink and Side!");
        }
    }

    private void cancel() {
        MainMenuView view = new MainMenuView();
        MainMenuModel model = new MainMenuModel();
        MainMenuController controller = new MainMenuController(model, view);
        controller.initController();
        this.itemView.dispose();

    }

    private void toggleCustomBtn() {
        if (itemView.getBtnCustomize().isSelected()) {
            itemView.getPnlCustom().setVisible(true);
            System.out.println("ON");
        } else {
            itemView.getPnlCustom().setVisible(false);
            System.out.println("OFF");

        }
    }

    private void checkCustomizationItem(boolean isSelected, ItemCustomizationModel item) {

        System.err.println(isSelected);

        if (isSelected) {
            mItemModel.getSelectedCustomization().add(item);
            mItemModel.setPrice(mItemModel.getPrice() + item.getPrice());
        } else {
            mItemModel.getSelectedCustomization().remove(item);
            mItemModel.setPrice(mItemModel.getPrice() - item.getPrice());

        }
        updatePriceOnGui();

    }

    private void setBurgerOnlyView() {

        itemView.getRdBtnLg().setVisible(false);
        itemView.getRdBtnMd().setVisible(false);
        itemView.getRdBtnSml().setVisible(false);

        itemView.getLblDrink().setVisible(false);
        itemView.getLblSide().setVisible(false);
        itemView.getCbDrink().setVisible(false);
        itemView.getCbSide().setVisible(false);

    }

    private void setMealView() {

        for (MenuItemModel menuItemModel : itemsRangeOption) {
            if (menuItemModel.getItemSize().equals(String.valueOf(MealSizeEnum.Large))) {
                itemView.getRdBtnLg().setVisible(true);

            }
            if (menuItemModel.getItemSize().equals(String.valueOf(MealSizeEnum.Medium))) {
                itemView.getRdBtnMd().setVisible(true);

            }
            if (menuItemModel.getItemSize().equals(String.valueOf(MealSizeEnum.Small))) {
                itemView.getRdBtnSml().setVisible(true);

            }
        }
        itemView.getLblDrink().setVisible(true);
        itemView.getLblSide().setVisible(true);
        itemView.getCbDrink().setVisible(true);
        itemView.getCbSide().setVisible(true);
    }

    private void selectSize(MealSizeEnum size) {

        MenuItemModel selectedItemSize = itemsRangeOption.stream().filter(p -> p.getItemSize().equals(String.valueOf(size))).findFirst().get();
        System.out.println(selectedItemSize.getItemName() + " - " + selectedItemSize.getItemSize() + " - " + selectedItemSize.getPrice());

        selectedItemSize.setSelectedCustomization(mItemModel.getSelectedCustomization());

        for (ItemCustomizationModel object : selectedItemSize.getSelectedCustomization()) {

            selectedItemSize.setPrice(selectedItemSize.getPrice() + object.getPrice());

        }
        mItemModel = selectedItemSize;
        updatePriceOnGui();

    }

    private void selectBurgerOnly() {

        MenuItemModel burgerOnly = itemsRangeOption.stream().filter(p -> p.getItemSize().isEmpty()).findFirst().get();

        burgerOnly.setSelectedCustomization(mItemModel.getSelectedCustomization());

        for (ItemCustomizationModel object : burgerOnly.getSelectedCustomization()) {

            burgerOnly.setPrice(burgerOnly.getPrice() + object.getPrice());

        }
        mItemModel = burgerOnly;
        updatePriceOnGui();

    }

    public void updatePriceOnGui() {

        itemView.getLblPrice().setText("€ " + String.format("%.2f", mItemModel.getPrice()));
        itemView.validate();
        itemView.repaint();

    }
}
