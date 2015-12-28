/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public abstract class Enterprise extends Organization{
    
    private EnterpriseType entType;
    private OrganizationDirectory orgDir;
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        
        this.entType = type;
        this.orgDir = new OrganizationDirectory();
    }

    public EnterpriseType getEntType() {
        return entType;
    }

    public void setEntType(EnterpriseType entType) {
        this.entType = entType;
    }

    public OrganizationDirectory getOrgDir() {
        return orgDir;
    }

    public void setOrgDir(OrganizationDirectory orgDir) {
        this.orgDir = orgDir;
    }

    
        public enum EnterpriseType {
        Hospital("Hospital"),
        Pharmacy("Pharmacy"),
        NGO_Clinics("NGO Clinics");

        private EnterpriseType(String value) {
            this.value = value;
        }
        
        
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value;
    }
        
    }
}
