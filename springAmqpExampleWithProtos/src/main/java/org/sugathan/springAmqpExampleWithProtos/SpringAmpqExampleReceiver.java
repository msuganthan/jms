package org.sugathan.springAmqpExampleWithProtos;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.suganthan.springAmpqExampleWithProtos.RabbitProtos.RabbitProto;

import com.google.protobuf.DynamicMessage;
import com.google.protobuf.InvalidProtocolBufferException;

public class SpringAmpqExampleReceiver {
	
	final static String queueName = "spring-rabbit-sample";
	
	public static void main(String[] args) throws InvalidProtocolBufferException{
		ApplicationContext context =
			    new AnnotationConfigApplicationContext(RabbitConfig.class);
			AmqpTemplate template = context.getBean(AmqpTemplate.class);
			RabbitProto rabbitProto = (RabbitProto) template.receiveAndConvert(queueName);
			//RabbitProto rabbitProto = RabbitProto.parseFrom(o.toByteArray());
			Rabbit rabbit = MQUtils.fromProtos(rabbitProto);
			System.out.println("Reecived "+ rabbit);
	}

}
