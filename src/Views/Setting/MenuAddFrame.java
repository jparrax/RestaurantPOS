/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Setting;


import DAOs.FoodDAO;
import DAOs.FoodTypeDAO;
import Models.Food;
import Models.FoodType;
import Utils.Settings;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author patricia.garcia
 */
public class MenuAddFrame extends javax.swing.JFrame {
    
    public long aux;

    /**
     * Creates new form MenuAddFrame
     */
    public MenuAddFrame() {
        initComponents();
        initList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescription = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblCategory = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblFood = new javax.swing.JLabel();
        txtFood = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFoodTypes = new javax.swing.JList<>();

        setTitle("Add New Menu");

        lblDescription.setText("Description");

        lblPrice.setText("Price");

        lblCategory.setText("Category");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblFood.setText("Food Name");

        jScrollPane1.setViewportView(lstFoodTypes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescription)
                            .addComponent(lblPrice)
                            .addComponent(lblFood)
                            .addComponent(lblCategory))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFood)
                            .addComponent(jScrollPane1))))
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFood)
                    .addComponent(txtFood, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnClose))
                        .addGap(53, 53, 53))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategory)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getAccessibleContext().setAccessibleName("Add New Menu ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        addMenu(); 
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);

    }//GEN-LAST:event_btnCloseActionPerformed

 public void addMenu(){
     
     String foodName = txtFood.getText();
     String description = txtDescription.getText();
     String price = txtPrice.getText();
     
     System.out.println("fernando: " + lstFoodTypes.getSelectedValue());
     
     long category = lstFoodTypes.getSelectedValue();
     
     FoodTypeDAO foodTypeDao = new FoodTypeDAO();
     ArrayList<FoodType> foodTypes = new ArrayList<>();
     foodTypes = foodTypeDao.searchAll();
     FoodDAO foodDao = new FoodDAO(foodTypes);
             
    foodDao.addMenu(foodName, description, price, category);
     
     txtFood.setText(null);
     txtDescription.setText(null);
     txtPrice.setText(null);
     lstFoodTypes.clearSelection();
 
 }
 
 private void initList(){
 
     FoodTypeDAO foodTypeDao = new FoodTypeDAO();
     ArrayList<FoodType> foodTypes = new ArrayList<>();
     defaultListModel = new DefaultListModel<String>();
     
     foodTypes = foodTypeDao.searchAll();
     
     
     for(int i = 0; i < foodTypes.size() ; i++){
     
         defaultListModel.addElement(foodTypes.get(i).getId());
     }
     
     lstFoodTypes.setModel(defaultListModel);
    
    }

    
    DefaultListModel defaultListModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFood;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JList<Long> lstFoodTypes;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtFood;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}

