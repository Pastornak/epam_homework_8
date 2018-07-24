package com.epam.lab.xml.homework.parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.epam.lab.xml.homework.entities.Hotel;
import com.epam.lab.xml.homework.entities.TripPass;
import com.epam.lab.xml.homework.enums.Meal;
import com.epam.lab.xml.homework.enums.Transport;
import com.epam.lab.xml.homework.enums.Type;

public class XMLParserStAX {

	public static List<TripPass> parseTripPasses(String filename){
		List<TripPass> result = new LinkedList<>();
		TripPass tripPass = null;
		Hotel hotel = null;
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {
			XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(filename));
			while(xmlEventReader.hasNext()) {
				XMLEvent xmlEvent = xmlEventReader.nextEvent();
				if(xmlEvent.isStartElement()) {
					StartElement startElement = xmlEvent.asStartElement();
					String elementName = startElement.getName().getLocalPart();
					if(elementName.equalsIgnoreCase("TripPass")) {
						tripPass = new TripPass();
					} else if(elementName.equalsIgnoreCase("Type")) {
						xmlEvent = xmlEventReader.nextEvent();
						String data = getElementData(xmlEvent);
						Type type = Type.valueOf(data.toUpperCase());
						tripPass.setType(type);
					} else if(elementName.equalsIgnoreCase("Country")) {
						String data = getElementData(xmlEventReader.nextEvent());
						tripPass.setCountry(data);
					} else if(elementName.equalsIgnoreCase("Days")) {
						String data = getElementData(xmlEventReader.nextEvent());
						tripPass.setDays(Integer.parseInt(data));
					} else if(elementName.equalsIgnoreCase("Nights")) {
						String data = getElementData(xmlEventReader.nextEvent());
						tripPass.setNights(Integer.parseInt(data));
					} else if(elementName.equalsIgnoreCase("Transport")) {
						String data = getElementData(xmlEventReader.nextEvent());
						tripPass.setTransport(Transport.valueOf(data.toUpperCase()));
					} else if(elementName.equalsIgnoreCase("Hotel")) {
						hotel = new Hotel();
					} else if(elementName.equalsIgnoreCase("Name")) {
						String data = getElementData(xmlEventReader.nextEvent());
						hotel.setName(data);
					} else if(elementName.equalsIgnoreCase("Stars")) {
						String data = getElementData(xmlEventReader.nextEvent());
						hotel.setStars(Integer.parseInt(data));
					} else if(elementName.equalsIgnoreCase("Meal")) {
						String data = getElementData(xmlEventReader.nextEvent());
						hotel.setMeal(Meal.valueOf(data.toUpperCase()));
					} else if(elementName.equalsIgnoreCase("Room")) {
						String data = getElementData(xmlEventReader.nextEvent());
						hotel.setRooms(Integer.parseInt(data));
					} else if(elementName.equalsIgnoreCase("TV")) {
						String data = getElementData(xmlEventReader.nextEvent());
						hotel.setTVPresent(Boolean.parseBoolean(data));
					} else if(elementName.equalsIgnoreCase("Conditioner")) {
						String data = getElementData(xmlEventReader.nextEvent());
						hotel.setConditionerPresent(Boolean.parseBoolean(data));
					} else if(elementName.equalsIgnoreCase("Cost")) {
						String data = getElementData(xmlEventReader.nextEvent());
						tripPass.setCost(Integer.parseInt(data));
					}
				}
				if(xmlEvent.isEndElement()) {
					EndElement endElement = xmlEvent.asEndElement();
					String elementName = endElement.getName().getLocalPart();
					if(elementName.equalsIgnoreCase("Hotel")) {
						tripPass.setHotel(hotel);
					} else if(elementName.equalsIgnoreCase("TripPass")) {
						result.add(tripPass);
					}
				}
			}
		} catch(FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static String getElementData(XMLEvent event) {
		return event.asCharacters().getData();
	}
}
