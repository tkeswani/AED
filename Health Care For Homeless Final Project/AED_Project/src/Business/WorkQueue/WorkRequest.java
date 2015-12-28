/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Patient.LabTest;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Tarun
 */
public class WorkRequest {
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    private String applicationStatus;
    private String name;
    private String phoneNo;
    private String gender;
    private String address;
    private String designation;
    private Patient patient;

    private LabTest labTest;
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    @Override
    public String toString() {
        return message;
    }
    
    
}
