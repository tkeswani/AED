/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.NGOAdmin;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.Person.Person;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AdminWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import userInterface.MainJFrame;

/**
 *
 * @author Tarun
 */
public class NGOAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form NGOAdminWorkArea
     */
    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private UserAccount userAccount;
    private Enterprise enterprise;
    public NGOAdminWorkArea(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, UserAccount userAccount, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        
        populateOrganizationComboBox();
        populateOrganizationWorkQueueListComboBox();
        populateOrgEmpListComboBox();
        populateUsernameRoleTable();
        populateOrganizationTable();
        //populateOrgQueueListComboBox();
        //populateAdminWorkQueue();
    }

   
    // Populate Organization Combo Box in Employee Queue Tab
    public void populateOrganizationWorkQueueListComboBox() {
        orgQueueListComboBox.removeAllItems();
        
        for(Organization organization:enterprise.getOrgDir().getOrganizationList()) {
            if(organization.getName().equals("NGO Doctor Organization") || organization.getName().equals("Volunteers Organization")) {
                orgQueueListComboBox.addItem(organization);
            }
        }
        
    }
    
    // Populating the table with employees who are in pending state and want to join the NGO clinic
    public void populateAdminWorkQueue() {
        DefaultTableModel model = (DefaultTableModel)employeeQueueTable.getModel();
        Organization organization = (Organization) orgQueueListComboBox.getSelectedItem();
        model.setRowCount(0);

           System.out.println("IN THE NGO ORGANIZATION");
           if(organization!=null) {
               System.out.println("ORGANIZATION NOT NULL" + enterprise.getOrgDir().getOrganizationList());
           if(!(organization.getWorkQueue().getWorkRequestList().isEmpty())) {
               System.out.println("ORGANIZATION NOT EMPTY");
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            //if(request.getApplicationStatus().equals("PENDING")) {
            Object[] row = new Object[6];
            row[0] = (AdminWorkRequest)request;
            row[1] = request.getAddress();
            row[2] = request.getPhoneNo();
            row[3] = request.getGender();
            row[4] = request.getDesignation();
            row[5] = request.getApplicationStatus();
            
            model.addRow(row);
       
       }
           }
           }
      //  }
    }
    
    //Populate Organization Combo Box in Organization Tab
    public void populateOrganizationComboBox() {
        organizationComboBox.removeAllItems();
        
        for(Organization.Type type: Organization.Type.values()) {
            if(type.getValue().equals(type.NGO_Doctor.getValue()) || type.getValue().equals(type.Patient.getValue()) || type.getValue().equals(type.Pharmacy.getValue()) || type.getValue().equals(type.Volunteers.getValue())) {
                organizationComboBox.addItem(type);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        organizationComboBox = new javax.swing.JComboBox();
        createOrgBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeQueueTable = new javax.swing.JTable();
        acceptBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        orgQueueListComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        usernameRoleTable = new javax.swing.JTable();
        orgEmpListComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        empComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        usernameTxtField = new javax.swing.JTextField();
        passwordTxtField = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();

        organizationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DEPARTMENT ID", "DEPARTMENT NAME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationTable);

        jLabel1.setText("DEPARTMENT");

        createOrgBtn.setText("CREATE DEPARTMENT");
        createOrgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOrgBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(organizationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(476, 476, 476)
                        .addComponent(createOrgBtn)))
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(organizationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(createOrgBtn)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DEPARTMENTS", jPanel1);

        employeeQueueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "ADDRESS", "PHONE NUMBER", "GENDER", "DESIGNATION", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(employeeQueueTable);

        acceptBtn.setText("ACCEPT");
        acceptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptBtnActionPerformed(evt);
            }
        });

        rejectBtn.setText("REJECT");
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("DEPARTMENT");

        orgQueueListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgQueueListComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(orgQueueListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(acceptBtn)
                        .addGap(120, 120, 120)
                        .addComponent(rejectBtn)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(orgQueueListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptBtn)
                    .addComponent(rejectBtn))
                .addContainerGap(419, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EMPLOYEE QUEUE", jPanel2);

        jLabel3.setText("DEPARTMENT");

        usernameRoleTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EMPLOYEE USERNAME", "EMPLOYEE ROLE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(usernameRoleTable);

        orgEmpListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgEmpListComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("EMPLOYEE");

        jLabel5.setText("EMPLOYEE ROLE");

        jLabel6.setText("USERNAME");

        jLabel7.setText("PASSWORD");

        submitBtn.setText("SUBMIT");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(orgEmpListComboBox, 0, 151, Short.MAX_VALUE)
                            .addComponent(empComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(roleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameTxtField)
                            .addComponent(passwordTxtField)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(submitBtn)))
                .addContainerGap(451, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(orgEmpListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(empComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(submitBtn)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MANAGE EMPLOYEE", jPanel3);

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

    private void createOrgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createOrgBtnActionPerformed
        // TODO add your handling code here:
        Type type = (Organization.Type) organizationComboBox.getSelectedItem();
        int flag = 0;
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
        for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
            if(organization.getName().equals(type.getValue())) {
                JOptionPane.showMessageDialog(this, "Ogranization Already Added!!!");
                flag = 1;
                break;
            }
        }
        if(flag == 0) {
            enterprise.getOrgDir().createOrganization(type);
        //organizationDirectory.createOrganization(type);
        
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setEnabledAt(2, true);
        populateOrganizationTable();
        populateOrganizationWorkQueueListComboBox();
        
        }
        }
        else {
        enterprise.getOrgDir().createOrganization(type);
        //organizationDirectory.createOrganization(type);
        
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setEnabledAt(2, true);
        populateOrganizationTable();
        populateOrganizationWorkQueueListComboBox();
        }
    }//GEN-LAST:event_createOrgBtnActionPerformed

    private void orgQueueListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgQueueListComboBoxActionPerformed
        // TODO add your handling code here:
          Organization organization = (Organization) orgQueueListComboBox.getSelectedItem();
          populateAdminWorkQueue();
    }//GEN-LAST:event_orgQueueListComboBoxActionPerformed

    private void acceptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = employeeQueueTable.getSelectedRow();
        
        if(selectedRow >= 0) {
                WorkRequest request =  (WorkRequest) employeeQueueTable.getValueAt(selectedRow, 0);
                if(request.getApplicationStatus().equals("APPROVED")) {
                    JOptionPane.showMessageDialog(this, "Already an approved employee!!!");
                }
                else {
                    System.out.println(request.getName());
                    Organization organization = (Organization) orgQueueListComboBox.getSelectedItem();
                    Employee employee = new Employee();
                    ArrayList<Person> person;
                    person = organization.getPersonDirectory().getPersonList();
                
                    person.add(employee);
                    employee.setName(request.getName());
                    employee.setGender(request.getGender());
                    employee.setDesignation(request.getDesignation());
                    
                    //Employee emp = organization.getEmployeeDirectory().createEmployee(request.getName());
                    request.setApplicationStatus("APPROVED");
                    JOptionPane.showMessageDialog(this, "Employee has been added to the Organization");
                    
                    TwilioRestClient client = new TwilioRestClient("ACd4d9c14696f348fe21e4506a5e7b14e3", "d83be392f0c78d3a493675bf8d7942f1");
            
                                List<NameValuePair> params = new ArrayList<NameValuePair>();
                                params.add(new BasicNameValuePair("To", "+18577076050"));
                                params.add(new BasicNameValuePair("From", "+19073122832"));
                                params.add(new BasicNameValuePair("Body", "You Are Now Part Of Our Organization"));
            
                                MessageFactory messageFactory = client.getAccount().getMessageFactory();
                                try {
                                    com.twilio.sdk.resource.instance.Message  message = (com.twilio.sdk.resource.instance.Message) messageFactory.create(params);
                                } catch (TwilioRestException ex) {
                                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
        
                    populateAdminWorkQueue();
                }
        }
        else {
            JOptionPane.showMessageDialog(this, "Select Employee!!!");
        }
        
    }//GEN-LAST:event_acceptBtnActionPerformed

    // Calling the Populating combo box of Role and Employee based on the organization selected on Manage Employee Tab
    private void orgEmpListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgEmpListComboBoxActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization) orgEmpListComboBox.getSelectedItem();
        populateEmployeeComboBox(organization);
        populateRoleComboBox(organization);
    }//GEN-LAST:event_orgEmpListComboBoxActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        int flag =0;
        String username = usernameTxtField.getText();
        String password = passwordTxtField.getText();
        Organization organization = (Organization)orgEmpListComboBox.getSelectedItem();
        Employee employee = (Employee)empComboBox.getSelectedItem();
        Role role = (Role)roleComboBox.getSelectedItem();
        if(username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter A Valid Username/Password");
        }
        else if(!(usernameTxtField.getText().matches("[a-zA-Z0-9]+"))) {
            JOptionPane.showMessageDialog(this, "Enter A Valid Username!!!");
        }
        else if(!(passwordTxtField.getText().matches("[a-zA-Z0-9\\!%#@$]+"))) {
            JOptionPane.showMessageDialog(this, "Enter A Valid Password!!!");
        }
        else {
            if(!(organization.getUserAccountDirectory().getUserAccountList().isEmpty())) {
            for(UserAccount account:organization.getUserAccountDirectory().getUserAccountList()) {
                if(account.getUsername().equalsIgnoreCase(username)) {
                    JOptionPane.showMessageDialog(this, "User With Same Username Already Present!!!");
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                organization.getUserAccountDirectory().createUserAccount(username, password, employee, role);
            
            populateUsernameRoleTable();
            JOptionPane.showMessageDialog(this, "User Account Has Been Created!!!");
            usernameTxtField.setText("");
            passwordTxtField.setText("");
            }
            }
            else {
                organization.getUserAccountDirectory().createUserAccount(username, password, employee, role);
            
            populateUsernameRoleTable();
            JOptionPane.showMessageDialog(this, "User Account Has Been Created!!!");
            usernameTxtField.setText("");
            passwordTxtField.setText("");
            }
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    public void populateUsernameRoleTable() {
        DefaultTableModel model = (DefaultTableModel)usernameRoleTable.getModel();
        
        model.setRowCount(0);
        for(Organization organization:enterprise.getOrgDir().getOrganizationList()) {
            for(UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object[] row = new Object[2];
                row[0] = ua.getUsername();
                row[1] = ua.getRole();
                
                model.addRow(row);
            }
        }
    }
    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = employeeQueueTable.getSelectedRow();
        if(selectedRow>=0) {
        WorkRequest request = (WorkRequest)employeeQueueTable.getValueAt(selectedRow, 0);
        if(request.getApplicationStatus().equals("APPROVED")) {
            JOptionPane.showMessageDialog(this, "Employee Cannot Be Rejected!!!");
        }
        else if (request.getApplicationStatus().equals("DISCARD")) {
            JOptionPane.showMessageDialog(this, "Candidate Already Rejected!!!");
        }
        else {
        Organization organization = (Organization)orgEmpListComboBox.getSelectedItem();
        organization.getPersonDirectory().getPersonList().remove(request);
        request.setApplicationStatus("DISCARD");
        TwilioRestClient client = new TwilioRestClient("ACd4d9c14696f348fe21e4506a5e7b14e3", "d83be392f0c78d3a493675bf8d7942f1");
            
                                List<NameValuePair> params = new ArrayList<NameValuePair>();
                                params.add(new BasicNameValuePair("To", "+18577076050"));
                                params.add(new BasicNameValuePair("From", "+19073122832"));
                                params.add(new BasicNameValuePair("Body", "Your Application Has Not Been Accepted"));
            
                                MessageFactory messageFactory = client.getAccount().getMessageFactory();
                                try {
                                    com.twilio.sdk.resource.instance.Message  message = (com.twilio.sdk.resource.instance.Message) messageFactory.create(params);
                                } catch (TwilioRestException ex) {
                                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                JOptionPane.showMessageDialog(this, "Rejected!!!");
                                populateAdminWorkQueue();
        
        }
        }
        else {
            JOptionPane.showMessageDialog(this, "Select A Employee!!!");
        }
    }//GEN-LAST:event_rejectBtnActionPerformed

    // Populating Role Combo Box on Manage Employee Tab
    public void populateRoleComboBox(Organization organization) {
        roleComboBox.removeAllItems();
        
        for(Role role : organization.getSupportedRole()) {
            roleComboBox.addItem(role);
        }
    }
    
    // Populate Organization Combo Box on Manage Employee Tab
    public void populateOrgEmpListComboBox() {
        orgEmpListComboBox.removeAllItems();
        
        for(Organization organization:enterprise.getOrgDir().getOrganizationList()) {
            if(organization.getName().equals("NGO Doctor Organization") || organization.getName().equals("Volunteers Organization")) { 
            orgEmpListComboBox.addItem(organization);
            }
        }
    }
    public void populateEmployeeComboBox(Organization organization) {
        empComboBox.removeAllItems();
        for(Person employee:organization.getPersonDirectory().getPersonList()) {
            empComboBox.addItem(employee);
        }
        
    }
    public void populateOrganizationTable() {
        DefaultTableModel model = (DefaultTableModel)organizationTable.getModel();
        
        model.setRowCount(0);
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
        for(Organization organization:enterprise.getOrgDir().getOrganizationList()) {
            Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            
            model.addRow(row);
        }
        }
        else {
            jTabbedPane1.setEnabledAt(1, false);
            jTabbedPane1.setEnabledAt(2, false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptBtn;
    private javax.swing.JButton createOrgBtn;
    private javax.swing.JComboBox empComboBox;
    private javax.swing.JTable employeeQueueTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox orgEmpListComboBox;
    private javax.swing.JComboBox orgQueueListComboBox;
    private javax.swing.JComboBox organizationComboBox;
    private javax.swing.JTable organizationTable;
    private javax.swing.JTextField passwordTxtField;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JComboBox roleComboBox;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTable usernameRoleTable;
    private javax.swing.JTextField usernameTxtField;
    // End of variables declaration//GEN-END:variables
}
