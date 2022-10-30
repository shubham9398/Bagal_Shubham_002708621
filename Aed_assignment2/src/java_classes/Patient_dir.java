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
public class Patient_dir extends Person_dir{
    ArrayList<Patient> patient_list;
    ArrayList<Person> person_list;
   

   

    public ArrayList<Patient> getPatient_list() {
        return patient_list;
    }

    public void setPatient_list(ArrayList<Patient> patient_list) {
        this.patient_list = patient_list;
    }
    
    public Patient_dir(){
        patient_list = new ArrayList<Patient>();
        person_list  = new ArrayList<Person>();
        
    }
    
    
    
    public Patient addnewEmployee(){
        Patient newEmployee = new Patient();
        Person newPerson = new Person();
        patient_list.add(newEmployee);
        person_list.add(newPerson);
       return newEmployee;
        
    }
    
    
    
    
    
    public Patient UpdatenewEmployee(int index){
        Patient newEmployee1 = new Patient();
        patient_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(Patient select_profile) {
        patient_list.remove(select_profile);
        
    }
    
}
