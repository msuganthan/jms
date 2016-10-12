package org.sugathan.springAmqpExample;

import java.io.Serializable;

public class Rabbit implements Serializable{
	
	
	private static final long serialVersionUID = 4528079203798934295L;
	String rabbitName;

	Rabbit(String name) {
		this.rabbitName = name;
	}
		
	public String getRabbitName() {
		return this.rabbitName;
	}
	
	public String toString() {
		return "Sample Rabbit { "+ rabbitName +" }";
	}

}
