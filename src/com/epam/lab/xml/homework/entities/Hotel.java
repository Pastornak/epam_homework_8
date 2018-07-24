package com.epam.lab.xml.homework.entities;

import com.epam.lab.xml.homework.enums.Meal;

public class Hotel {
	
	private String name;
	private int stars;
	private Meal meal;
	private int rooms;
	private boolean isTVPresent;
	private boolean isConditionerPresent;

	public Hotel() {}

	public Hotel(String name, int stars, Meal meal, int rooms, boolean isTVPresent, boolean isConditionerPresent) {
		super();
		this.name = name;
		this.stars = stars;
		this.meal = meal;
		this.rooms = rooms;
		this.isTVPresent = isTVPresent;
		this.isConditionerPresent = isConditionerPresent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public boolean isTVPresent() {
		return isTVPresent;
	}

	public void setTVPresent(boolean isTVPresent) {
		this.isTVPresent = isTVPresent;
	}

	public boolean isConditionerPresent() {
		return isConditionerPresent;
	}

	public void setConditionerPresent(boolean isConditionerPresent) {
		this.isConditionerPresent = isConditionerPresent;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("Hotel ");
		result.append(name + ", ");
		result.append(stars + " stars, ");
		result.append("meal: " + meal.getRepresentation() + ", ");
		result.append(rooms + " rooms, ");
		if(isTVPresent) {
			result.append("has TV, ");
		} else {
			result.append("no TV, ");
		}
		if(isConditionerPresent) {
			result.append("has Conditioner.");
		} else {
			result.append("no Conditioner.");
		}
		return result.toString();
	}
}
