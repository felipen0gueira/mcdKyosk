/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.felipe.mckyosk.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author felip
 */
public class ItemView extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ItemView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnAddOrder = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnCustomize = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btbPlus = new javax.swing.JButton();
        lblNumItem = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblPrice = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        cbDrink = new javax.swing.JComboBox<>();
        cbSide = new javax.swing.JComboBox<>();
        lblDrink = new javax.swing.JLabel();
        lblSide = new javax.swing.JLabel();
        lblTotal1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitle.setText("Title");

        btnAddOrder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAddOrder.setText("Add to Order");

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancel.setText("Cancel");

        btnCustomize.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCustomize.setText("Customize");

        btnMinus.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnMinus.setText("-");

        btbPlus.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btbPlus.setText("+");

        lblNumItem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblNumItem.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );

        lblPrice.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPrice.setText("€0");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTotal.setText("€0");

        cbDrink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbDrink.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Drink" }));

        cbSide.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cbSide.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Side" }));

        lblDrink.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblDrink.setText("Drink");

        lblSide.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSide.setText("Side");

        lblTotal1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTotal1.setText("Total");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269)
                        .addComponent(btnAddOrder))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(btnMinus)
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNumItem)
                                .addGap(84, 84, 84)
                                .addComponent(btbPlus))
                            .addComponent(lblPrice)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(lblTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCustomize))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDrink)
                            .addComponent(lblSide))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSide, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbDrink, 0, 314, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrice)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDrink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDrink))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSide))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMinus)
                    .addComponent(btbPlus)
                    .addComponent(lblNumItem))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotal1))
                .addGap(18, 18, 18)
                .addComponent(btnCustomize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbPlus;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCustomize;
    private javax.swing.JButton btnMinus;
    private javax.swing.JComboBox<String> cbDrink;
    private javax.swing.JComboBox<String> cbSide;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDrink;
    private javax.swing.JLabel lblNumItem;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSide;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotal1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtbPlus() {
        return btbPlus;
    }

    public void setBtbPlus(JButton btbPlus) {
        this.btbPlus = btbPlus;
    }

    public JButton getBtnAddOrder() {
        return btnAddOrder;
    }

    public void setBtnAddOrder(JButton btnAddOrder) {
        this.btnAddOrder = btnAddOrder;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JButton getBtnCustomize() {
        return btnCustomize;
    }

    public void setBtnCustomize(JButton btnCustomize) {
        this.btnCustomize = btnCustomize;
    }

    public JButton getBtnMinus() {
        return btnMinus;
    }

    public void setBtnMinus(JButton btnMinus) {
        this.btnMinus = btnMinus;
    }

    public JComboBox<String> getCbDrink() {
        return cbDrink;
    }

    public void setCbDrink(JComboBox<String> cbDrink) {
        this.cbDrink = cbDrink;
    }

    public JComboBox<String> getCbSide() {
        return cbSide;
    }

    public void setCbSide(JComboBox<String> cbSide) {
        this.cbSide = cbSide;
    }

    public JLabel getLblDrink() {
        return lblDrink;
    }

    public void setLblDrink(JLabel lblDrink) {
        this.lblDrink = lblDrink;
    }

    public JLabel getLblNumItem() {
        return lblNumItem;
    }

    public void setLblNumItem(JLabel lblNumItem) {
        this.lblNumItem = lblNumItem;
    }

    public JLabel getLblPrice() {
        return lblPrice;
    }

    public void setLblPrice(JLabel lblPrice) {
        this.lblPrice = lblPrice;
    }

    public JLabel getLblSide() {
        return lblSide;
    }

    public void setLblSide(JLabel lblSide) {
        this.lblSide = lblSide;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JLabel getLblTotal() {
        return lblTotal;
    }

    public void setLblTotal(JLabel lblTotal) {
        this.lblTotal = lblTotal;
    }

   }
