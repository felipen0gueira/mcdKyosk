/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.felipe.mckyosk.controller;

import com.felipe.mckyosk.dao.ItemDao;
import com.felipe.mckyosk.model.MainMenuModel;
import com.felipe.mckyosk.view.MainMenuView;
import com.felipe.mckyosk.view.PaymentView;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class PaymentController {

    PaymentView pView;

    public PaymentController(PaymentView pView) {
        this.pView = pView;
        initController();
    }

    public void initController() {
        pView.getLblTotal().setText("Total: €" + String.format("%.2f", OrderListController.getInstance().getTotal()));

        pView.getBtn0().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn1().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn2().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn3().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn4().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn5().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn6().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn7().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn8().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));
        pView.getBtn9().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText() + "#"));

        pView.getBtnBackSpc().addActionListener(e -> pView.getLblPin().setText(pView.getLblPin().getText().substring(0, pView.getLblPin().getText().length() - 1)));

        pView.getBtnCancel().addActionListener(e -> cancelOrder());

        pView.getBtnConfirm().addActionListener(e -> confirm());

        pView.setVisible(true);
    }

    public void confirm() {

        ItemDao dao = new ItemDao();
        int n = dao.insertOrder();
        JOptionPane.showMessageDialog(pView, "Your Order Number is: " + n);
        //insert Order database
        //print number
        //send back to the main menu

        OrderListController.resetInstance();

        MainMenuView view = new MainMenuView();
        MainMenuModel model = new MainMenuModel();
        MainMenuController controller = new MainMenuController(model, view);
        controller.initController();
        pView.dispose();

    }

    public void cancelOrder() {
        OrderListController.resetInstance();

        MainMenuView view = new MainMenuView();
        MainMenuModel model = new MainMenuModel();
        MainMenuController controller = new MainMenuController(model, view);
        controller.initController();
        pView.dispose();
    }

}
