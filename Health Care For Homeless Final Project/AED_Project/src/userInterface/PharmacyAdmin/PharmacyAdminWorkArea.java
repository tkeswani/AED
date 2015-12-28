/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.PharmacyAdmin;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.PharmacyOrganization;
import Business.Pharmacy.Drug;
import Business.Pharmacy.Order;
import Business.Pharmacy.Supplier;
import Business.Pharmacy.SupplierDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tarun
 */
public class PharmacyAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form PharmacyAdminWorkArea
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private EcoSystem business;
    private OrganizationDirectory organizationDirectory;
    public PharmacyAdminWorkArea(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, EcoSystem business, OrganizationDirectory organizationDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.business = business;
        this.organizationDirectory = organizationDirectory;
        
        populateOrganizationListComboBox();
        populateSupplierListComboBox();
        populateSupplierComboBox();
        
    }
    
    
    public void populateSupplierComboBox() {
        supplierComboBox.removeAllItems();
        PharmacyOrganization org = null;
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
            for(Organization organization: enterprise.getOrgDir().getOrganizationList()) {
                if(organization instanceof PharmacyOrganization) {
                    org = (PharmacyOrganization) organization;
                    break;
                }
            }
            if(!(org.getSupplierDir().getSupplierList().isEmpty())) {
            for(Supplier supplier : org.getSupplierDir().getSupplierList()) {
                supplierComboBox.addItem(supplier);
                
            }
            }
        }
    }

    public void populateSupplierListComboBox() {
        
        supplierListComboBox.removeAllItems();
        PharmacyOrganization org = null;
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
            for(Organization organization: enterprise.getOrgDir().getOrganizationList()) {
                if(organization instanceof PharmacyOrganization) {
                    org = (PharmacyOrganization) organization;
                    break;
                }
            }
            if(!(org.getSupplierDir().getSupplierList().isEmpty())) {
            for(Supplier supplier : org.getSupplierDir().getSupplierList()) {
                supplierListComboBox.addItem(supplier);
                populateMedicineListTable(supplier);
            }
            }
        }
    }
    public void populateOrganizationListComboBox() {
        organizationListComboBox.removeAllItems();
        
        for(Organization.Type type: Organization.Type.values()) {
            if(type.getValue().equals(type.Pharmacy.getValue())) {
                organizationListComboBox.addItem(type);
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addOrganizationComboBox = new javax.swing.JButton();
        organizationListComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        supplierNameTxtField = new javax.swing.JTextField();
        addSupplierBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        supplierListComboBox = new javax.swing.JComboBox();
        medicineNameTxtField = new javax.swing.JTextField();
        marketPriceTxtField = new javax.swing.JTextField();
        quantitySpinner = new javax.swing.JSpinner();
        addToInventoryBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineListTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        supplierComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicineInventoryTable = new javax.swing.JTable();
        updateBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        medQtySpinner = new javax.swing.JSpinner();
        manageInventoryLabel = new javax.swing.JLabel();

        jLabel1.setText("DEPARTMENT NAME");

        addOrganizationComboBox.setText("ADD DEPARTMENT");
        addOrganizationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrganizationComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/PharmacyAdmin/pharmacy banner.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(476, 476, 476)
                        .addComponent(jLabel1)
                        .addGap(79, 79, 79)
                        .addComponent(organizationListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(578, 578, 578)
                        .addComponent(addOrganizationComboBox)))
                .addContainerGap(1074, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addGap(172, 172, 172)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(organizationListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(addOrganizationComboBox)
                .addContainerGap(546, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DEPARTMENTS", jPanel1);

        jLabel4.setText("SUPPLIER NAME");

        addSupplierBtn.setText("ADD SUPPLIER");
        addSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSupplierBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(jLabel4)
                        .addGap(86, 86, 86)
                        .addComponent(supplierNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(548, 548, 548)
                        .addComponent(addSupplierBtn)))
                .addContainerGap(1387, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(supplierNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(addSupplierBtn)
                .addContainerGap(819, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ADD SUPPLIER", jPanel2);

        jLabel2.setText("SUPPLIERS");

        jLabel3.setText("NAME");

        jLabel5.setText("MARKET PRICE");

        jLabel6.setText("QUANTITY");

        supplierListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierListComboBoxActionPerformed(evt);
            }
        });

        addToInventoryBtn.setText("ADD TO INVENTORY");
        addToInventoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToInventoryBtnActionPerformed(evt);
            }
        });

        medicineListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICINE NAME", "MARKET PRICE", "QUANTITY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(medicineListTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(supplierListComboBox, 0, 150, Short.MAX_VALUE)
                                .addComponent(medicineNameTxtField)
                                .addComponent(marketPriceTxtField))
                            .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(527, 527, 527)
                        .addComponent(addToInventoryBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1360, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(supplierListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(medicineNameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(marketPriceTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addComponent(addToInventoryBtn)
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(425, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ADD MEDICINES", jPanel3);

        jLabel7.setText("SUPPLIER");

        supplierComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierComboBoxActionPerformed(evt);
            }
        });

        medicineInventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICINE NAME", "MARKET PRICE", "QUANTITY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(medicineInventoryTable);

        updateBtn.setText("UPDATE");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("QUANTITY");

        manageInventoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/PharmacyAdmin/Medicine Inventory.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(manageInventoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(475, 475, 475)
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28)
                        .addComponent(medQtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(updateBtn))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jLabel7)
                                .addGap(37, 37, 37)
                                .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(716, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(manageInventoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(medQtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn))
                .addGap(234, 234, 234))
        );

        jTabbedPane1.addTab("MANAGE INVENTORY", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = medicineInventoryTable.getSelectedRow();
        if(selectedRow>=0) {
            Drug drug = (Drug) medicineInventoryTable.getValueAt(selectedRow, 0);

            int quantity = (int) medQtySpinner.getValue();
            int availableQuantity = drug.getQuantity();

            if(quantity <=0) {
                JOptionPane.showMessageDialog(this, "Please Enter A Value!!!");
            }
            else {
                int totalQty = quantity + availableQuantity;
                drug.setQuantity(totalQty);
                populateMedicineInventoryTable();
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Select A Row!!!");
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void supplierComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierComboBoxActionPerformed
        // TODO add your handling code here:

        populateMedicineInventoryTable();
    }//GEN-LAST:event_supplierComboBoxActionPerformed

    private void addToInventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToInventoryBtnActionPerformed
        // TODO add your handling code here:
        Drug d;
        int flag = 0;
        Supplier supplier = (Supplier) supplierListComboBox.getSelectedItem();
        if(supplier == null) {
            JOptionPane.showMessageDialog(this, "Supplier Not Available!!!");
        }
        else {

            if(medicineNameTxtField.getText().isEmpty() || (!(medicineNameTxtField.getText().matches("[a-zA-Z]+")))) {
                JOptionPane.showMessageDialog(this, "Enter A Valid Name Of The Medicine!!!");
            }
            else {
                String name = medicineNameTxtField.getText();
                if((marketPriceTxtField.getText().isEmpty()) || (!(marketPriceTxtField.getText().matches("[0-9.]+")))) {
                    JOptionPane.showMessageDialog(this, "Enter A Valid Price!!!");
                }
                else {
                    if(!(supplier.getDrugList().isEmpty())) {
                    for(Drug drug : supplier.getDrugList()) {
                        if(drug.getName().equalsIgnoreCase(name)) {
                            JOptionPane.showMessageDialog(this, "Medicine Already Present Of That Supplier!!!");
                            flag = 1;
                            populateMedicineListTable(supplier);
                            medicineNameTxtField.setText("");
                            marketPriceTxtField.setText("");
                            break;
                        }
                    }
                    if(flag == 0) {
                       float marketPrice = Float.parseFloat(marketPriceTxtField.getText());
                    int quantity = (int) quantitySpinner.getValue();
                    if(quantity <=0) {
                        JOptionPane.showMessageDialog(this, "Enter A Valid Quantity!!!");
                    }
                    else {
                        Drug drug = supplier.addDrug();
                        drug.setName(name);
                        drug.setMarketPrice(marketPrice);
                        drug.setQuantity(quantity);

                        populateMedicineListTable(supplier);
                        medicineNameTxtField.setText("");
                        marketPriceTxtField.setText("");
                    }
                    }
                    }
                    else {
                    float marketPrice = Float.parseFloat(marketPriceTxtField.getText());
                    int quantity = (int) quantitySpinner.getValue();
                    if(quantity <=0) {
                        JOptionPane.showMessageDialog(this, "Enter A Valid Quantity!!!");
                    }
                    else {
                        Drug drug = supplier.addDrug();
                        drug.setName(name);
                        drug.setMarketPrice(marketPrice);
                        drug.setQuantity(quantity);

                        populateMedicineListTable(supplier);
                        medicineNameTxtField.setText("");
                        marketPriceTxtField.setText("");
                    }
                }
                }
            }
        }
    }//GEN-LAST:event_addToInventoryBtnActionPerformed

    private void supplierListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierListComboBoxActionPerformed
        // TODO add your handling code here:
        Supplier supplier = (Supplier) supplierListComboBox.getSelectedItem();
        populateMedicineListTable(supplier);
    }//GEN-LAST:event_supplierListComboBoxActionPerformed

    private void addSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSupplierBtnActionPerformed
        // TODO add your handling code here:
        String supplierName = supplierNameTxtField.getText();
        int flag = 0;
        PharmacyOrganization org = null;
        if((supplierNameTxtField.getText().isEmpty()) || (!(supplierNameTxtField.getText().matches("[a-zA-Z]+")))) {
            JOptionPane.showMessageDialog(this, "Invalid Input!!!");
        }

        else if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
            for(Organization organization: enterprise.getOrgDir().getOrganizationList()) {
                if(organization instanceof PharmacyOrganization) {
                    org = (PharmacyOrganization)organization;
                    break;
                }
            }

            if(!(org.getSupplierDir().getSupplierList().isEmpty())) {
                for(Supplier supp : org.getSupplierDir().getSupplierList()) {
                    if(supp.getName().equalsIgnoreCase(supplierName)) {
                        JOptionPane.showMessageDialog(this, "Supplier Already Present!!!");
                        flag =1;
                        break;
                    }
                }
                if(flag == 0) {
                    Supplier supplier = org.getSupplierDir().addSupplier();
                    supplier.setName(supplierName);

                    populateSupplierListComboBox();
                    populateSupplierComboBox();
                    supplierNameTxtField.setText("");
                    JOptionPane.showMessageDialog(this, "Supplier Has Been Added!!!");
                }
            }
            else {
                Supplier supplier = org.getSupplierDir().addSupplier();
                supplier.setName(supplierName);

                populateSupplierListComboBox();
                populateSupplierComboBox();
                supplierNameTxtField.setText("");
                JOptionPane.showMessageDialog(this, "Supplier Has Been Added!!!");
            }
        }
    }//GEN-LAST:event_addSupplierBtnActionPerformed

    private void addOrganizationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOrganizationComboBoxActionPerformed
        // TODO add your handling code here:
        Organization.Type type = (Organization.Type) organizationListComboBox.getSelectedItem();
        int flag = 0;
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
            for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
                if(organization.getName().equals(type.getValue())) {
                    JOptionPane.showMessageDialog(this, "Department Already Added!!!");
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0) {
            organizationDirectory.createOrganization(type);

            JOptionPane.showMessageDialog(this, "Department Has Been Added!!!");
        }

    }//GEN-LAST:event_addOrganizationComboBoxActionPerformed

    
    public void populateMedicineInventoryTable() {
        DefaultTableModel model = (DefaultTableModel)medicineInventoryTable.getModel();
        Supplier supplier = (Supplier) supplierComboBox.getSelectedItem();
        model.setRowCount(0);
        if(supplier!=null) {
            if(!(supplier.getDrugList().isEmpty())) {
                for(Drug drug : supplier.getDrugList()) {
                Object[] row = new Object[3];
                row[0] = drug.getName();
                row[1] = drug.getMarketPrice();
                row[2] = drug.getQuantity();
            
                model.addRow(row);
                }
            }
        }
    }
    public void populateMedicineListTable(Supplier supplier) {
        DefaultTableModel model = (DefaultTableModel)medicineListTable.getModel();
        
        model.setRowCount(0);
        if(supplier != null) {
        for(Drug drug : supplier.getDrugList()) {
            Object[] row = new Object[3];
            row[0] = drug.getName();
            row[1] = drug.getMarketPrice();
            row[2] = drug.getQuantity();
            
            model.addRow(row);
        }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrganizationComboBox;
    private javax.swing.JButton addSupplierBtn;
    private javax.swing.JButton addToInventoryBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel manageInventoryLabel;
    private javax.swing.JTextField marketPriceTxtField;
    private javax.swing.JSpinner medQtySpinner;
    private javax.swing.JTable medicineInventoryTable;
    private javax.swing.JTable medicineListTable;
    private javax.swing.JTextField medicineNameTxtField;
    private javax.swing.JComboBox organizationListComboBox;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JComboBox supplierComboBox;
    private javax.swing.JComboBox supplierListComboBox;
    private javax.swing.JTextField supplierNameTxtField;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
