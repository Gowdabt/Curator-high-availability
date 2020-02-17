
package com.infinera.dna.ha.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.infinera.dna.ha.dao.MessageRepository;
import com.infinera.dna.ha.model.MessageDetails;

/**
 * @author Harshith Gowda B T
 *
 */
@Service
public class ConsumerService {

	@Autowired
	private MessageRepository mr;

	private static final Logger logger = LogManager.getLogger(ConsumerService.class);
	private int messageCount = 0;

	private MessageDetails msd = null;

	@KafkaListener(topics = "#{'${kafka.topic}'.split(',')}", groupId = "SampleConsumer_mess")
	public void consume(ConsumerRecord<?, Map<String, String>> message) {

		String topicName = message.topic();
		String messageData = String.valueOf(message.value());
		int start=message.key().toString().indexOf("M");
		String messagekey=message.key().toString().substring(start,start+12);
		messageCount++;
		logger.info("Topic Name =" + message.topic() +" message key= "+message.topic()+"_"+messagekey+"_" + message.offset()+"                "+message.key());
		
		msd = new MessageDetails(message.topic()+"_"+messagekey+"_" + message.offset(), message.topic(), message.offset(),message.timestamp());
		mr.save(msd);
		msd = null;
	}

}
