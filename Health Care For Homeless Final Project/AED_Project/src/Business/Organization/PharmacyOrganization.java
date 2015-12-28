/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Pharmacy.SupplierDirectory;
import Business.Role.PharmacyAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class PharmacyOrganization extends Organization{

    private SupplierDirectory supplierDir;
    public PharmacyOrganization() {
        super(Organization.Type.Pharmacy.getValue());
        supplierDir = new SupplierDirectory();
    }

    public SupplierDirectory getSupplierDir() {
        return supplierDir;
    }

    public void setSupplierDir(SupplierDirectory supplierDir) {
        this.supplierDir = supplierDir;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PharmacyAdminRole());
        return roles;
    }
    
}
