package org.sugathan.springAmqpExampleWithProtos;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 4528003798934295L;
	private String firstName;
	private String lastName;
		
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return "Sample Rabbit { firstName: "+ getFirstName() +" lastName: "+ getLastName() +" }";
	}

}
