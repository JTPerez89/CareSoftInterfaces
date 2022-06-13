package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser  {
    
    private ArrayList<String> patientNotes;
	
    public Physician(int newId) {
    	super(newId);
    }
    
    public boolean assignPin(int newPin) {
    	int length = String.valueOf(newPin).length();
    	if(length == 4) {
        	pin = newPin;
        	return true;
    	} else {
    		return false;
    	}

    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(confirmedAuthID == id) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters

}
