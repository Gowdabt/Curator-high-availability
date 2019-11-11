/**
 * 
 */
package com.infinera.dna.models;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Harshith Gowda B T
 *
 */
@Document(indexName = "dna-nbi-pm", type = "_doc")
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

	public String getGranularity() {
		return granularity;
	}

	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTpId() {
		return tpId;
	}

	public void setTpId(String tpId) {
		this.tpId = tpId;
	}

	public Date getTimeStampValue() {
		return timeStampValue;
	}

	public void setTimeStampValue(Date timeStampValue) {
		this.timeStampValue = timeStampValue;
	}

	public Long getRetrievalTime() {
		return retrievalTime;
	}

	public void setRetrievalTime(Long retrievalTime) {
		this.retrievalTime = retrievalTime;
	}

	public Map<String, String> getRdn() {
		return rdn;
	}

	public void setRdn(Map<String, String> rdn) {
		this.rdn = rdn;
	}

	public Map<String, Float> getPmValue() {
		return pmValue;
	}

	public void setPmValue(Map<String, Float> pmValue) {
		this.pmValue = pmValue;
	}

	public Map<String, Integer> getPmValid() {
		return pmValid;
	}

	public void setPmValid(Map<String, Integer> pmValid) {
		this.pmValid = pmValid;
	}

	@Override
	public String toString() {
		return "PerformanceResource [granularity=" + granularity + ", id=" + id + ", tpId=" + tpId + ", timeStampValue="
				+ timeStampValue + ", retrievalTime=" + retrievalTime + ", rdn=" + rdn + ", pmValue=" + pmValue
				+ ", pmValid=" + pmValid + "]";
	}

	
}