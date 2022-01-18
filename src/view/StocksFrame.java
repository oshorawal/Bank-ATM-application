package view;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author oshorawal
 */
import controller.*;
import model.*;
public class StocksFrame extends javax.swing.JDialog {

    /**
     * Creates new form Stocks_frame
     */
    private StockController stock_controller;
    public StocksFrame() {
        this.stock_controller = new StockController();
        initComponents();
        this.getContentPane().setBackground(Color.GREEN);
        jPanel1.setBackground(Color.GREEN);
        clear_table();
        addDataToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        add_stock_button = new javax.swing.JButton();
        update_price_button = new javax.swing.JButton();
        stocks_panel = new javax.swing.JScrollPane();
        stocks_table = new javax.swing.JTable();
        remove_stock_button = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        add_stock_button.setText("Add Stock");
        add_stock_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_stock_buttonActionPerformed(evt);
            }
        });

        update_price_button.setText("Update Price");
        update_price_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_price_buttonActionPerformed(evt);
            }
        });

        stocks_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Stock Name","Stock Price"
            }
        ));
        stocks_panel.setViewportView(stocks_table);

        remove_stock_button.setText("Remove Stock");
        remove_stock_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_stock_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add_stock_button)
                .addGap(38, 38, 38)
                .addComponent(remove_stock_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(update_price_button)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(stocks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_stock_button)
                    .addComponent(update_price_button)
                    .addComponent(remove_stock_button))
                .addGap(32, 32, 32)
                .addComponent(stocks_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void remove_stock_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_stock_buttonActionPerformed
        // TODO add your handling code here:
        int row_selected = stocks_table.getSelectedRow();
        if (row_selected >= 0){
            remove_stock(row_selected);
            remove_data_from_table(row_selected);
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this,"Select an account in table which you want to delete","Error",javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_remove_stock_buttonActionPerformed

    private void add_stock_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_stock_buttonActionPerformed
        // TODO add your handling code here:
        ManagerStockAddFrame stock_add = new ManagerStockAddFrame(this,true);
        stock_add.setVisible(true);
        clear_table();
        addDataToTable();
    }//GEN-LAST:event_add_stock_buttonActionPerformed

    private void update_price_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_price_buttonActionPerformed
        // TODO add your handling code here:
        UpdateStock update_stock = new UpdateStock(this,true);
        update_stock.setVisible(true);
        clear_table();
        addDataToTable();
//        Updatetable(update_stock.getStock());
    }//GEN-LAST:event_update_price_buttonActionPerformed

      private void remove_data_from_table(int row){
        DefaultTableModel table = (DefaultTableModel) stocks_table.getModel();
        table.removeRow(row);
        }
    
    
    private void remove_stock(int row){
        String stock_name = (String) stocks_table.getValueAt(row,0);
        // Add get_account by account number in bank account controller class.
        OpResponse res ;
        res = stock_controller.removeStock(stock_name);
        
        if(res.status){
            javax.swing.JOptionPane.showMessageDialog(this,res.response,"Message",javax.swing.JOptionPane.PLAIN_MESSAGE);

        }
        else{
            javax.swing.JOptionPane.showMessageDialog(this,res.response,"FAILED",javax.swing.JOptionPane.WARNING_MESSAGE);

        }

    }

    private void addDataToTable(){
        DefaultTableModel table = (DefaultTableModel)  stocks_table.getModel();
        LinkedList<Stock> stockList = (LinkedList<Stock>) stock_controller.getAllStocks().data;
        for (Stock stock : stockList) {
            table.addRow(new Object[]{stock.getName(),stock.getPrice().getAmount()});
        }
    }

    private void Updatetable(Stock stock){
        DefaultTableModel table = (DefaultTableModel)  stocks_table.getModel();
        table.addRow(new Object[]{stock.getName(),stock.getPrice()});
    }

    private void clear_table(){
        DefaultTableModel table = (DefaultTableModel)  stocks_table.getModel();
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            table.removeRow(i);
        }
   }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(StocksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StocksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StocksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StocksFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StocksFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_stock_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton remove_stock_button;
    private javax.swing.JScrollPane stocks_panel;
    private javax.swing.JTable stocks_table;
    private javax.swing.JButton update_price_button;
    // End of variables declaration//GEN-END:variables
}
