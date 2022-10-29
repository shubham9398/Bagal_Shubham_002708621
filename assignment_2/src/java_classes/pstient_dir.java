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
public class pstient_dir {
    ArrayList<patient> patient_list;

    public ArrayList<patient> getPatient_list() {
        return patient_list;
    }

    public void setPatient_list(ArrayList<patient> patient_list) {
        this.patient_list = patient_list;
    }
    
    public pstient_dir(){
        patient_list = new ArrayList<patient>();
    }
    
    public patient addnewEmployee(){
        patient newEmployee = new patient();
        patient_list.add(newEmployee);
       return newEmployee;
        
    }
    
    public patient UpdatenewEmployee(int index){
        patient newEmployee1 = new patient();
        patient_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(patient select_profile) {
        patient_list.remove(select_profile);
        
    }
    
}
