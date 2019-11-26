/**
 * 
 */
package com.infinera.dna.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Harshith Gowda B T
 *
 */
@Component
@Document(indexName = "dna-nbi-alarm-notify", type = "_doc")
@Data
public class NotificationResource {

	@Id
	private String id;

	private String description;

	private String type;

	private String category;

	private String version;

	private String baseType;

	private String isValidated = "false";

	private String testResult = "";

	private Map<String, String> characteristic;


}