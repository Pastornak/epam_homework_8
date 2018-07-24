package com.epam.lab.xml.homework.entities;

import com.epam.lab.xml.homework.enums.Transport;
import com.epam.lab.xml.homework.enums.Type;

public class TripPass {
	
	private Type type;
	private String country;
	class NumberOfStaying {
		int days;
		int nights;
		
		NumberOfStaying(){}
		
		NumberOfStaying(int days, int nights) {
			this.days = days;
			this.nights = nights;
		}
	}
	private NumberOfStaying numberOfStaying;
	private Transport transport;
	private Hotel hotel;
	private int cost;
	
	
	public String toString() {
		StringBuilder result = new StringBuilder("Trip pass: ");
		result.append("type - " + type.getRepresentation() + ", ");
		result.append("country - " + country + ", ");
		result.append(numberOfStaying.days + " days, " + numberOfStaying.nights + " nights, ");
		result.append("transport - " + transport.getRepresentation() + ", ");
		result.append("hotel - " + hotel + " ");
		result.append("cost - " + cost + ".");
		return result.toString();
	}
	
	public TripPass() {
		numberOfStaying = new NumberOfStaying();
	}

	public TripPass(Type type, String country, Transport transport, int days, int nights, Hotel hotel, int cost) {
		super();
		this.type = type;
		this.country = country;
		numberOfStaying = new NumberOfStaying(days, nights);
		this.transport = transport;
		this.hotel = hotel;
		this.cost = cost;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getDays() {
		return numberOfStaying.days;
	}
	
	public void setDays(int days) {
		this.numberOfStaying.days = days;
	}
	
	public int getNights() {
		return numberOfStaying.nights;
	}
	
	public void setNights(int nights) {
		this.numberOfStaying.nights = nights;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
