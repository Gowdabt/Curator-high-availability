/**
 * 
 */
package com.infinera.dna.ha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Harshith Gowda B T
 *
 */
@Document(indexName = "dna-ha-avro-messages-details", type = "_doc")
@Data
@AllArgsConstructor
public class MessageDetails {
	@Id
	private String id;
	private String topicName;
	private long messageOffset;
	private long messageTimeStamp;

}
