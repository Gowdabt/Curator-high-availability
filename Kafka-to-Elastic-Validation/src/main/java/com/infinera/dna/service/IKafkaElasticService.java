/**
 * 
 */
package com.infinera.dna.service;

/**
 * @author Harshith Gowda B T
 *
 */
public interface IKafkaElasticService {

	/**	
	 * @param fromTime
	 * @param alarmTopicName
	 * 
	 */
	public void validateAlertData(String fromTime);

}
