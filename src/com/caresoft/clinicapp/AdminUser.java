package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public AdminUser(int newId, String newRole) {
    	super(newId);
    	employeeID = id;
    	role = newRole;
    }
    
    public boolean assignPin(int newPin) {
    	int length = String.valueOf(newPin).length();
    	if(length >= 6) {
        	pin = newPin;
        	return true;
    	} else {
    		return false;
    	}

    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(confirmedAuthID == employeeID) {
    		return true;
    	} else {
    		authIncident();
    		return false;
    	}
    }
    
    public ArrayList<String> reportSecurityIncidents(){
    	return securityIncidents;
    }
    

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters

}
