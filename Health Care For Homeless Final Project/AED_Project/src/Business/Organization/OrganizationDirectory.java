/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class OrganizationDirectory {
 
    private ArrayList<Organization> organizationList;
    
    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Hospital_Doctor.getValue())){
            organization = new HospitalDoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Admin.getValue())) {
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.NGO_Doctor.getValue())) {
            organization = new NGODoctorOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Patient.getValue())) {
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Pharmacy.getValue())) {
            organization = new PharmacyOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Volunteers.getValue())) {
            organization = new VolunteersOrganization();
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Type.Receptionist.getValue())) {
            organization = new HospitalReceptionistOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
