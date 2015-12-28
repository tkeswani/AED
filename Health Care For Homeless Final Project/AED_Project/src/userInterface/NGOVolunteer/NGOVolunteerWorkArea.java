/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.NGOVolunteer;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.NGODoctorOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.LabTest;
import Business.Patient.Patient;
import Business.Person.Person;
import Business.Pharmacy.Drug;
import Business.Pharmacy.Order;
import Business.Pharmacy.OrderItem;
import Business.Sensors.Sensors;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import userInterface.MainJFrame;

/**
 *
 * @author Tarun
 */
public class NGOVolunteerWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form NGOVolunteerWorkArea
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem business;
    private UserAccount userAccount;
    private Patient patient;
    private DefaultCategoryDataset money;
    
    public NGOVolunteerWorkArea(JPanel userProcessContainer, Enterprise enterprise, EcoSystem business, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.business = business;
        this.userAccount = userAccount;
        patientWelcomeLabel.setVisible(false);
        
        populateLocationComboBox();
        populatePatientNameComboBox();
        populatePatientComboBox();
        populatePatientMedicineComboBox();
        populatePatientDetailsTable();
        populatePatientTrackingTable();
    }
    
    public void populatePatientTrackingTable() {
        DefaultTableModel model = (DefaultTableModel)patientTrackingTable.getModel();
        
        model.setRowCount(0);
        
        if(!(userAccount.getWorkQueue().getWorkRequestList().isEmpty())) {
        for(WorkRequest request: userAccount.getWorkQueue().getWorkRequestList()) {
            if(!(request.getStatus().equalsIgnoreCase("Medication Added To Cart"))) {
            Object[] row = new Object[7];
            row[0] = request;
            row[1] = request.getPatient();
            row[2] = request.getSender();
            row[3] = request.getReceiver();
            row[4] = request.getRequestDate();
            row[5] = request.getResolveDate();
            row[6] = request.getStatus();
            
            model.addRow(row);
        }
        }
        }
    }
    
    public void populatePatientMedicineComboBox() {
        patientMedicineComboBox.removeAllItems();
        
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
            {System.out.println("enterprise direc not empty");
                for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
                    if(organization instanceof PatientOrganization) {
                        System.out.println("inside patient org");
                        if(!(organization.getPersonDirectory().getPersonList().isEmpty())) {
                            System.out.println("patient list present");
                                for(Person patient : organization.getPersonDirectory().getPersonList()) {
                                    if(patient!=null) {
                                    Patient p = (Patient) patient;
                                    System.out.println("patient present");
                                    for(Order order:p.getOrderCatalog().getOrderList()) {
                                        if(order!=null) {
                                        System.out.println("order");
                                        if(order.getStatus().equalsIgnoreCase("PROCESSING")) {
                                            System.out.println("processing");
                                            patientMedicineComboBox.addItem(patient);
                                        }
                                    }
                                    }
                                    }
                                    
                }
            }
            }
        }
            }
    }
    }
    public void populatePatientDetailsTable() {
        DefaultTableModel model = (DefaultTableModel)patientDetailsTable.getModel();
        model.setRowCount(0);
        
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
        for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
            if(organization instanceof PatientOrganization) {
                //System.out.println(organization.getPersonDirectory().getPersonList().isEmpty());
                if(!organization.getPersonDirectory().getPersonList().isEmpty()) {
                for(Person person : organization.getPersonDirectory().getPersonList()) {
                    if(person!=null) {
                    Object[] row = new Object[4];
                    Patient patient =  (Patient) person;
                    row[0] = person.getName();
                    row[1] = person.getGender();
                    row[2] = person.getAge();
                    row[3] = patient.getLocation();
                    
                    model.addRow(row);
                    }
                    
                }
            }
            }
        }
        }
    }

    // Populating the combo box with networks
    public void populateLocationComboBox() {
        locationComboBox.removeAllItems();
        for(Network network: business.getNetworkList()) {
            locationComboBox.addItem(network);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        namePatientTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        malePatientRadioBtn = new javax.swing.JRadioButton();
        femalePatientRadioBtn = new javax.swing.JRadioButton();
        submitPatientDetailsBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientDetailsTable = new javax.swing.JTable();
        patientWelcomeLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        calendarDOB = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        phoneNoTxtField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        heartRateTxtField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        weightTxtField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        respRateTxtField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bpTxtField = new javax.swing.JTextField();
        submitVSBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        patientNameComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        SensorDataTable = new javax.swing.JTable();
        generateVitalSignBtn = new javax.swing.JButton();
        normalHeartRateLabel = new javax.swing.JLabel();
        normalWeightLabel = new javax.swing.JLabel();
        normalRespRateLabel = new javax.swing.JLabel();
        normalBPLabel = new javax.swing.JLabel();
        showNormalRangeValuesBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        timeStampTxtField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        patientComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        patientHistoryTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        patientOrderHistoryTable = new javax.swing.JTable();
        downloadBtn = new javax.swing.JButton();
        graphBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        patientMedicineComboBox = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        patientMedicineOrderTable = new javax.swing.JTable();
        orderBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        patientTrackingTable = new javax.swing.JTable();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("NAME");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, -1, -1));
        jPanel1.add(namePatientTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 180, -1));

        jLabel2.setText("GENDER");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, -1, -1));

        buttonGroup1.add(malePatientRadioBtn);
        malePatientRadioBtn.setText("MALE");
        jPanel1.add(malePatientRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, -1, -1));

        buttonGroup1.add(femalePatientRadioBtn);
        femalePatientRadioBtn.setText("FEMALE");
        jPanel1.add(femalePatientRadioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, -1, -1));

        submitPatientDetailsBtn.setText("SUBMIT");
        submitPatientDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPatientDetailsBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitPatientDetailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 730, -1, -1));

        jLabel4.setText("LOCATION");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 610, -1, -1));

        jPanel1.add(locationComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 610, 180, -1));

        patientDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "GENDER", "AGE", "LOCATION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patientDetailsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 790, -1, 131));

        patientWelcomeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/NGOVolunteer/patient welcome.jpg"))); // NOI18N
        patientWelcomeLabel.setText("jLabel11");
        jPanel1.add(patientWelcomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 489, 331));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/NGOVolunteer/Welcome Patient.jpg"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 0, 1610, 390));

        jLabel14.setText("DOB");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, -1, -1));
        jPanel1.add(calendarDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 550, 180, -1));

        jLabel3.setText("PHONE #");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 670, -1, -1));
        jPanel1.add(phoneNoTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 670, 180, -1));

        jTabbedPane1.addTab("ADD PATIENT", jPanel1);

        jLabel5.setText("HEART RATE");

        jLabel6.setText("WEIGHT(POUNDS)");

        jLabel7.setText("RESPIRATORY RATE");

        jLabel8.setText("BLOOD PRESSURE");

        submitVSBtn.setText("SUBMIT");
        submitVSBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitVSBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("PATIENT NAME");

        patientNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameComboBoxActionPerformed(evt);
            }
        });

        SensorDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HEART RATE", "BLODD PRESSURE", "RESPIRATORY RATE", "WEIGHT(POUNDS)", "STATUS", "TIME STAMP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(SensorDataTable);

        generateVitalSignBtn.setText("GENERATE VITAL SIGNS");
        generateVitalSignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateVitalSignBtnActionPerformed(evt);
            }
        });

        normalHeartRateLabel.setBackground(new java.awt.Color(0, 0, 255));

        normalWeightLabel.setBackground(new java.awt.Color(0, 0, 255));

        normalRespRateLabel.setBackground(new java.awt.Color(0, 0, 255));

        normalBPLabel.setBackground(new java.awt.Color(0, 0, 255));

        showNormalRangeValuesBtn.setText("NORMAL RANGE");
        showNormalRangeValuesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showNormalRangeValuesBtnActionPerformed(evt);
            }
        });

        jLabel12.setText("TIME STAMP");

        timeStampTxtField.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(544, 544, 544)
                        .addComponent(submitVSBtn)
                        .addGap(100, 100, 100)
                        .addComponent(generateVitalSignBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(normalWeightLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normalHeartRateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normalRespRateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(normalBPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(showNormalRangeValuesBtn)))
                        .addGap(216, 216, 216)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(heartRateTxtField)
                            .addComponent(weightTxtField)
                            .addComponent(respRateTxtField)
                            .addComponent(bpTxtField)
                            .addComponent(patientNameComboBox, 0, 150, Short.MAX_VALUE)
                            .addComponent(timeStampTxtField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1494, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(patientNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showNormalRangeValuesBtn))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(heartRateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normalHeartRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(weightTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normalWeightLabel))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(respRateTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normalRespRateLabel))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(bpTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(normalBPLabel))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(timeStampTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitVSBtn)
                    .addComponent(generateVitalSignBtn))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MANAGE PATIENT", jPanel2);

        patientComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setText("PATIENT");

        patientHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HEART RATE", "BLOOD PRESSURE", "RESPIRATORY RATE", "WEIGHT", "STATUS", "DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(patientHistoryTable);

        patientOrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICINE", "QUANTITY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(patientOrderHistoryTable);

        downloadBtn.setText("DOWNLOAD REPORT");
        downloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadBtnActionPerformed(evt);
            }
        });

        graphBtn.setText("GRAPH");
        graphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(466, 466, 466)
                        .addComponent(jLabel10)
                        .addGap(62, 62, 62)
                        .addComponent(patientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(downloadBtn)
                                .addGap(78, 78, 78)
                                .addComponent(graphBtn))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1437, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(75, 75, 75)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(downloadBtn)
                    .addComponent(graphBtn))
                .addContainerGap(279, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PATIENT HISTORY", jPanel3);

        jLabel11.setText("PATIENT");

        patientMedicineComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientMedicineComboBoxActionPerformed(evt);
            }
        });

        patientMedicineOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICINE NAME", "MARKET PRICE", "QUANTITY", "TOTAL PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(patientMedicineOrderTable);

        orderBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/NGOVolunteer/order_now.gif"))); // NOI18N
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jLabel11)
                        .addGap(59, 59, 59)
                        .addComponent(patientMedicineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1732, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(patientMedicineComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PENDING MEDICATION ORDERS", jPanel4);

        patientTrackingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MESSAGE", "PATIENT", "SENDER", "RECEIVER", "REQUESTED DATE", "RESOLVED DATE", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(patientTrackingTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1477, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(676, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PATIENT TRACKING", jPanel5);

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

    private void submitPatientDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPatientDetailsBtnActionPerformed
        // TODO add your handling code here:
        String gender = null;
        if(malePatientRadioBtn.isSelected()) {
            gender = "male";
        }
        else if(femalePatientRadioBtn.isSelected()) {
            gender = "female";
        }
        if (!(namePatientTxtField.getText().matches("[a-zA-Z\\s]+"))) {
                JOptionPane.showMessageDialog(this, "Enter The Name Correctly!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(gender == null) {
                JOptionPane.showMessageDialog(this, "Select The Gender!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(calendarDOB.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Enter Date Of Birth!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(phoneNoTxtField.getText().isEmpty() || (!phoneNoTxtField.getText().matches("\\d{10}"))) {
            JOptionPane.showMessageDialog(this, "Enter Valid Phone Number!!!");
        }
        else {
            Date date = calendarDOB.getDate();
        Date d = new Date();
        int strDate = date.getYear() + 1900;
        int age;
        age = d.getYear() - date.getYear();
        if(age<=0) {
            JOptionPane.showMessageDialog(this, "Enter A Valid Date!!!");
        }
        else {
        String name = namePatientTxtField.getText();
              
        
        Network location = (Network) locationComboBox.getSelectedItem();
        for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
            if(organization instanceof PatientOrganization) {
                Patient patient = new Patient();
                ArrayList<Person> person;
                person = organization.getPersonDirectory().getPersonList();
                
                person.add(patient);
                patient.setAge(age);
                patient.setGender(gender);
                patient.setName(name);
                patient.setLocation(location.getName());
                
                TwilioRestClient client = new TwilioRestClient("ACd4d9c14696f348fe21e4506a5e7b14e3", "d83be392f0c78d3a493675bf8d7942f1");
            
                                List<NameValuePair> params = new ArrayList<NameValuePair>();
                                params.add(new BasicNameValuePair("To", "+18577076050"));
                                params.add(new BasicNameValuePair("From", "+19073122832"));
                                params.add(new BasicNameValuePair("Body", "We Care About You :) !!!"));
            
                                MessageFactory messageFactory = client.getAccount().getMessageFactory();
                                try {
                                    com.twilio.sdk.resource.instance.Message  message = (com.twilio.sdk.resource.instance.Message) messageFactory.create(params);
                                } catch (TwilioRestException ex) {
                                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                populatePatientDetailsTable();
            }
        }
        patientWelcomeLabel.setVisible(true);
        populatePatientNameComboBox();
        populatePatientComboBox();
        populatePatientMedicineComboBox();
        namePatientTxtField.setText("");
        calendarDOB.setCalendar(null);
        buttonGroup1.clearSelection();
        phoneNoTxtField.setText("");
        }
        }
    }//GEN-LAST:event_submitPatientDetailsBtnActionPerformed

    public void populatePatientComboBox() {
        patientComboBox.removeAllItems();
        
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
            {
        for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
            if(organization instanceof PatientOrganization) {
                if(!(organization.getPersonDirectory().getPersonList().isEmpty())) {
                for(Person patient : organization.getPersonDirectory().getPersonList()) {
                    patientComboBox.addItem(patient);
                }
            }
            }
        }
            }
    }
    }
    
    public void populatePatientHistoryTable() {
        DefaultTableModel model = (DefaultTableModel)patientHistoryTable.getModel();
        
        model.setRowCount(0);
        
        Patient patient = (Patient) patientComboBox.getSelectedItem();
        if(patient!=null) {
            if(!(patient.getSensorHistory().getSensorList().isEmpty())) {
                System.out.println(patient.getName());
        for(Sensors sensorData : patient.getSensorHistory().getSensorList()) {
            Object[] row = new Object[6];
            row[0] = sensorData.getHeartRate();
            row[1] = sensorData.getBp();
            row[2] = sensorData.getRespRate();
            row[3] = sensorData.getWeight();
            row[4] = sensorData.getStatus();
            row[5] = sensorData.getDate();
            
            model.addRow(row);
        }
            }
        }
    }
    public void populatePatientNameComboBox() {
        patientNameComboBox.removeAllItems();
        
        if(!(enterprise.getOrgDir().getOrganizationList().isEmpty())) {
        for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
            if(organization instanceof PatientOrganization) {
                for(Person patient : organization.getPersonDirectory().getPersonList()) {
                    patientNameComboBox.addItem(patient);
                }
            }
        }
        }
        Patient patient = (Patient)patientNameComboBox.getSelectedItem();
        populateNormalRanges();
        populateSensorDataTable();
    }
    private void submitVSBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitVSBtnActionPerformed
        // TODO add your handling code here:
               
        if((heartRateTxtField.getText().isEmpty()) || (!(heartRateTxtField.getText().matches("[0-9]+.[0-9]+")))) {
            JOptionPane.showMessageDialog(this, "Enter Valid Heart Rate!!!");
        } 
        else if((weightTxtField.getText().isEmpty()) || (!(weightTxtField.getText().matches("[0-9]+.[0-9]+")))) {
            JOptionPane.showMessageDialog(this, "Enter Valid Weight(Pounds)!!!");
        }
        else if((respRateTxtField.getText().isEmpty()) || (!(respRateTxtField.getText().matches("[0-9]+.[0-9]+")))) {
            JOptionPane.showMessageDialog(this, "Enter Valid Respiratory Rate!!!");
        }
        else if((bpTxtField.getText().isEmpty()) || (!(bpTxtField.getText().matches("[0-9]+.[0-9]+")))) {
            JOptionPane.showMessageDialog(this, "Enter Valid Blood Pressure!!!");
        }
        else {
        String status;
        float heartRate = Float.parseFloat(heartRateTxtField.getText());
        float weight = Float.parseFloat(weightTxtField.getText());
        float respRate = Float.parseFloat(respRateTxtField.getText());
        float bp = Float.parseFloat(bpTxtField.getText());
        Patient patient = (Patient)patientNameComboBox.getSelectedItem();
        int age = patient.getAge();
        
        if(age>=1 && age <=3) {
            if((respRate>=20 && respRate<=30) && (heartRate>=80 && heartRate<=130) && (bp>=80 && bp<=110) && (weight>=22 && weight<=31))  {
                    status = "NORMAL";
            }
            else {
                status = "ABNORMAL";
            }
        }
        else if(age>=4 && age<=5) {
            if((respRate>=20 && respRate<=30) && (heartRate>=80 && heartRate<=120) && (bp>=80 && bp<=110) && (weight>=31 && weight<=40))  {
                    status = "NORMAL";
            }
            else {
                status = "ABNORMAL";
            }
        }
        else if(age>=6 && age<=12) {
            if((respRate>=20 && respRate<=30) && (heartRate>=70 && heartRate<=110) && (bp>=80 && bp<=120) && (weight>=41 && weight<=92))  {
                    status = "NORMAL";
            }
            else {
                status = "ABNORMAL";
            }
        }
        else {
            if((respRate>=12 && respRate<=20) && (heartRate>=55 && heartRate<=105) && (bp>=110 && bp<=120) && (weight>=110))  {
                    status = "NORMAL";
            }
            else {
                status = "ABNORMAL";
            }
        }
        
        Sensors sensorData = new Sensors();
        sensorData.setWeight(weight);
        sensorData.setBp(bp);
        sensorData.setHeartRate(heartRate);
        sensorData.setRespRate(respRate);
        sensorData.setStatus(status);
        sensorData.setDate(new Date());
        patient.getSensorHistory().getSensorList().add(sensorData);
        
        if(sensorData.getStatus().equals("ABNORMAL")) {
            // Add to the doctor queue
            WorkRequest request = new WorkRequest();
            request.setMessage("CHECK UP");
            request.setSender(userAccount);
            request.setRequestDate(new Date());
            request.setStatus(status);
            request.setPatient(patient);
            
            for(Organization organization : enterprise.getOrgDir().getOrganizationList()) {
                if(organization instanceof NGODoctorOrganization) {
                    organization.getWorkQueue().getWorkRequestList().add(request);
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                }
            }
        }
        populateSensorDataTable();
        heartRateTxtField.setText("");
        bpTxtField.setText("");
        respRateTxtField.setText("");
        weightTxtField.setText("");
        }
    }//GEN-LAST:event_submitVSBtnActionPerformed

    public void populateNormalRanges() {
        Patient patient = (Patient) patientNameComboBox.getSelectedItem();
        if(patient!=null) {
        if(patient.getAge()>=1 && patient.getAge()<=3) {
            normalHeartRateLabel.setText("80-130");
            normalRespRateLabel.setText("20-30");
            normalBPLabel.setText("80-110");
            normalWeightLabel.setText("22-31");
        }
        else if (patient.getAge()>=4 && patient.getAge()<=5) {
            normalHeartRateLabel.setText("80-120");
            normalRespRateLabel.setText("20-30");
            normalBPLabel.setText("80-110");
            normalWeightLabel.setText("31-40");
        }
        else if (patient.getAge()>=6 && patient.getAge()<=12) {
            normalHeartRateLabel.setText("70-110");
            normalRespRateLabel.setText("20-30");
            normalBPLabel.setText("80-120");
            normalWeightLabel.setText("41-92");
        }
        else {
            normalHeartRateLabel.setText("55-105");
            normalRespRateLabel.setText("12-20");
            normalBPLabel.setText("110-120");
            normalWeightLabel.setText(">110");
        }
        }
    }
    private void patientComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientComboBoxActionPerformed
        // TODO add your handling code here:
        populatePatientHistoryTable();
        populatePatientOrderHistoryTable();
        //populatePatientLabReportTable();
        
    }//GEN-LAST:event_patientComboBoxActionPerformed

    
    private void downloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadBtnActionPerformed
        try {
            // TODO add your handling code here:
            Patient patient = (Patient) patientComboBox.getSelectedItem();
            String patientName = patient.getName();
            String DEST = patientName + ".pdf";
            System.out.println(DEST);
            File file = new File(DEST);
            //file.getParentFile().mkdirs();
            createPdf(DEST);
        } catch (DocumentException ex) {
            Logger.getLogger(NGOVolunteerWorkArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NGOVolunteerWorkArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_downloadBtnActionPerformed

    private void generateVitalSignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateVitalSignBtnActionPerformed
        // TODO add your handling code here:
        generateVitalSigns();
    }//GEN-LAST:event_generateVitalSignBtnActionPerformed

    private void patientNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameComboBoxActionPerformed
        // TODO add your handling code here:
        populateSensorDataTable();
    }//GEN-LAST:event_patientNameComboBoxActionPerformed

    private void showNormalRangeValuesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showNormalRangeValuesBtnActionPerformed
        // TODO add your handling code here:
        Patient patient = (Patient)patientNameComboBox.getSelectedItem();
        if(patient!=null) {
        populateNormalRanges();
        }
    }//GEN-LAST:event_showNormalRangeValuesBtnActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        // TODO add your handling code here:
        Patient patient = (Patient) patientMedicineComboBox.getSelectedItem();
        if(patient!=null) {
        if(!(patient.getOrderCatalog().getOrderList().isEmpty())) {
        for(Order order : patient.getOrderCatalog().getOrderList()) {
            if(order.getStatus().equalsIgnoreCase("PROCESSING")) {
            order.setStatus("Completed");
            JOptionPane.showMessageDialog(this, "ORDER PLACED!!!");
            populatePatientMedicineComboBox();
        }
        }
        }
        else {
            JOptionPane.showMessageDialog(this, "No Pending Orders!!!");
        }
        }
        else {
            JOptionPane.showMessageDialog(this, "No Patient Present!!!");
        }
    }//GEN-LAST:event_orderBtnActionPerformed

    private void patientMedicineComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientMedicineComboBoxActionPerformed
        // TODO add your handling code here:
        populatePatientMedicineTable();
    }//GEN-LAST:event_patientMedicineComboBoxActionPerformed

    private void graphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphBtnActionPerformed
        // TODO add your handling code here:
        showGraph();
    }//GEN-LAST:event_graphBtnActionPerformed

    public void showGraph() {
         Patient patient = (Patient) patientComboBox.getSelectedItem();
        if(patient!=null) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        if(!(patient.getSensorHistory().getSensorList().isEmpty())) {
        for(Sensors vs : patient.getSensorHistory().getSensorList()) {
            
            XYSeries series1 = new XYSeries(vs.getBp());
            series1.add(10,vs.getBp());
            series1.add(20,vs.getHeartRate());
            series1.add(30,vs.getRespRate());
            series1.add(40, vs.getWeight());
            dataset.addSeries(series1);
            
        }
        
        
        JFreeChart chartFactory = ChartFactory.createXYLineChart("GRAPHICAL REPRESENTATION OF SENSOR DATA", "X-Axis", "SIGN",dataset);
        XYLineAndShapeRenderer renderer = null;
        XYPlot plot = chartFactory.getXYPlot();
        renderer = new XYLineAndShapeRenderer();
        ChartFrame frame = new ChartFrame("Line Chart Of Sensor Data", chartFactory);
        frame.setVisible(true);
        frame.setSize(700, 320);
        }
        else {
            JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
        }
        }
        else {
            JOptionPane.showMessageDialog(this, "No Patient In The Record!!!");
        }
    }
    public void populatePatientMedicineTable() {
        DefaultTableModel model = (DefaultTableModel)patientMedicineOrderTable.getModel();
        
        model.setRowCount(0);
        patient = (Patient) patientMedicineComboBox.getSelectedItem();
        if(patient!=null) {
        if(!(patient.getOrderCatalog().getOrderList().isEmpty())) {
        for(Order order : patient.getOrderCatalog().getOrderList()) {
            if(order!=null) {
                for(OrderItem oi : order.getOrderItem()) {
                     Object[] row = new Object[4];
                     Drug drug = oi.getDrug();
                     
                     row[0] = drug.getName();
                     row[1] = drug.getMarketPrice();
                     row[2] = oi.getQuantity();
                     row[3] = drug.getMarketPrice() * oi.getQuantity();
            
                     model.addRow(row);   
                
            
            
            }
            }
        }
        }
        }
    }
    public void generateVitalSigns() {
        Patient patient = (Patient)patientNameComboBox.getSelectedItem();
        if(patient!=null) {
        int age = patient.getAge();
        Random rn = new Random();
        if(age>=1 && age<=3) {
            heartRateTxtField.setText(String.valueOf(rn.nextFloat()*(140-70) + 70));
            respRateTxtField.setText(String.valueOf(rn.nextFloat()*(40-10) + 10));
            bpTxtField.setText(String.valueOf(rn.nextFloat()*(120-70) + 70));
            weightTxtField.setText(String.valueOf(rn.nextFloat()*(37-18) + 18));
        }
        else if(age>=4 && age<=5) {
            heartRateTxtField.setText(String.valueOf(rn.nextFloat()*(130-70) + 70));
            respRateTxtField.setText(String.valueOf(rn.nextFloat()*(40-10) + 10));
            bpTxtField.setText(String.valueOf(rn.nextFloat()*(120-70) + 70));
            weightTxtField.setText(String.valueOf(rn.nextFloat()*(46-27) + 27));
        } 
        else if (age>=6 && age<=12) {
            heartRateTxtField.setText(String.valueOf(rn.nextFloat()*(120-60) + 60));
            respRateTxtField.setText(String.valueOf(rn.nextFloat()*(40-10) + 10));
            bpTxtField.setText(String.valueOf(rn.nextFloat()*(130-70) + 70));
            weightTxtField.setText(String.valueOf(rn.nextFloat()*(98-37) + 37));
        }
        else {
            heartRateTxtField.setText(String.valueOf(rn.nextFloat()*(115-45) + 45));
            respRateTxtField.setText(String.valueOf(rn.nextFloat()*(27-5) + 5));
            bpTxtField.setText(String.valueOf(rn.nextFloat()*(130-100) + 100));
            weightTxtField.setText(String.valueOf(rn.nextFloat()*(300-110) + 110));
        }
        
        Date date = new Date();
        
        timeStampTxtField.setText(String.valueOf(date));
        }
        else {
            JOptionPane.showMessageDialog(this, "No Patient To Generate Vital Signs");
        }
    }
    public void createPdf(String dest) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        
        PdfPTable pdfTable = new PdfPTable(patientHistoryTable.getColumnCount());
            //adding table headers
            for (int i = 0; i < patientHistoryTable.getColumnCount(); i++) {
                pdfTable.addCell(patientHistoryTable.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows <= (patientHistoryTable.getRowCount() - 1); rows++) {
                for (int cols = 0; cols < patientHistoryTable.getColumnCount(); cols++) {
                    pdfTable.addCell(patientHistoryTable.getModel().getValueAt(rows, cols).toString());

                }
            }
            pdfTable.addCell(new Phrase(" "));
           document.add(pdfTable);
           
           PdfPTable pdfTable1 = new PdfPTable(patientOrderHistoryTable.getColumnCount());
        
            for (int i = 0; i < patientOrderHistoryTable.getColumnCount(); i++) {
                pdfTable1.addCell(patientOrderHistoryTable.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows <= (patientOrderHistoryTable.getRowCount() - 1); rows++) {
                for (int cols = 0; cols < patientOrderHistoryTable.getColumnCount(); cols++) {
                    pdfTable1.addCell(patientOrderHistoryTable.getModel().getValueAt(rows, cols).toString());

                }
            }
            
            document.add(pdfTable1);
 
        document.close();
        JOptionPane.showMessageDialog(this, "Download Complete!!!");
    }
    public void populatePatientOrderHistoryTable() {
        DefaultTableModel model = (DefaultTableModel)patientOrderHistoryTable.getModel();
        
        model.setRowCount(0);
        
        Patient patient = (Patient) patientComboBox.getSelectedItem();
        if(patient!=null) {
            if(!(patient.getOrderCatalog().getOrderList().isEmpty())) {
                for(Order order : patient.getOrderCatalog().getOrderList()) {
                    if(!(order.getOrderItem().isEmpty())) {
                        for(OrderItem oi : order.getOrderItem()) {
                    Object[] row = new Object[2];
                    Drug drug = oi.getDrug();
                    row[0] = drug.getName();
                    row[1] = oi.getQuantity();
                    
                    model.addRow(row);
                }
                    }
                }
            }
        }
    }
    public void populateSensorDataTable() {
        DefaultTableModel model = (DefaultTableModel)SensorDataTable.getModel();
        model.setRowCount(0);
        
        Patient patient = (Patient) patientNameComboBox.getSelectedItem();
        
        if((patient!=null)) {
        if(!patient.getSensorHistory().getSensorList().isEmpty()) {
        for(Sensors sensorData : patient.getSensorHistory().getSensorList()) {
            Object[] row = new Object[6];
            row[0] = sensorData.getHeartRate();
            row[1] = sensorData.getBp();
            row[2] = sensorData.getRespRate();
            row[3] = sensorData.getWeight();
            row[4] = sensorData.getStatus();
            row[5] = sensorData.getDate();
            
            model.addRow(row);
        }
        }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SensorDataTable;
    private javax.swing.JTextField bpTxtField;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser calendarDOB;
    private javax.swing.JButton downloadBtn;
    private javax.swing.JRadioButton femalePatientRadioBtn;
    private javax.swing.JButton generateVitalSignBtn;
    private javax.swing.JButton graphBtn;
    private javax.swing.JTextField heartRateTxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox locationComboBox;
    private javax.swing.JRadioButton malePatientRadioBtn;
    private javax.swing.JTextField namePatientTxtField;
    private javax.swing.JLabel normalBPLabel;
    private javax.swing.JLabel normalHeartRateLabel;
    private javax.swing.JLabel normalRespRateLabel;
    private javax.swing.JLabel normalWeightLabel;
    private javax.swing.JButton orderBtn;
    private javax.swing.JComboBox patientComboBox;
    private javax.swing.JTable patientDetailsTable;
    private javax.swing.JTable patientHistoryTable;
    private javax.swing.JComboBox patientMedicineComboBox;
    private javax.swing.JTable patientMedicineOrderTable;
    private javax.swing.JComboBox patientNameComboBox;
    private javax.swing.JTable patientOrderHistoryTable;
    private javax.swing.JTable patientTrackingTable;
    private javax.swing.JLabel patientWelcomeLabel;
    private javax.swing.JTextField phoneNoTxtField;
    private javax.swing.JTextField respRateTxtField;
    private javax.swing.JButton showNormalRangeValuesBtn;
    private javax.swing.JButton submitPatientDetailsBtn;
    private javax.swing.JButton submitVSBtn;
    private javax.swing.JTextField timeStampTxtField;
    private javax.swing.JTextField weightTxtField;
    // End of variables declaration//GEN-END:variables
}
