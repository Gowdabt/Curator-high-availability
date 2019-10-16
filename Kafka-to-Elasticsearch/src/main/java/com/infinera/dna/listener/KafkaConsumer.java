package com.infinera.dna.listener;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinera.dna.model.NotificationResource;
import com.infinera.dna.model.PerformanceManagement;
import com.infinera.dna.model.PerformanceResource;
import com.infinera.dna.model.PmMeasurement;
import com.infinera.dna.model.Resource;
import com.infinera.dna.repository.PerformanceMgmtRepository;
import com.infinera.dna.repository.ResourceRepository;

/**
 * @author Harshith Gowda B T
 *
 */
@Service
public class KafkaConsumer {
	
	private static final Logger logger = LogManager.getLogger(KafkaConsumer.class);

	@Autowired
	private ResourceRepository resRepo;

	@Autowired
	private PerformanceMgmtRepository perfMgmtRepo;

	/**
	 * 
	 * Reads new message from Kafka Broker
	 */

	@KafkaListener(topics = "#{'${kafka.topic}'.split(',')}", groupId = "SampleConsumer_mess")
	public void consume(ConsumerRecord<?, Map<String, String>> message) {

		try {
			String topicName = message.topic();
			String messageData = String.valueOf(message.value());
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			if (topicName.contains("EMS_KAFKA_ALARMS_TOPIC")) {
				NotificationResource nr = getModifiedNotificationData(mapper.readValue(messageData, Resource.class));
				resRepo.save(nr);
			} else if (topicName.endsWith("PM")) {
				PerformanceResource pr = getModifiedPerformanceData(
						mapper.readValue(messageData, PerformanceManagement.class), topicName);
				perfMgmtRepo.save(pr);
			} else {

			}

		} catch (IOException e) {
			logger.error("Exception occured at KafkaConsumer.java :: consume method", e);
		}
	}

	/**
	 * @param PerformanceManagement object
	 * @return PerformanceResource Object
	 */
	private PerformanceResource getModifiedPerformanceData(PerformanceManagement performance, String topicName) {
		PerformanceResource pr = new PerformanceResource();
		Map<String, Float> pmValue = new HashMap<>();
		Map<String, Integer> pmValid = new HashMap<>();
		Map<String, String> rdn = new HashMap<>();

		pr.setGranularity(performance.getGranularity());
		pr.setRetrievalTime(NumberUtils.toLong(performance.getRetrievalTime()));
		pr.setId(topicName + performance.getRetrievalTime());
		pr.setTpId(topicName);
		pr.setTimeStampValue(new Date(NumberUtils.toLong(performance.getRetrievalTime(), 0)));
		performance.getTpName().getRdn().forEach(data -> {
			rdn.put(data.getType(), data.getValue());
		});
		pr.setRdn(rdn);
		List<PmMeasurement> pmData = performance.getPmMeasurementList().getPmMeasurement();
		pmData.forEach(data -> {
			pmValue.put(data.getPmParameterName(), NumberUtils.toFloat(data.getValue(), 0));
			pmValid.put(data.getPmParameterName(), NumberUtils.toInt(data.getPmIntervalStatus(), 0));
		});
		pr.setPmValue(pmValue);
		pr.setPmValid(pmValid);

		return pr;
	}

	/**
	 * @param Resource Object
	 * @return NotificationResource Object
	 */
	private NotificationResource getModifiedNotificationData(Resource resource) {
		NotificationResource mr = new NotificationResource();
		Map<String, String> characteristic = new HashMap<>();
		mr.setBaseType(resource.getBaseType());
		mr.setCategory(resource.getCategory());
		mr.setDescription(resource.getDescription());
		mr.setType(resource.getType());
		mr.setVersion(resource.getVersion());
		mr.setId(resource.getId());
		resource.getCharacteristic().forEach(data -> {
			characteristic.put(data.getName(), data.getValue());
		});
		mr.setCharacteristic(characteristic);
		return mr;
	}

}
