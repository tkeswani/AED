/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise addEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise ent = null;
        
        if(type==Enterprise.EnterpriseType.Hospital) {
            ent = new HospitalEnterprise(name);
            enterpriseList.add(ent);
        }
        else if(type == Enterprise.EnterpriseType.Pharmacy) {
            ent = new PharmacyEnterprise(name);
            enterpriseList.add(ent);
        }
        else if(type == Enterprise.EnterpriseType.NGO_Clinics) {
            ent = new NgoClinicsEnterprise(name);
            enterpriseList.add(ent);
        }
        return ent;
    }
}
