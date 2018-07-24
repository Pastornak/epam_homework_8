package com.epam.lab.xml.homework.entities.comparators;

import java.util.Comparator;

import com.epam.lab.xml.homework.entities.TripPass;

public class CostComparator implements Comparator<TripPass>{

	@Override
	public int compare(TripPass first, TripPass second) {
		int firstCost = first.getCost();
		int secondCost = second.getCost();
		return firstCost < secondCost ? 1 : firstCost == secondCost? 0 : 1;
	}
	
}
