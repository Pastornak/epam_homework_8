package com.epam.lab.xml.homework.parsers;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.epam.lab.xml.homework.entities.*;
import com.epam.lab.xml.homework.enums.*;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParserDOM {
	
	public static List<TripPass> parseTripPasses(String filename) {
		List<TripPass> result = new LinkedList<>();
		TripPass tempPass = null;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        	Document doc = dBuilder.parse(new File(filename));
        	doc.getDocumentElement().normalize();
        	NodeList passNodes = doc.getElementsByTagName("trippass");
        	for(int i = 0; i < passNodes.getLength(); i++) {
        		Node passNode = passNodes.item(i);
        		if(passNode.getNodeType() == Node.ELEMENT_NODE) {
        			Element passElement = (Element) passNode;
        			tempPass = getTripPass(passElement);
        			result.add(tempPass);
        		}
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	private static TripPass getTripPass(Element passElement) {
		TripPass result = new TripPass();
		Hotel tempHotel = new Hotel();
		String typeText = getText(passElement, "type");
		result.setType(Type.valueOf(typeText.toUpperCase()));
		String countryText = getText(passElement, "country");
		result.setCountry(countryText);
		//staying
		Node stayingNode = passElement.getElementsByTagName("staying").item(0);
		if(stayingNode.getNodeType() == Node.ELEMENT_NODE) {
			Element stayingElement = (Element) stayingNode;
			String daysText = getText(stayingElement, "days");
			result.setDays(Integer.parseInt(daysText));
			String nightsText = getText(stayingElement, "nights");
			result.setNights(Integer.parseInt(nightsText));
		}
		//hotel
		Node hotelNode = passElement.getElementsByTagName("hotel").item(0);
		if(hotelNode.getNodeType() == Node.ELEMENT_NODE) {
			Element hotelElement = (Element) hotelNode;
			tempHotel = getHotel(hotelElement);
		}
		result.setHotel(tempHotel);
		
		String transportText = getText(passElement, "transport");
		result.setTransport(Transport.valueOf(transportText.toUpperCase()));
		String costText = getText(passElement, "cost");
		result.setCost(Integer.parseInt(costText));
		return result;
	}
	
	private static Hotel getHotel(Element hotelElement) {
		Hotel hotel = new Hotel();
		String nameText = getText(hotelElement, "name");
		hotel.setName(nameText);
		String starsText = getText(hotelElement, "stars");
		hotel.setStars(Integer.parseInt(starsText));
		String mealText = getText(hotelElement, "meal");
		hotel.setMeal(Meal.valueOf(mealText.toUpperCase()));
		String roomText = getText(hotelElement, "room");
		hotel.setRooms(Integer.parseInt(roomText));
		String tvText = getText(hotelElement, "tv");
		hotel.setTVPresent(Boolean.parseBoolean(tvText));
		String conditionerText = getText(hotelElement, "conditioner");
		hotel.setConditionerPresent(Boolean.parseBoolean(conditionerText));
		return hotel;
	}
	
	private static String getText(Element element, String tagName) {
		return element.getElementsByTagName(tagName).item(0).getTextContent();
	}
}
