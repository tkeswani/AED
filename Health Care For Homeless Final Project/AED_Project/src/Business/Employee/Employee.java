/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Person.Person;

/**
 *
 * @author Tarun
 */
public class Employee extends Person{
 
    private String name;
    private String designation;
    private int id;
    private static int count = 1;

    public Employee() {
        id = count;
        count++;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
