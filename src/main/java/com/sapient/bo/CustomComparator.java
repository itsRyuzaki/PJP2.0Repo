package com.sapient.bo;

import java.util.Comparator;

import com.sapient.week2.assignment2.IncomeDetailsPOJO;

public class CustomComparator implements Comparator<IncomeDetailsPOJO> {

	@Override
	public int compare(IncomeDetailsPOJO obj1, IncomeDetailsPOJO obj2) {

		String country1 = obj1.getCountry();
		String country2 = obj2.getCountry();
		if (country1.equals("")) {
			country1 = obj1.getCity();
		}
		if (country2.equals("")) {
			country2 = obj2.getCity();
		}

		if (country1.equals(country2)) {
			if (obj1.getGender().equals(obj2.getGender())) {
				return obj1.getAmount().compareTo(obj2.getAmount());

			}
			return obj1.getGender().compareTo(obj2.getGender());

		}

		return country1.compareTo(country2);
	}

}
