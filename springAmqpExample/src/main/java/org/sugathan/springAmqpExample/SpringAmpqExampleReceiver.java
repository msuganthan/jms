package org.sugathan.springAmqpExample;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAmpqExampleReceiver {
	
	final static String queueName = "spring-rabbit-sample";
	
	public static void main(String[] args){
		ApplicationContext context =
			    new AnnotationConfigApplicationContext(RabbitConfig.class);
			AmqpTemplate template = context.getBean(AmqpTemplate.class);
			Rabbit message = (Rabbit) template.receiveAndConvert(queueName);
			System.out.println("Reecived "+ message);
	}

}
