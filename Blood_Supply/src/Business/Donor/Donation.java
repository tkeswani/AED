/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import Business.Employee.Employee;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Tarun
 */
public class Donation {
    
    private String bloodType;
    private String tracking;
    private String bloodPint;
    

    private Employee donor;
    
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getBloodPint() {
        return bloodPint;
    }

    public void setBloodPint(String bloodPint) {
        this.bloodPint = bloodPint;
    }

    public Employee getDonor() {
        return donor;
    }

    public void setDonor(Employee donor) {
        this.donor = donor;
    }
    
    private Date resolveDate;

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
    
}
