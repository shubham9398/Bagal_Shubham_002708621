/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_classes;

import java.util.Date;

/**
 *
 * @author shubhambagal
 */
public class Encounter {
    private Vital_signs vitalSign;
    private Date aptTime;
    private String patientName;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    private String diagnosis;
    
    public Encounter( Vital_signs vitalSign,Date aptTime,String result ,String patient){

        this.vitalSign = vitalSign;
        this.aptTime = aptTime;
        this.diagnosis = result;
        this.patientName = patient;

    }

    public Vital_signs getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(Vital_signs vitalSign) {
        this.vitalSign = vitalSign;
    }

    public Date getAptTime() {
        return aptTime;
    }

    public void setAptTime(Date aptTime) {
        this.aptTime = aptTime;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
      @Override
    public String toString(){
        return patientName;
    }
    
     
    
    
    
    
     
}
