/**
 * 
 */
package com.infinera.dna.model;

import java.util.List;

/**
 * @author Harshith Gowda B T
 *
 */
public class TpName {
	private List<Rdn> rdn;

	public List<Rdn> getRdn() {
		return rdn;
	}

	public void setRdn(List<Rdn> rdn) {
		this.rdn = rdn;
	}

	@Override
	public String toString() {
		return "TpName [rdn=" + rdn + "]";
	}

}
