/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import Business.Person.Person;
import Business.Pharmacy.OrderCatalog;
import Business.Sensors.SensorHistory;
import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class Patient extends Person{
    
    private String name;
    private int age;
    private String gender;
    private String location;
    private Person person;
    private SensorHistory sensorHistory;
    private OrderCatalog orderCatalog;
    private ArrayList<LabTest> labTestList;
    
    public Patient() {
        sensorHistory = new SensorHistory();
        orderCatalog = new OrderCatalog();
        labTestList = new ArrayList<>();
    }

    public ArrayList<LabTest> getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(ArrayList<LabTest> labTestList) {
        this.labTestList = labTestList;
    }

    public void addLabTest(LabTest labTest) {
        labTestList.add(labTest);
        
    }
    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    
    public SensorHistory getSensorHistory() {
        return sensorHistory;
    }

    public void setSensorHistory(SensorHistory sensorHistory) {
        this.sensorHistory = sensorHistory;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
