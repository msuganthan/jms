package org.suganthan.rabbitmq.example.workQueue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class QueueSend {

	private static final String TASK_QUEUE_NAME = "task_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		String message = getMessage("Let's see what's gonna happen".split(" "));
		channel.basicPublish("", TASK_QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println("[x] Send "+message);
		
		channel.close();
		connection.close();

	}
	
	private static String getMessage(String[] strings){
	    return joinStrings(strings, " ");
	}
	
	private static String joinStrings(String[] strings, String delimiter) {
	    int length = strings.length;
	    if (length == 0) return "";
	    StringBuilder words = new StringBuilder(strings[0]);
	    for (int i = 1; i < length; i++) {
	        words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	}

}
