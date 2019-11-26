/**
 * 
 */
package com.infinera.dna.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author Harshith Gowda B T
 *
 */
@Document(indexName = "dna-nbi-pm", type = "_doc")
@Data
public class PerformanceResource {
	private String granularity;

	@Id
	private String id;

	private String tpId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss.SSS")
	private Date timeStampValue;

	private Long retrievalTime;

	private Map<String, String> rdn;

	private Map<String, Float> pmValue;

	private Map<String, Integer> pmValid;

}