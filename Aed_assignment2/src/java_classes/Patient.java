/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_classes;

import java.util.ArrayList;

/**
 *
 * @author shubhambagal
 */
public class Patient extends Person{
    
    private String ssn;

    
    private String city;
    private String housse;
    private String age;
    private String community;
    ArrayList<Encounter> encounter_list;

//    public ArrayList<Encounter> getEncounter_list() {
//        return encounter_list;
//    }
//
//    public void setEncounter_list(ArrayList<Encounter> encounter_list) {
//        this.encounter_list = encounter_list;
//    }
    
   

    public String getCommunity() {
        return community;
    }
    
    

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHousse() {
        return housse;
    }

    public void setHousse(String housse) {
        this.housse = housse;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    
   
    
    
}
