/**
 * 
 */
package com.infinera.dna.model;

import java.util.List;

/**
 * @author Harshith Gowda B T
 *
 */
public class PmMeasurementList {
	private List<PmMeasurement> pmMeasurement;

	public List<PmMeasurement> getPmMeasurement() {
		return pmMeasurement;
	}

	public void setPmMeasurement(List<PmMeasurement> pmMeasurement) {
		this.pmMeasurement = pmMeasurement;
	}

	@Override
	public String toString() {
		return "PmMeasurementList [pmMeasurement=" + pmMeasurement + "]";
	}

}
