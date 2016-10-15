package org.sugathan.springAmqpExampleWithProtos;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.sugathan.springAmqpExampleWithProtos.PersonProtos.PersonProto;

import com.google.protobuf.InvalidProtocolBufferException;

public class SpringAmpqExampleReceiver {
	
	final static String queueName = "spring-rabbit-sample";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InvalidProtocolBufferException{
		ApplicationContext context =
			    new AnnotationConfigApplicationContext(RabbitConfig.class);
			AmqpTemplate template = context.getBean(AmqpTemplate.class);
			PersonProto personProto = (PersonProto) template.receiveAndConvert(queueName);
			Person person = MQUtils.fromProtos(personProto);
			System.out.println("Reecived "+ person);
	}

}
