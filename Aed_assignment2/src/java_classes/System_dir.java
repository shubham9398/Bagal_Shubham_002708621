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
public class System_dir {
    
    private ArrayList<System> sys_list;
    
    public System_dir(){
        sys_list = new ArrayList<System>();
        
    }

    public ArrayList<System> getSys_list() {
        return sys_list;
    }

    public void setSys_list(ArrayList<System> sys_list) {
        this.sys_list = sys_list;
    }

    
   
    public System addnewEmployee(){
        System newEmployee = new System();
        sys_list.add(newEmployee);
       return newEmployee;
        
    }
    
    public System UpdatenewEmployee(int index){
        System newEmployee1 = new System();
        sys_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(System select_profile) {
        sys_list.remove(select_profile);
    }
    
}
