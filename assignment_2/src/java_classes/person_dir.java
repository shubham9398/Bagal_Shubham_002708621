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
public class person_dir {
    private ArrayList <person> person_list;
    
    public person_dir(){
        this.person_list = new ArrayList <person>();
    }

    public ArrayList<person> getPerson_list() {
        return person_list;
    }

    public void setPerson_list(ArrayList<person> person_list) {
        this.person_list = person_list;
    }
    
    public person addnewEmployee(){
        person newEmployee = new person();
        person_list.add(newEmployee);
       return newEmployee;
        
    }
    
    public person UpdatenewEmployee(int index){
        person newEmployee1 = new person();
        person_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(person select_profile) {
        person_list.remove(select_profile);
        
    }
    
    
    
    
    
    
}
