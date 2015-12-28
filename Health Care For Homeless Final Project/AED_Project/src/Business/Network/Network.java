/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author Tarun
 */
public class Network {
 
    private String name;
    private EnterpriseDirectory entDirectory;

    public Network() {
        this.entDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEntDirectory() {
        return entDirectory;
    }

    public void setEntDirectory(EnterpriseDirectory entDirectory) {
        this.entDirectory = entDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
}
