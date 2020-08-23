package com.sapient.week2.calculator.bo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public class Operation3 implements CalculatorUtil {

	ArrayList<String> inputList = new ArrayList<>();
	ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	@Override
	public OperationHistoryPOJO solve() {

		String operationHeading = ManageOperations.operationsList[2];

		Display.heading(operationHeading);

		System.out.println("Note: the allowed date format is: dd/MM/yyyy");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter date: ");
		String sDate = Read.in.next();
		LocalDate date = LocalDate.parse(sDate, formatter);

		inputList.add("Date: " + sDate);

		DayOfWeek dayNumber = date.getDayOfWeek();
		String dayName = dayNumber.getDisplayName(TextStyle.FULL, Locale.UK);
		System.out.println("The day is: " + dayName);

		int weekNumber = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
		System.out.println("Week Number: " + weekNumber);

		outputList.add("Day: " + dayName);
		outputList.add("Week Number: " + weekNumber);

		ioMap.put(inputList, outputList);

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);

	}
}
