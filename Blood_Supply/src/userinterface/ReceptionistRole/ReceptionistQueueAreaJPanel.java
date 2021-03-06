/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReceptionistRole;

import Business.Donor.Donor;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DonorOrganization;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Organization.ReceptionistOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tarun
 */
public class ReceptionistQueueAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReceptionistQueueAreaJPanel
     */
    private JPanel userProcessContainer;
    private Organization org;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private DonorOrganization donorOrg;
    private Employee employee;
    public ReceptionistQueueAreaJPanel(JPanel userProcessContainer, Organization org, Enterprise enterprise, UserAccount userAccount, Employee employee) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.org = (ReceptionistOrganization)org;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.employee = employee;
        
//     for(Organization org : enterprise.getOrgDir().getOrgList())
//        if(org.getName().equals(Type.Donor.getValue()))
//            donorOrg = (DonorOrg)org;
        ///populateComboBox();
        populateTable();
    }
    
       
    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel)donorListTable.getModel();
        for(Organization orgn : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(orgn.getName().equals(Organization.Type.Donor.getValue())) {
                donorOrg = (DonorOrganization) orgn;
                
                
            }
        }
        model.setRowCount(0);
               
        for(WorkRequest request: userAccount.getWorkQueue().getWorkRequestList()) {
            if(((LabTestWorkRequest) request).getDonor().equals(employee) && (!request.getStatus().equals("Completed"))) {
            Object row[] = new Object[7];
            row[0] = request.getMessage();
            row[1] = ((LabTestWorkRequest) request).getDonor();
            row[2] = request.getReceiver();
            row[3] = request.getStatus();
            String result = ((LabTestWorkRequest) request).getTestResult();
            row[4] = result == null ? "Waiting" : result;
            row[5] = request.getRequestDate();
            row[6] = request.getResolveDate();
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        donorListTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        requestTest = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        donorListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Donor Name", "Receiver", "Status", "Result", "Request Date", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(donorListTable);

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        requestTest.setText("Request Test");
        requestTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestActionPerformed(evt);
            }
        });

        backBtn.setText(">> BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(refreshBtn)
                        .addGap(62, 62, 62)
                        .addComponent(backBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(requestTest))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(423, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshBtn)
                    .addComponent(requestTest)
                    .addComponent(backBtn))
                .addContainerGap(421, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void requestTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestActionPerformed
        // TODO add your handling code here:
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("RequestTest", new RequestBloodTestJPanel(userProcessContainer, donorOrg, enterprise));
//        layout.next(userProcessContainer);
        
        
        LabTestWorkRequest request = new LabTestWorkRequest();
        request.setMessage("Donate");
        request.setDonor(employee);
        request.setStatus("Sent");
        request.setSender(userAccount);
        request.setRequestDate(new Date());
        
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof NurseOrganization){
                userAccount.getWorkQueue().getWorkRequestList().add(request);
                org.getWorkQueue().getWorkRequestList().add(request);
                break;
            }
        }
        donorOrg.getWorkQueue().getWorkRequestList().add(request);
        populateTable();
    }//GEN-LAST:event_requestTestActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable donorListTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton requestTest;
    // End of variables declaration//GEN-END:variables
}
