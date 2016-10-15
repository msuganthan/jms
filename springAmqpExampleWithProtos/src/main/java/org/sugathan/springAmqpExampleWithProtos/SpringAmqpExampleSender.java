package org.sugathan.springAmqpExampleWithProtos;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sugathan.springAmqpExampleWithProtos.PersonProtos.PersonProto;

@SpringBootApplication
public class SpringAmqpExampleSender {

	final static String queueName = "spring-rabbit-sample";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfig.class);
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		Person person = new Person();
		person.setFirstName("Suganthan");
		person.setLastName("Madhavan");
		PersonProto personProto = MQUtils.toProtos(person); 
		template.convertAndSend(queueName, personProto);
		System.out.println("successfully send "+personProto);
	}
}
