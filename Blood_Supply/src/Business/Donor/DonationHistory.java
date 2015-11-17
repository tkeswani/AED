/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donor;

import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class DonationHistory {
    
    private ArrayList<Donation> donate;

    public DonationHistory() {
        donate = new ArrayList<>();
    }

    public ArrayList<Donation> getDonate() {
        return donate;
    }

    public void setDonate(ArrayList<Donation> donate) {
        this.donate = donate;
    }
    
    public Donation addDonation() {
        Donation donation = new Donation();
        donate.add(donation);
        return donation;
    }
    
    
}
