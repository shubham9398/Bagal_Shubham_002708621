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
public class Doctors_dir extends Person_dir{
    
    private ArrayList<Doctor> doctor_list;
    private ArrayList<Person> person_list;
    
    public Doctors_dir(){
        doctor_list = new ArrayList<Doctor>();
        person_list = new ArrayList<Person>();
        
    }

    public ArrayList<Doctor> getDoctor_list() {
        return doctor_list;
    }

    public void setDoctor_list(ArrayList<Doctor> doctor_list) {
        this.doctor_list = doctor_list;
    }
    
    public Doctor addnewEmployee(){
        Doctor newEmployee = new Doctor();
        Person newPerson = new Person();
        doctor_list.add(newEmployee);
        person_list.add(newPerson);
       return newEmployee;
        
    }
    
    public Doctor UpdatenewEmployee(int index){
        Doctor newEmployee1 = new Doctor();
        doctor_list.set(index,newEmployee1);
       return newEmployee1;
        
    }
    
    public void deleteEmployee(Doctor select_profile) {
        doctor_list.remove(select_profile);
    }
    
}
