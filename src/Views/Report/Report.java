
package Views.Report;

import DAOs.PaymentDAO;
import Models.Food;
import Models.Payment;
import Utils.Utils;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Report extends javax.swing.JPanel {

    /**
     * Creates new form Report
     */
    public Report() {
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

        btnPanel = new javax.swing.JPanel();
        btnGenerate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstInterval = new javax.swing.JList<>();
        label1 = new java.awt.Label();
        detailPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportDetailTable = new javax.swing.JTable();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        txtTotal = new javax.swing.JTextField();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        btnPanel.setBackground(new java.awt.Color(255, 255, 255));
        btnPanel.setPreferredSize(new java.awt.Dimension(200, 0));

        btnGenerate.setText("Generate");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        lstInterval.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lstInterval.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1 day", "1 month", "3 months", "1 year", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstInterval.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lstInterval.setSelectedIndex(0);
        jScrollPane2.setViewportView(lstInterval);

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setText("Select a time interval:");

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(btnGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanelLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnGenerate)
                .addGap(103, 103, 103))
        );

        add(btnPanel);

        detailPanel.setBackground(new java.awt.Color(255, 255, 204));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        reportDetailTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reportDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        reportDetailTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        reportDetailTable.setAutoscrolls(false);
        reportDetailTable.setMaximumSize(new java.awt.Dimension(0, 2000));
        reportDetailTable.setRowHeight(25);
        jScrollPane1.setViewportView(reportDetailTable);

        label2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label2.setText("Total earnings:");

        label3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label3.setText("Report");

        javax.swing.GroupLayout detailPanelLayout = new javax.swing.GroupLayout(detailPanel);
        detailPanel.setLayout(detailPanelLayout);
        detailPanelLayout.setHorizontalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(detailPanelLayout.createSequentialGroup()
                        .addGap(0, 183, Short.MAX_VALUE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(detailPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailPanelLayout.setVerticalGroup(
            detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(detailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(detailPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        createReport(lstInterval.getSelectedValue());
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void init(){
        
        reportDetailTableModel= new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Created at", "Payment ID", "Order ID", "CustomerID", "User ID", "Total Paid"
                }
        ){
            Class[] types = new Class[]{
                java.lang.String.class,java.lang.String.class,java.lang.String.class,
                java.lang.String.class,java.lang.String.class,java.lang.Double.class
            };
            boolean[] canEdit = new boolean[]{
                false, false,false, false,false, false
            };
            
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        
        };
        reportDetailTable.setModel(reportDetailTableModel);
    }
    
    public void createReport(String interval) {
        
        reportDetailTable.removeAll();
        
        PaymentDAO paymentDao = new PaymentDAO();
        Utils utils = new Utils();
        ArrayList<Payment> payments = new ArrayList<>();
        Object[] rowData = new Object[6];
        
        payments = paymentDao.searchByTimeInterval(interval);
        txtTotal.setText(Double.toString(utils.caculateTotalPaid(payments))); 
        
        for(int i = 0; i<payments.size();i++){
        rowData[0] = payments.get(i).getCreatedAt();
        rowData[1] = payments.get(i).getID();
        rowData[2] = payments.get(i).getOrder().getId();
        rowData[3] = payments.get(i).getOrder().getCustomer().getId();
        rowData[4] = payments.get(i).getOrder().getUser().getId();
        rowData[5] = payments.get(i).getTotalPaid();
        }
        
        txtTotal.setText(Double.toString(utils.caculateTotalPaid(payments)));
        reportDetailTableModel.addRow(rowData);
    }
    
    DefaultTableModel reportDetailTableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerate;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JList<String> lstInterval;
    private javax.swing.JTable reportDetailTable;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

