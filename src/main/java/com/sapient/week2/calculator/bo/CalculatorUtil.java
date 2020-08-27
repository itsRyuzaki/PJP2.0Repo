package com.sapient.week2.calculator.bo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public abstract class CalculatorUtil {

	public ArrayList<String> inputList = new ArrayList<>();
	public ArrayList<String> outputList = new ArrayList<>();
	public LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();
	public String operationHeading;
	public Random numberGenerator = new Random();

	public abstract OperationHistoryPOJO solve(int operationNum);

	public abstract void dummyOperationInput(BufferedWriter bw) throws IOException;

	public void addIOListAndClear() {
		ioMap.put(inputList, outputList);
		inputList = new ArrayList<>();
		outputList = new ArrayList<>();
	}

	public void setAndDisplayHeading(int operationNum) {
		operationHeading = ManageOperations.operationsList.get(operationNum);

		Display.heading(operationHeading);

	}

	public String generateRandomDate() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate start = LocalDate.of(1500, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(9000, Month.DECEMBER, 31);

		long startEpochDay = start.toEpochDay();
		long endEpochDay = end.toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
		String date = LocalDate.ofEpochDay(randomDay).format(formatter);

		return date;

	}

	public int checkInteger(String input, int defaultValue) {

		// default output
		int outputInteger = defaultValue;
		int maxTries = 5;
		boolean integerFormat = false;
		while (integerFormat == false) {
			try {
				outputInteger = Integer.parseInt(input);
				integerFormat = true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input!");

				this.outputList.add("User entered invalid input.");
				this.addIOListAndClear();

				if (maxTries == 0) {
					break;
				}

				System.out.print("Please enter an integer");
				input = Read.in.next();
				this.inputList.add("Value entered again: " + input);
			}
			maxTries--;
		}
		if (maxTries == 0) {
			System.out.println("Maximum no of tries reached!! Taking default value = " + defaultValue);
			outputList.add("User exceeded maximum number of attempts. Default Value = " + defaultValue);
		}

		return outputInteger;
	}
}
