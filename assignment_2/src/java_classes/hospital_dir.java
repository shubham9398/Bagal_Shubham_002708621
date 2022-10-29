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
public class hospital_dir {
    
    private ArrayList<hospital> hospital_list;
    
   public hospital_dir(){
        
       hospital_list = new ArrayList<hospital>();
       
       
    }

    public ArrayList<hospital> getHospital_list() {
        return hospital_list;
    }

    public void setHospital_list(ArrayList<hospital> hospital_list) {
        this.hospital_list = hospital_list;
    }
    
    public hospital addnewEmployee(){
        hospital newEmployee = new hospital();
        hospital_list.add(newEmployee);
       return newEmployee;
        
    }
    
    public hospital UpdatenewEmployee(int index){
        hospital newEmployee1 = new hospital();
        hospital_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(hospital select_profile) {
        hospital_list.remove(select_profile);
        
    }
    
}
