package com.epam.lab.xml.homework.entities.comparators;

import java.util.Comparator;

import com.epam.lab.xml.homework.entities.TripPass;
import com.epam.lab.xml.homework.enums.Type;

public class TypeComparator implements Comparator<TripPass>{
	
	@Override
	public int compare(TripPass first, TripPass second) {
		Type firstType = first.getType();
		Type secondType = second.getType();
		return firstType.compareTo(secondType);
	}

}
