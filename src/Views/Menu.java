/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.Components.MenuButton;
import javax.swing.JPanel;

/**
 *
 * @author PPuarat
 */
public class Menu extends javax.swing.JPanel {

    private JPanel JPanel1;
    private javax.swing.JButton newOrder;
    private javax.swing.JButton orders;
    private javax.swing.JButton reports;
    private javax.swing.JButton settings;

    /**
     * Creates new form Menu
     */
    public Menu(JPanel inputJP) {
        JPanel1 = inputJP;
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents
    private void btnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JPanel1.setBackground(new java.awt.Color(
                (int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)));

    }

    private void init() {
        newOrder = new MenuButton("New Order");
        newOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        add(newOrder);
        
        orders = new MenuButton("Orders");
        add(orders);
        
        reports = new MenuButton("Reports");
        add(reports);
        
        settings = new MenuButton("Settings");
        add(settings);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
