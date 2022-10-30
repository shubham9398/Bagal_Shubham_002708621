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
public class Hospital_dir {
    
    private ArrayList<Hospital> hospital_list;
    
   public Hospital_dir(){
        
       hospital_list = new ArrayList<Hospital>();
       
       
    }

    public ArrayList<Hospital> getHospital_list() {
        return hospital_list;
    }

    public void setHospital_list(ArrayList<Hospital> hospital_list) {
        this.hospital_list = hospital_list;
    }
    
    public Hospital addnewEmployee(){
        Hospital newEmployee = new Hospital();
        hospital_list.add(newEmployee);
       return newEmployee;
        
    }
    
    public Hospital addnewEmployeeWithDoc(int index){
        Hospital newEmployee = new Hospital();
        hospital_list.set(index, newEmployee);
       return newEmployee;
       
    }
    
    public Hospital UpdatenewEmployee(int index){
        Hospital newEmployee1 = new Hospital();
        hospital_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(Hospital select_profile) {
        hospital_list.remove(select_profile);
        
    }
    
}
