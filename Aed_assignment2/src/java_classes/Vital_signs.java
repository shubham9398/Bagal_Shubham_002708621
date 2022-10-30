/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_classes;

/**
 *
 * @author shubhambagal
 */


public class Vital_signs {
    
    private int bodyTemp;
    private int pulseRate;
    private int respRate;
    private int bloodPressure;
    
       
    public Vital_signs(int bodyTemp,
                      int pulseRate,
                      int bloodPressure) {

        this.bodyTemp = bodyTemp;
        this.pulseRate = pulseRate;
        this.bloodPressure = bloodPressure;
  
    }

    public int getBodyTemp() {
        return bodyTemp;
    }
    
    

    public void setBodyTemp(int bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public int getRespRate() {
        return respRate;
    }

    public void setRespRate(int respRate) {
        this.respRate = respRate;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    
    
    
}
