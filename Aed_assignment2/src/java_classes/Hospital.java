/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_classes;

/**
 *
 * @author shubhambagal
 */
public class Hospital {
     private String community;
    private String city;
    private String hospital_name;
    private String doctor;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_community) {
        this.hospital_name = hospital_community;
    }
    
    @Override
    public String toString(){
        return hospital_name;
    }

    
    
}
