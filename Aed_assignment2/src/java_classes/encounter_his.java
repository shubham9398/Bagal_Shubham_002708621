/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author shubhambagal
 */
public class Encounter_his {
    
    private ArrayList<Encounter> encounterHistory;
    
    public Encounter_his() {
        encounterHistory = new ArrayList<>();
    }
    
     public void addEncounter(Encounter encounter) {
         
        encounterHistory.add(encounter);
    }
     
     public void updateEncounter(Encounter enc, int idx){
         
          encounterHistory.set(idx,enc);
     }
     
     

    public ArrayList<Encounter> getEncounterHistory() {
        return encounterHistory;
    }

    public void setEncounterHistory(ArrayList<Encounter> encounterHistory) {
        this.encounterHistory = encounterHistory;
    }
    
    
    
}
