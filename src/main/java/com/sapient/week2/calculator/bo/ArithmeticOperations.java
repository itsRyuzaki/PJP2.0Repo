package com.sapient.week2.calculator.bo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Read;

public class ArithmeticOperations extends CalculatorUtil {

	@Override
	public OperationHistoryPOJO solve(int operationNum) {

		this.setAndDisplayHeading(operationNum);

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

		this.addIOListAndClear();

		System.out.print("\nEnter no. of days to " + choice.toLowerCase() + ": ");
		String snumOfDays = Read.in.next();
		int numOfDays = checkInteger(snumOfDays, 5);
		System.out.print("Enter no. of weeks to " + choice.toLowerCase() + ": ");
		String snumOfWeeks = Read.in.next();
		int numOfWeeks = checkInteger(snumOfWeeks, 5);
		System.out.print("Enter no. of months to " + choice.toLowerCase() + ": ");
		String snumOfMonths = Read.in.next();
		int numOfMonths = checkInteger(snumOfMonths, 5);

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

		this.addIOListAndClear();

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

	public String checkIfChoiceIsValid(String choice) {

		int maxCount = 1;

		while (!choice.toLowerCase().equals("add") && !choice.toLowerCase().equals("subtract")) {
			System.out.println("Invalid choice type!!");
			outputList.add("User entered invalid choice type");

			this.addIOListAndClear();

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

	@Override
	public void dummyOperationInput(BufferedWriter bw) throws IOException {

		String[] arithmeticOpType = { "Add", "Subtract" };

		bw.write(generateRandomDate() + "\n");
		bw.write(arithmeticOpType[numberGenerator.nextInt(2)] + "\n");
		bw.write(String.valueOf(numberGenerator.nextInt(30)) + "\n");
		bw.write(String.valueOf(numberGenerator.nextInt(30)) + "\n");
		bw.write(String.valueOf(numberGenerator.nextInt(30)) + "\n");

	}

}
