package org.sugathan.springAmqpExampleWithProtos;

import java.io.Serializable;

public class Rabbit implements Serializable{
	
	
	private static final long serialVersionUID = 4528003798934295L;
	String rabbitName;
		
	public String getRabbitName() {
		return this.rabbitName;
	}
	
	public void setRabbitName(String rabbitName) {
		this.rabbitName = rabbitName;
	}
	
	public String toString() {
		return "Sample Rabbit { "+ rabbitName +" }";
	}

}
