/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Tarun
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        String name = "Tarun";
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        //Employee employee = system.getEmployeeDirectory().createEmployee("Tarun");
        Employee employee = new Employee();
        system.getPersonDirectory().getPersonList().add(employee);
        employee.setName(name);
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        return system;
}
}
