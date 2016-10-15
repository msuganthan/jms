package org.sugathan.springAmqpExampleWithProtos;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.suganthan.springAmpqExampleWithProtos.RabbitProtos.RabbitProto;

public class SpringAmqpExampleSender {

	final static String queueName = "spring-rabbit-sample";
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfig.class);
		AmqpTemplate template = context.getBean(AmqpTemplate.class);
		Rabbit rabbit = new Rabbit();
		rabbit.setRabbitName("New Australian Rabbit");
		RabbitProto protos = MQUtils.toProto(rabbit);
		template.convertAndSend(queueName, protos);
		System.out.println("successfully send"+rabbit);
	}
}
