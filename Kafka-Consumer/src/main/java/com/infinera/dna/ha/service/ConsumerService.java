
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
	
	boolean isFirst=true;

	@Autowired
	private MessageRepository mr;

	private static final Logger logger = LogManager.getLogger(ConsumerService.class);
	private int messageCount = 0;

	private MessageDetails msdstart = null;
	private MessageDetails msdoffset = null;

	@KafkaListener(topics = "#{'${kafka.topic}'.split(',')}", groupId = "SampleConsumer_mess")
	public void consume(ConsumerRecord<?, Map<String, String>> message) {

		String topicName = message.topic();
		String messageData = String.valueOf(message.value());
		if(message.key().toString().contains("M")){
		int start=message.key().toString().indexOf("M");
		int end=message.key().toString().indexOf("=");
		String motype=null;
		try {
			motype=message.key().toString().substring(start+13,end); // this enhance for extracting motype, if no /NODEID/MOTYPE=XXX not there then NODEID
		}catch (Exception e) {
			motype=message.key().toString().substring(start,start+12);
		}
		logger.info(motype);
		//Now we have to frame _id
		String _idstart=message.topic() + "-" + motype + "-" + "START";
		String _idoffset=message.topic() + "-" + motype + "-" + "OFFSET";

		if(isFirst)
		{
			//Set message.offset() for both 
			msdstart = new MessageDetails(_idstart, message.topic(), motype, message.offset(),message.timestamp());
			isFirst=false;
			mr.save(msdstart);
			msdstart = null;
		}
		
		//Anyway set offset
		
		msdoffset =  new MessageDetails(_idoffset, message.topic(), motype, message.offset(),message.timestamp());
		mr.save(msdoffset);
		msdoffset = null;
	}
	}

}
