package com.epam.lab.xml.homework.entities.comparators;

import java.util.Comparator;

import com.epam.lab.xml.homework.entities.TripPass;

public class CountryComparator implements Comparator<TripPass>{
	
	@Override
	public int compare(TripPass first, TripPass second) {
		String firstCountry = first.getCountry();
		String secondCountry = second.getCountry();
		return firstCountry.compareTo(secondCountry);
	}

}
