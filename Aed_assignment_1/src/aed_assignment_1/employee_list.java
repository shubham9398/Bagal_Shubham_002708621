/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aed_assignment_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shubhambagal
 */
public class employee_list {
   private ArrayList <employee_profile> employee_list;
   
   public employee_list(){
        
       
       this.employee_list = new ArrayList<employee_profile>();
       
       
   }

    public ArrayList<employee_profile> getEmployee_list() {
        return employee_list;
    }

    public void setEmployee_list(ArrayList<employee_profile> employee_list) {
        this.employee_list = employee_list;
    }
    
    public employee_profile addnewEmployee(){
        employee_profile newEmployee = new employee_profile();
        employee_list.add(newEmployee);
       return newEmployee;
        
    }
    
     public employee_profile UpdatenewEmployee(int index){
        employee_profile newEmployee1 = new employee_profile();
        employee_list.set(index,newEmployee1);
       return newEmployee1;
        
    }

    public void deleteEmployee(employee_profile select_profile) {
        employee_list.remove(select_profile);
        
    }
    
   
   
    
    
}
