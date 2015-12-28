/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Pharmacy;

import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class Supplier {
    
    private String name;
    private ArrayList<Drug> drugList;

    public Supplier() {
        drugList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }
    
    public Drug addDrug() {
        Drug drug = new Drug();
        drugList.add(drug);
        return drug;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
