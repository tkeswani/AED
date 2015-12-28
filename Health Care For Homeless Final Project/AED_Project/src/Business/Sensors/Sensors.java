/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensors;

import java.util.Date;

/**
 *
 * @author Tarun
 */
public class Sensors {
    
    private float heartRate;
    private float weight;
    private float respRate;
    private float bp;
    private String status;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public float getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(float heartRate) {
        this.heartRate = heartRate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getRespRate() {
        return respRate;
    }

    public void setRespRate(float respRate) {
        this.respRate = respRate;
    }

    public float getBp() {
        return bp;
    }

    public void setBp(float bp) {
        this.bp = bp;
    }
    
    
}
