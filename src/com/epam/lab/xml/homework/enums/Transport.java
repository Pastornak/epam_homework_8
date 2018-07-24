package com.epam.lab.xml.homework.enums;

public enum Transport {
	AIR("air"), RAIL("rail"), AUTO("auto"), LINER("liner");
	
	private String representation;
	
	private Transport(String representation) {
		this.representation = representation;
	}
	
	public String getRepresentation() {
		return representation;
	}
}
