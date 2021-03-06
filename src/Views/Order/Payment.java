/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Order;

import Controller.PaymentController;
import Models.Customer;
import Models.Order;
import Utils.CustomerListCellRenderer;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author PPuarat
 */
public class Payment extends javax.swing.JPanel {

    /**
     * Creates new form Payment
     */
    public Payment(Order order, ArrayList<Models.OrderDetail> orderDetailsList,
            OrderDetail orderDetailPane) {
        initComponents();
        currentOrder = order;
        this.orderDetails = orderDetailsList;
        this.ordetailPanel = orderDetailPane;
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

        jLabel1 = new javax.swing.JLabel();
        customersList = new javax.swing.JComboBox<>();
        cancelBtn = new javax.swing.JButton();
        payBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 750));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Select Customer");

        customersList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        customersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersListActionPerformed(evt);
            }
        });

        cancelBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        payBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        payBtn.setText("Pay");
        payBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(customersList, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(207, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(customersList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(579, Short.MAX_VALUE)
                    .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(131, 131, 131)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void init() {
        paymentCon = new PaymentController();
        paymentMap = paymentCon.initPayment();
        ArrayList<Customer> customers = paymentMap.get("customers");
        customers.forEach((customer) -> {
            customersList.addItem(customer);
        });

        customersList.setRenderer(new CustomerListCellRenderer());

    }

    private void customersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersListActionPerformed
        // TODO add your handling code here:
        selectedCustomer = (Customer) customersList.getSelectedItem();
//        System.out.println("" + customersList.getSelectedItem());
    }//GEN-LAST:event_customersListActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        //Return to orderDetail page
        ordetailPanel.paymentBtnAction(evt);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void payBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBtnActionPerformed
        // TODO add your handling code here:
        if(currentOrder == null){
            JOptionPane.showMessageDialog(ordetailPanel, 
                    "Please create order first!");
            return;
        }
        
        boolean isPaid = paymentCon.pay(currentOrder, orderDetails, selectedCustomer);
        
        if (isPaid) {
            JOptionPane.showMessageDialog(ordetailPanel, 
                    "Success");
            
            ordetailPanel.removeAll();
            ordetailPanel.repaint();
            ordetailPanel.revalidate();
            
            ordetailPanel = new OrderDetail();
            ordetailPanel.repaint();
            ordetailPanel.revalidate();
            
        }else{
            JOptionPane.showMessageDialog(ordetailPanel, 
                    "Something Wrong!");
            
            ordetailPanel.removeAll();
            ordetailPanel.repaint();
            ordetailPanel.revalidate();
            
            ordetailPanel = new OrderDetail();
            ordetailPanel.repaint();
            ordetailPanel.revalidate();
            
        }
    }//GEN-LAST:event_payBtnActionPerformed

    Order currentOrder;
    Customer selectedCustomer;
    ArrayList<Models.OrderDetail> orderDetails;
    Map<String, ArrayList> paymentMap;
    PaymentController paymentCon;
    OrderDetail ordetailPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<Customer> customersList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton payBtn;
    // End of variables declaration//GEN-END:variables
}
