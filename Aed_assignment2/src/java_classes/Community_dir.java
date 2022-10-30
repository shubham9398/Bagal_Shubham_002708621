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
public class Community_dir {
    private ArrayList<Community> comm_list;
    
    public Community_dir(){
        comm_list = new ArrayList<Community>();
        
    }

    public ArrayList<Community> getComm_list() {
        return comm_list;
    }

    public void setComm_list(ArrayList<Community> comm_list) {
        this.comm_list = comm_list;
    }

   
    public Community addnewEmployee(){
        Community newEmployee = new Community();
        comm_list.add(newEmployee);
       return newEmployee;
        
    }
    
    public Community UpdatenewEmployee(int index){
        Community newEmployee1 = new Community();
        comm_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(Community select_profile) {
        comm_list.remove(select_profile);
    }
    
    
    
}
