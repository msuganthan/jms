package org.sugathan.springAmqpExampleWithProtos;

import org.sugathan.springAmqpExampleWithProtos.PersonProtos.PersonProto;


public class MQUtils {

	public static Person fromProtos(PersonProto personProto) {
		Person person = new Person();
		person.setFirstName(personProto.getFirstName());
		person.setLastName(personProto.getLastName());
		return person;
	}

	public static PersonProto toProtos(Person person) {
		PersonProto personProto = PersonProto.newBuilder()
				.setFirstName(person.getFirstName())
				.setLastName(person.getLastName())
				.build();
		return personProto;
	}
	
	
	
}
