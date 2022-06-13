package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    public User(int newId) {
    	id = newId;
    }
    
    public Integer getId() {
    	return id;
    }
    
    public int getPin() {
    	return pin;
    }
    
}
