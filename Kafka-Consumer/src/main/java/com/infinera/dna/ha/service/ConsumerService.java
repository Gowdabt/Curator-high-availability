
package com.infinera.dna.ha.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


/**
 * @author Harshith Gowda B T
 *
 */
@Service
public class ConsumerService {
	private static final Logger logger = LogManager.getLogger(ConsumerService.class);
	
	private Map<String,Set<String>> nodeData= new HashMap<>();
	private int messageCount=0;
	
	
	@KafkaListener(topics = "#{'${kafka.topic}'.split(',')}", groupId = "SampleConsumer_mess")
	public void consume(ConsumerRecord<?, Map<String, String>> message) {
		
		String topicName = message.topic();
		String messageData = String.valueOf(message.value());
		messageCount++;
		logger.info("Topic Name ="+message.topic()+" Message count ="+messageCount+"   message offset ="+message.offset()+"  message timeStamp ="+message.timestamp());
		
		/*
		parsing message to bean object
		
		*/
		
		
		
	}

}
