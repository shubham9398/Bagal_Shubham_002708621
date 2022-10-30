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
public class Person_dir {
    private ArrayList <Person> person_list;
    
    public Person_dir(){
        this.person_list = new ArrayList <Person>();
    }

    public ArrayList<Person> getPerson_list() {
        return person_list;
    }

    public void setPerson_list(ArrayList<Person> person_list) {
        this.person_list = person_list;
    }
    
//    public Person addnewEmployee(){
//        Person newEmployee = new Person();
//        person_list.add(newEmployee);
//       return newEmployee;
//        
//    }
//    
//    public Person UpdatenewEmployee(int index){
//        Person newEmployee1 = new Person();
//        person_list.set(index,newEmployee1);
//       return newEmployee1;
//        
//    }
//    
//    public void deleteEmployee(Person select_profile) {
//        person_list.remove(select_profile);
//        
//    }
    
    
    
    
    
    
}
