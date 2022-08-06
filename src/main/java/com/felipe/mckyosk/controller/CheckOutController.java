/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.controller;

import com.felipe.mckyosk.model.ItemCustomizationModel;
import com.felipe.mckyosk.model.MainMenuModel;
import com.felipe.mckyosk.model.MealModel;
import com.felipe.mckyosk.model.MenuItemModel;
import com.felipe.mckyosk.view.CheckoutView;
import com.felipe.mckyosk.view.MainMenuView;
import com.felipe.mckyosk.view.PaymentView;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class CheckOutController {

    private CheckoutView ckoutView = new CheckoutView();
    private int edtItemIndex;

    public CheckOutController() {
    }

    public void initController() {
        ckoutView.getLblTotal().setText("Total: €" + String.format("%.2f", OrderListController.getInstance().getTotal()));
        ckoutView.getBtnDelete().addActionListener(e -> removeSelectedItem());
        ckoutView.getBtnMainMenu().addActionListener(e -> returnMainMenu());
        ckoutView.getBtnCancel().addActionListener(e -> cancelOrder());
        ckoutView.getBtnEdit().addActionListener(e -> initItemEdition());
        ckoutView.getBtbPlus().addActionListener(e -> incrementItems());
        ckoutView.getBtnMinus().addActionListener(e -> decrementItems());
        ckoutView.getBtnConfirmEdt().addActionListener(e -> applyEdition());
        ckoutView.getPnlEdt().setVisible(false);
        ckoutView.getBtnPay().addActionListener(e -> initPayment());

        loadList();

        ckoutView.setVisible(true);

    }

    private void initPayment() {
        if (OrderListController.getInstance().getOrderList().isEmpty()) {
            JOptionPane.showMessageDialog(ckoutView, "Your Order List is Empty!");
        } else {
            PaymentView pView = new PaymentView();
            PaymentController pCrt = new PaymentController(pView);
            ckoutView.dispose();

        }

    }

    private void loadList() {
        List<Object[]> list = OrderListController.getInstance().getOrderList();
        DefaultListModel listModel = new DefaultListModel();

        for (Iterator<Object[]> iterator = list.iterator(); iterator.hasNext();) {
            Object[] next = iterator.next();

            int quantity = (int) next[0];
            String customTxt = "";
            String mealDesc = "";
            

            if (next[1] instanceof MealModel) {
                MealModel itm = (MealModel) next[1];
                List<MenuItemModel> addItems = itm.getMealAditionalItems();
                mealDesc = mealDesc + "(";
                for (MenuItemModel addItem : addItems) {
                    
                    mealDesc = (addItem.getItemSize() == null || addItem.getItemSize().isEmpty()) ? mealDesc+addItem.getItemName()+"/" : mealDesc+addItem.getItemName()+" - " +addItem.getItemSize() +"/";
                }
                if("/".equals(mealDesc.substring(mealDesc.length()-1))){
                    mealDesc = mealDesc.substring(0, mealDesc.length()-1);
                }
                mealDesc = mealDesc + ")";

            }
            MenuItemModel item = (MenuItemModel) next[1];
            List<ItemCustomizationModel> customList = item.getSelectedCustomization();

            for (ItemCustomizationModel objects : customList) {

                customTxt = customTxt + " / " + objects.getTitle();
            }
            String elementTxt = item.getItemName() + " " + item.getItemSize() + "     X       " + quantity;
            if (!customTxt.isEmpty()) {
                elementTxt = elementTxt + mealDesc+" (" + customTxt + ")";
            }else{
                elementTxt = elementTxt + mealDesc;
            }
            listModel.addElement(elementTxt);

        }

        ckoutView.getOrderList().setModel(listModel);

    }

    private void removeSelectedItem() {

        if (ckoutView.getOrderList().getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(ckoutView,
                    "Please, select an Item!",
                    "Wrong Selection",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }
        OrderListController.getInstance().removeItem(ckoutView.getOrderList().getSelectedIndex());
        ckoutView.getLblTotal().setText("Total: €" + String.format("%.2f", OrderListController.getInstance().getTotal()));
        loadList();

        ckoutView.revalidate();
        ckoutView.repaint();
    }

    private void returnMainMenu() {
        ckoutView.dispose();
        MainMenuView view = new MainMenuView();
        MainMenuModel model = new MainMenuModel();
        MainMenuController controller = new MainMenuController(model, view);
        controller.initController();
    }

    private void cancelOrder() {
        OrderListController.resetInstance();
        ckoutView.dispose();
        MainMenuView view = new MainMenuView();
        MainMenuModel model = new MainMenuModel();
        MainMenuController controller = new MainMenuController(model, view);
        controller.initController();

    }

    private void initItemEdition() {

        if (ckoutView.getOrderList().getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(ckoutView,
                    "Please, select an Item!",
                    "Wrong Selection",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        ckoutView.getPnlEdt().setVisible(true);
        edtItemIndex = ckoutView.getOrderList().getSelectedIndex();
        Object[] selectedItem = OrderListController.getInstance().getOrderList().get(ckoutView.getOrderList().getSelectedIndex());

        int quantity = (int) selectedItem[0];
        MenuItemModel item = (MenuItemModel) selectedItem[1];

        ckoutView.getLblEdtItem().setText(ckoutView.getOrderList().getSelectedValue());
        ckoutView.getLblNumItem().setText(String.valueOf(quantity));

    }

    private void incrementItems() {

        Integer numAmount = Integer.valueOf(ckoutView.getLblNumItem().getText());
        numAmount++;
        ckoutView.getLblNumItem().setText(String.valueOf(numAmount));

    }

    private void decrementItems() {

        Integer numAmount = Integer.valueOf(ckoutView.getLblNumItem().getText());
        if (numAmount > 1) {

            numAmount--;
            ckoutView.getLblNumItem().setText(String.valueOf(numAmount));

        }
    }

    private void applyEdition() {

        Object[] selectedItem = OrderListController.getInstance().getOrderList().get(ckoutView.getOrderList().getSelectedIndex());
        MenuItemModel item = (MenuItemModel) selectedItem[1];

        int itemOldQuant = (int) selectedItem[0];

        int itemNewQuant = Integer.valueOf(ckoutView.getLblNumItem().getText());

        OrderListController.getInstance().removeItemTotal(itemOldQuant * item.getPrice());

        selectedItem[0] = Integer.valueOf(ckoutView.getLblNumItem().getText());
        OrderListController.getInstance().getOrderList().set(edtItemIndex, selectedItem);
        OrderListController.getInstance().sumTotal(itemNewQuant * item.getPrice());

        ckoutView.getPnlEdt().setVisible(false);
        ckoutView.getLblTotal().setText("Total: €" + String.format("%.2f", OrderListController.getInstance().getTotal()));

        edtItemIndex = -1;

        loadList();

    }
}
