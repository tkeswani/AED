/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;

import java.util.ArrayList;

/**
 *
 * @author Tarun
 */
public class SensorHistory {
    
    private ArrayList<Sensors> sensorList;

    public SensorHistory() {
        sensorList = new ArrayList<>();
    }

    public ArrayList<Sensors> getSensorList() {
        return sensorList;
    }

    public void setSensorList(ArrayList<Sensors> sensorList) {
        this.sensorList = sensorList;
    }
    
    
}
