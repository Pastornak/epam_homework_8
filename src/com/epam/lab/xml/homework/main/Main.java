package com.epam.lab.xml.homework.main;

import com.epam.lab.xml.homework.parsers.*;
import com.epam.lab.xml.homework.validator.XMLValidator;

public class Main {
	
	private static String FILENAME_INFO = "src//com//epam//lab//xml//homework//files//example_info.xml";
	private static String FILENAME_LIST = "src//com//epam//lab//xml//homework//files//example_list.xml";
	private static String VALIDATION_FILE = "src//com//epam//lab//xml//homework//files//TouristVoucher.xsd";

	public static void main(String[] args) {
		System.out.println("SAX parser:");
		System.out.println("For one element in xml:");
		XMLParserSAX.parseTripPasses(FILENAME_INFO).forEach(System.out::println);
		System.out.println("For list of elements in xml:");
		XMLParserSAX.parseTripPasses(FILENAME_LIST).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("DOM parser:");
		System.out.println("For one element in xml:");
		XMLParserDOM.parseTripPasses(FILENAME_INFO).forEach(System.out::println);
		System.out.println("For list of elements in xml:");
		XMLParserDOM.parseTripPasses(FILENAME_LIST).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("StAX parser:");
		System.out.println("For one element in xml:");
		XMLParserStAX.parseTripPasses(FILENAME_INFO).forEach(System.out::println);
		System.out.println("For list of elements in xml:");
		XMLParserStAX.parseTripPasses(FILENAME_LIST).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Validation");
		System.out.print("Is " + FILENAME_INFO + " valid against " + VALIDATION_FILE + ": ");
		System.out.println(XMLValidator.validateAgainstXSD(FILENAME_INFO, VALIDATION_FILE));
		System.out.print("Is " + FILENAME_LIST + " valid against " + VALIDATION_FILE + ": ");
		System.out.println(XMLValidator.validateAgainstXSD(FILENAME_LIST, VALIDATION_FILE));
	}

}
