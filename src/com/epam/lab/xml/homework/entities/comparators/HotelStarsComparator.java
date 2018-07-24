package com.epam.lab.xml.homework.entities.comparators;

import java.util.Comparator;

import com.epam.lab.xml.homework.entities.Hotel;
import com.epam.lab.xml.homework.entities.TripPass;

public class HotelStarsComparator implements Comparator<TripPass>{
	
	@Override
	public int compare(TripPass first, TripPass second) {
		Hotel firstHotel = first.getHotel();
		Hotel secondHotel = second.getHotel();
		int firstStars = firstHotel.getStars();
		int secondStars = secondHotel.getStars();
		return firstStars < secondStars ? -1 : firstStars == secondStars ? 0 : 1;
	}

}
