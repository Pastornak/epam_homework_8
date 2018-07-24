package com.epam.lab.xml.homework.enums;

public enum Type {
	HOLIDAY("holiday"), WEEKEND("weekend"), EXCURSION("excursion"), PILGRIMAGE("pilgrimage");
	
	private String representation;
	
	private Type(String representation) {
		this.representation = representation;
	}
	
	public String getRepresentation() {
		return representation;
	}
}
