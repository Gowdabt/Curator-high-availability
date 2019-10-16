/**
 * 
 */
package com.infinera.dna.model;

/**
 * @author Harshith Gowda B T
 *
 */
public class PmMeasurement {
	private String pmIntervalStatus;

	private String pmParameterName;

	private String value;

	public String getPmIntervalStatus() {
		return pmIntervalStatus;
	}

	public void setPmIntervalStatus(String pmIntervalStatus) {
		this.pmIntervalStatus = pmIntervalStatus;
	}

	public String getPmParameterName() {
		return pmParameterName;
	}

	public void setPmParameterName(String pmParameterName) {
		this.pmParameterName = pmParameterName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PmMeasurement [pmIntervalStatus = " + pmIntervalStatus + ", pmParameterName = " + pmParameterName
				+ ", value = " + value + "]";
	}
}