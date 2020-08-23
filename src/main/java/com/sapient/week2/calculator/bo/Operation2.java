package com.sapient.week2.calculator.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public class Operation2 implements CalculatorUtil {

	public ArrayList<String> inputList = new ArrayList<>();
	public ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	@Override
	public OperationHistoryPOJO solve() {

		String operationHeading = ManageOperations.operationsList[1];

		Display.heading(operationHeading);

		System.out.println("Note: the allowed date format is: dd/MM/yyyy");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter date: ");
		String sDate = Read.in.next();
		LocalDate date = LocalDate.parse(sDate, formatter);

		inputList.add("Date: " + sDate);

		System.out.print("Enter the type of operation(Add | Subtract): ");
		String choice = Read.in.next();

		inputList.add("Type of Operation: " + choice);

		choice = checkIfChoiceIsValid(choice);

		outputList.add("Valid choice entered: " + choice.toUpperCase());

		ioMap.put(inputList, outputList);
		inputList = new ArrayList<>();
		outputList = new ArrayList<>();

		System.out.print("\nEnter no. of days to " + choice.toLowerCase() + ": ");
		int numOfDays = Read.in.nextInt();
		System.out.print("Enter no. of weeks to " + choice.toLowerCase() + ": ");
		int numOfWeeks = Read.in.nextInt();
		System.out.print("Enter no. of months to " + choice.toLowerCase() + ": ");
		int numOfMonths = Read.in.nextInt();

		inputList.add("Days to " + choice.toLowerCase() + ": " + String.valueOf(numOfDays));
		inputList.add("Weeks to " + choice.toLowerCase() + ": " + String.valueOf(numOfWeeks));
		inputList.add("Months to " + choice.toLowerCase() + ": " + String.valueOf(numOfMonths));

		int sign = 1;

		if (choice.toLowerCase().equals("subtract")) {
			sign = -1;
		}

		LocalDate finalResult = getFinalDate(date, sign, numOfDays, numOfWeeks, numOfMonths);

		String resultString = "Final date after " + choice.toLowerCase() + "ing: " + finalResult.format(formatter);

		System.out.println(resultString);
		outputList.add(resultString);

		ioMap.put(inputList, outputList);

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

	public String checkIfChoiceIsValid(String choice) {

		int maxCount = 1;

		while (!choice.toLowerCase().equals("add") && !choice.toLowerCase().equals("subtract")) {
			System.out.println("Invalid choice type!!");
			outputList.add("User entered invalid choice type");

			ioMap.put(inputList, outputList);
			inputList = new ArrayList<>();
			outputList = new ArrayList<>();

			if (maxCount == 5) {
				choice = "add";
				System.out.println("Maximum number of tries reached...taking default operation(add)");
				inputList.add("Type of Operation(using default value): " + choice.toUpperCase());

			} else {

				System.out.print("Enter the type of operation(Add | Subtract) again: ");
				choice = Read.in.next();

				inputList.add("Type of Operation: " + choice.toUpperCase());
			}

			maxCount++;
		}
		return choice;
	}

	public LocalDate getFinalDate(LocalDate date, int sign, int numOfDays, int numOfWeeks, int numOfMonths) {

		LocalDate addDays = date.plus(sign * numOfDays, ChronoUnit.DAYS);
		LocalDate addWeeks = addDays.plus(sign * numOfWeeks, ChronoUnit.WEEKS);
		LocalDate finalResult = addWeeks.plus(sign * numOfMonths, ChronoUnit.MONTHS);

		return finalResult;
	}

}
