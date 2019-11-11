/**
 * 
 */
package com.infinera.dna.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinera.dna.models.Alert;
import com.infinera.dna.models.NotificationResource;
import com.infinera.dna.repository.KafkaElasticRepository;
import com.infinera.dna.repository.ResourceRepository;

/**
 * @author Harshith Gowda B T
 * 
 */
@Service
public class KafkaElasticServiceImpl implements IKafkaElasticService {

	private static final Logger logger = LogManager.getLogger(KafkaElasticServiceImpl.class);

	@Autowired
	private KafkaElasticRepository KafkaElasticRepo;

	@Autowired
	private ResourceRepository elasticNotificationResource;

	@Value("${unwantedComparison.Data}")
	private String unwantedComparisonKeys;

	@Override
	public void validateAlertData(String fromTime) {
		List<Alert> alertDbData = KafkaElasticRepo.findAll();
		List<NotificationResource> dbNotificationData = getDbNotificationData(alertDbData,
				NumberUtils.toLong(fromTime));
		dbNotificationData.forEach(notifyData -> {
			if (elasticNotificationResource.existsById(notifyData.getId())) {
				Optional<NotificationResource> nr = elasticNotificationResource.findById(notifyData.getId());
				boolean isValid = areEqual(notifyData.getCharacteristic(), nr.get().getCharacteristic());
				logger.info("Data of " + notifyData.getId() + " in both ElasticSearch and DB are   "
						+ (isValid == true ? "Proper" : "Im proper"));
				nr.get().setIsValidated("true");
				nr.get().setTestResult(isValid == true ? "Passed" : "Failed");
				elasticNotificationResource.save(nr.get());
			}
		});
	}

	/**
	 * @param notifyData
	 */
	private void removeUnwantedkeysInMapforComparision(Map<String, String> characteristic) {
		for (String mapKey : unwantedComparisonKeys.split(",")) {
			if (characteristic.keySet().contains(mapKey)) {
				characteristic.remove(mapKey);
			}
		}

	}

	private boolean areEqual(Map<String, String> first, Map<String, String> second) {
		return first.entrySet().stream()
				.allMatch(e -> String.valueOf(e.getValue()).equals(String.valueOf(second.get(e.getKey()))));
	}

	/**
	 * @param alertDbData
	 * @return
	 */
	private List<NotificationResource> getDbNotificationData(List<Alert> alertDbData, long fromTime) {
		List<NotificationResource> notificationResourceList = new ArrayList<>();
		alertDbData.stream().filter(data -> data.getCreatetime() >= fromTime).forEach(data -> {
			NotificationResource nr = new NotificationResource();
			nr.setCategory(data.getCategory());
			nr.setId(data.getEntity());
			nr.setDescription("ALARM");
			nr.setType("ALARM");
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			@SuppressWarnings("unchecked")
			Map<String, String> characteristic = mapper.convertValue(data, Map.class);
			removeUnwantedkeysInMapforComparision(characteristic);
			nr.setCharacteristic(characteristic);
			notificationResourceList.add(nr);
		});
		return notificationResourceList;
	}

}
