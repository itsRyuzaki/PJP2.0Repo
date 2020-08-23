package com.sapient.week2.calculator.bo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public class Operation1 implements CalculatorUtil {

	ArrayList<String> inputList = new ArrayList<>();
	ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	@Override
	public OperationHistoryPOJO solve() {

		String operationHeading = ManageOperations.operationsList[0];

		Display.heading(operationHeading);

		System.out.println("Note: the allowed date format is: dd/MM/yyyy");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter date1: ");
		String sDate1 = Read.in.next();
		LocalDate date1 = LocalDate.parse(sDate1, formatter);

		System.out.print("Enter date2: ");
		String sDate2 = Read.in.next();
		LocalDate date2 = LocalDate.parse(sDate2, formatter);

		inputList.add("Date 1: " + sDate1);
		inputList.add("Date 2: " + sDate2);

		Period intervalPeriod = Period.between(date1, date2);

		int diffDays = intervalPeriod.getDays();
		int diffMonths = intervalPeriod.getMonths();
		int diffYears = intervalPeriod.getYears();

		System.out.println("Result");
		System.out.println("Difference of days: " + diffDays);
		System.out.println("Difference of months: " + diffMonths);
		System.out.println("Difference of years: " + diffYears);

		outputList.add("Difference of days: " + String.valueOf(diffDays));
		outputList.add("Difference of months: " + String.valueOf(diffMonths));
		outputList.add("Difference of years: " + String.valueOf(diffYears));

		ioMap.put(inputList, outputList);

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);

	}

}
