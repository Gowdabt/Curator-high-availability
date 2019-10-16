/**
 * 
 */
package com.infinera.dna.model;

/**
 * @author Harshith Gowda B T
 *
 */

public class PerformanceManagement {
	private TpName tpName;

	private String granularity;

	private PmMeasurementList pmMeasurementList;

	private String retrievalTime;

	public TpName getTpName() {
		return tpName;
	}

	public void setTpName(TpName tpName) {
		this.tpName = tpName;
	}

	public String getGranularity() {
		return granularity;
	}

	public void setGranularity(String granularity) {
		this.granularity = granularity;
	}

	public PmMeasurementList getPmMeasurementList() {
		return pmMeasurementList;
	}

	public void setPmMeasurementList(PmMeasurementList pmMeasurementList) {
		this.pmMeasurementList = pmMeasurementList;
	}

	public String getRetrievalTime() {
		return retrievalTime;
	}

	public void setRetrievalTime(String retrievalTime) {
		this.retrievalTime = retrievalTime;
	}

	@Override
	public String toString() {
		return "PerformanceManagement [tpName = " + tpName + ", granularity = " + granularity + ", pmMeasurementList = "
				+ pmMeasurementList + ", retrievalTime = " + retrievalTime + "]";
	}
}
