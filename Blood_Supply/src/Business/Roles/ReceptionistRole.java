/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Roles;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.ReceptionistRole.ReceptionistQueueAreaJPanel;
import userinterface.ReceptionistRole.ReceptionistWorkAreaPanel;


/**
 *
 * @author Tarun
 */
public class ReceptionistRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel pnl, UserAccount ua, Organization o, Enterprise e, EcoSystem es) {
        return new ReceptionistWorkAreaPanel(pnl, o, e, ua);
    }
    
}
