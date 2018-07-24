package com.epam.lab.xml.homework.handlers;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.lab.xml.homework.entities.Hotel;
import com.epam.lab.xml.homework.entities.TripPass;
import com.epam.lab.xml.homework.enums.Meal;
import com.epam.lab.xml.homework.enums.Transport;
import com.epam.lab.xml.homework.enums.Type;

public class SAXCustomHandler extends DefaultHandler{

	private List<TripPass> passes;
	private TripPass pass;
	private Hotel hotel;
	
	public List<TripPass> getPasses(){
		return passes;
	}
	
	private boolean isType;
	private boolean isCountry;
	private boolean isDays;
	private boolean isNights;
	private boolean isTransport;
	private boolean isHotel;
	private boolean isName;
	private boolean isStars;
	private boolean isMeal;
	private boolean isRoom;
	private boolean isTV;
	private boolean isConditioner;
	private boolean isCost;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("TripPass")) {
			pass = new TripPass();
			if(passes == null) {
				passes = new LinkedList<>();
			}
		} else if(qName.equalsIgnoreCase("Type")){
			isType = true;
		} else if(qName.equalsIgnoreCase("Country")) {
			isCountry = true;
		} else if(qName.equalsIgnoreCase("Days")) {
			isDays = true;
		} else if(qName.equalsIgnoreCase("Nights")) {
			isNights = true;
		} else if(qName.equalsIgnoreCase("Transport")) {
			isTransport = true;
		} else if(qName.equalsIgnoreCase("Hotel")) {
			isHotel = true;
			hotel = new Hotel();
		} else if(qName.equalsIgnoreCase("Name")) {
			isName = true;
		} else if(qName.equalsIgnoreCase("Stars")) {
			isStars = true;
		} else if(qName.equalsIgnoreCase("Meal")) {
			isMeal = true;
		} else if(qName.equalsIgnoreCase("Room")) {
			isRoom = true;
		} else if(qName.equalsIgnoreCase("TV")) {
			isTV = true;
		} else if(qName.equalsIgnoreCase("Conditioner")) {
			isConditioner = true;
		} else if(qName.equalsIgnoreCase("Cost")) {
			isCost = true;
		}
	}
	
	@Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("TripPass")) {
			passes.add(pass);
		}
	}
	
	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		String field = new String(ch, start, length);
		if(isType) {
			pass.setType(Type.valueOf(field.toUpperCase()));
			isType = false;
		} else if(isCountry) {
			pass.setCountry(field);
			isCountry = false;
		} else if(isDays) {
			int days = Integer.parseInt(field);
			pass.setDays(days);
			isDays = false;
		} else if(isNights) {
			int nights = Integer.parseInt(field);
			pass.setNights(nights);
			isNights = false;
		} else if(isTransport) {
			pass.setTransport(Transport.valueOf(field.toUpperCase()));
			isTransport = false;
		} else if(isHotel) {
			pass.setHotel(hotel);
			isHotel = false;
		} else if(isName) {
			hotel.setName(field);
			isName = false;
		} else if(isStars) {
			hotel.setStars(Integer.parseInt(field));
			isStars = false;
		} else if(isMeal) {
			hotel.setMeal(Meal.valueOf(field.toUpperCase()));
			isMeal = false;
		} else if(isRoom) {
			hotel.setRooms(Integer.parseInt(field));
			isRoom = false;
		} else if(isTV) {
			hotel.setTVPresent(Boolean.parseBoolean(field));
			isTV = false;
		} else if(isConditioner) {
			hotel.setConditionerPresent(Boolean.parseBoolean(field));
			isConditioner = false;
		} else if(isCost) {
			pass.setCost(Integer.parseInt(field));
			isCost = false;
		}
	}
}
