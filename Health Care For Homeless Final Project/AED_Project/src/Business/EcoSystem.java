/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Role.Role;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class EcoSystem extends Organization{
    
    private ArrayList<Network> networkList;
    private MasterOrderCatalog masterOrder;
    private int totalDonation;
    private static EcoSystem business;
    
    public static EcoSystem getInstance() {
        if(business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public EcoSystem() {
        super("Main Ecosystem");
        networkList = new ArrayList<>();
        masterOrder = new MasterOrderCatalog();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }

    public static EcoSystem getBusiness() {
        return business;
    }
    
    public Network addNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    public MasterOrderCatalog getMasterOrder() {
        return masterOrder;
    }

    public void setMasterOrder(MasterOrderCatalog masterOrder) {
        this.masterOrder = masterOrder;
    }

    public void addTotalDonation(int amount) {
        totalDonation = totalDonation + amount;
        System.out.println("Total Donation Made: " + totalDonation);
    }

    public int getTotalDonation() {
        return totalDonation;
    }

    public void setTotalDonation(int totalDonation) {
        this.totalDonation = totalDonation;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SystemAdminRole());
        return roles;
    
    }

    
}
