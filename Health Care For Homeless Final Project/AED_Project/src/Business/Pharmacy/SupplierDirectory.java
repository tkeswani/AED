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
public class SupplierDirectory {
    
    private ArrayList<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new ArrayList<>();
    }

    public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(ArrayList<Supplier> supplierList) {
        this.supplierList = supplierList;
    }
    
    public Supplier addSupplier() {
        Supplier supplier = new Supplier();
        
        supplierList.add(supplier);
        return supplier;
    }
    
}
