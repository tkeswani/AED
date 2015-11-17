/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import Business.Employee.Employee;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class Donor extends Employee{

    
    DonationHistory donationHistory;

    public Donor() {
        donationHistory = new DonationHistory();
    }

    public DonationHistory getDonationHistory() {
        return donationHistory;
    }

    public void setDonationHistory(DonationHistory donationHistory) {
        this.donationHistory = donationHistory;
    }
   
      
    
}
