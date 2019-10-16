package com.infinera.dna.model;

/**
 * @author Harshith Gowda B T
 *
 */
import java.util.List;

public class Resource {
	private String description;

	private String id;

	private String type;

	private String category;

	private String version;

	private List<Characteristic> characteristic;

	private String baseType;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Characteristic> getCharacteristic() {
		return characteristic;
	}

	public void setCharacteristic(List<Characteristic> characteristic) {
		this.characteristic = characteristic;
	}

	public String getBaseType() {
		return baseType;
	}

	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}

	@Override
	public String toString() {
		return "Resource [description = " + description + ", id = " + id + ", type = " + type + ", category = "
				+ category + ", version = " + version + ", characteristic = " + characteristic + ", baseType = "
				+ baseType + "]";
	}
}