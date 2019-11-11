package com.infinera.dna.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infinera.dna.service.IKafkaElasticService;

/**
 * 
 */

/**
 * @author Harshith Gowda B T
 *
 */
@RestController
public class KafkaElasticController {

	private static final Logger logger = LogManager.getLogger(KafkaElasticController.class);

	@Autowired
	private IKafkaElasticService kafkaService;

	@GetMapping("ValidateNotificationData/{fromTime}")
	public String validateDNAElasticData(@PathVariable("fromTime") String fromTime) {
		try {
			kafkaService.validateAlertData(fromTime);
		} catch (Exception e) {
			logger.error("Exception occured at KafkaElasticController validateDNAElasticData method ", e);
		}

		return "";
	}
}
