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
public class doctors_dir {
    
    private ArrayList<doctor> doctor_list;
    
    public doctors_dir(){
        doctor_list = new ArrayList<doctor>();
        
    }

    public ArrayList<doctor> getDoctor_list() {
        return doctor_list;
    }

    public void setDoctor_list(ArrayList<doctor> doctor_list) {
        this.doctor_list = doctor_list;
    }
    
    public doctor addnewEmployee(){
        doctor newEmployee = new doctor();
        doctor_list.add(newEmployee);
       return newEmployee;
        
    }
    
    public doctor UpdatenewEmployee(int index){
        doctor newEmployee1 = new doctor();
        doctor_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(doctor select_profile) {
        doctor_list.remove(select_profile);
    }
    
}
