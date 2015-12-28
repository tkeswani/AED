/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DoctorRole;
import Business.Role.NGODoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class NGODoctorOrganization extends Organization{

    public NGODoctorOrganization() {
        super(Organization.Type.NGO_Doctor.getValue());
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new NGODoctorRole());
        return roles;
    }
    
}
