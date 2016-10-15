package org.sugathan.springAmqpExampleWithProtos;

import org.suganthan.springAmpqExampleWithProtos.RabbitProtos.RabbitProto;


public class MQUtils {

	public static Rabbit fromProtos(RabbitProto rabbitProto) {
		Rabbit rabbit = new Rabbit();
		rabbit.setRabbitName(rabbitProto.getRabbitName());
		return rabbit;
	}
	
	public static RabbitProto toProto(Rabbit rabbit) {
		RabbitProto rabbitProto =  RabbitProto
				.newBuilder()
				.setRabbitName(rabbit.getRabbitName())
				.build();
		return rabbitProto;
	}
	
	
	
}
