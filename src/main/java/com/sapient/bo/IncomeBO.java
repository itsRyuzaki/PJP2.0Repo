package com.sapient.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.sapient.week2.assignment2.IncomeDetailsPOJO;

public class IncomeBO {

	private static HashMap<String, Double> currencyConversionMap = new HashMap<>();
	private static HashMap<String, Double> averageAmountMap = new HashMap<>();
	private static ArrayList<IncomeDetailsPOJO> finalIncomeList = new ArrayList<>();

	static {

		currencyConversionMap.put("INR", 66d);
		currencyConversionMap.put("GBP", 0.67d);
		currencyConversionMap.put("SGD", 1.5d);
		currencyConversionMap.put("HKD", 8d);
		currencyConversionMap.put("USD", 1d);

	}

	public static ArrayList<IncomeDetailsPOJO> processIncomeDetails(ArrayList<String[]> incomeDetailsList) {

		System.out.println("Please wait...processing the contents of file.");

		incomeDetailsList.forEach((element) -> {
			IncomeDetailsPOJO tempOBJ = new IncomeDetailsPOJO();
			tempOBJ.setCity(element[0]);
			tempOBJ.setCountry(element[1]);
			tempOBJ.setGender(element[2]);
			tempOBJ.setCurrency(element[3]);
			double amount = Double.parseDouble(element[4]) / currencyConversionMap.get(element[3]);
			tempOBJ.setAmount(amount);
			if (averageAmountMap.containsKey(element[3])) {
				amount = (amount + averageAmountMap.get(element[3])) / 2;
			}
			averageAmountMap.put(element[3], amount);
			finalIncomeList.add(tempOBJ);
		});

		setAverageIncome();

		System.out.println("Sorting the final contents");

		Collections.sort(finalIncomeList, new CustomComparator());

		System.out.println("Done processing!");

		return finalIncomeList;

	}

	private static void setAverageIncome() {

		System.out.println("Calculating average income...");

		for (int i = 0; i < finalIncomeList.size(); i++) {
			Double amount = averageAmountMap.get(finalIncomeList.get(i).getCurrency());
			finalIncomeList.get(i).setAmount(amount);
		}
	}

}
