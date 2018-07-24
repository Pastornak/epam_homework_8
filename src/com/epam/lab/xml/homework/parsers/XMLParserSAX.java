package com.epam.lab.xml.homework.parsers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.epam.lab.xml.homework.entities.TripPass;
import com.epam.lab.xml.homework.handlers.SAXCustomHandler;

public class XMLParserSAX {
	
	public static List<TripPass> parseTripPasses(String filename) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		List<TripPass> result = null;
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			SAXCustomHandler handler = new SAXCustomHandler();
			saxParser.parse(new File(filename), handler);
			result = handler.getPasses();
		} catch(ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
