package com.epam.lab.xml.homework.enums;

public enum Meal {
	HB("HB"), BB("BB"), AI("AI");
	
	private String representation;
	
	private Meal(String representation) {
		this.representation = representation;
	}
	
	public String getRepresentation() {
		return representation;
	}
}
