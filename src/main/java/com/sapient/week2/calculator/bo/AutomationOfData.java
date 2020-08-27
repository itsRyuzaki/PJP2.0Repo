package com.sapient.week2.calculator.bo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Read;

public class AutomationOfData extends CalculatorUtil {

	String outputFilePath = "./AutomatedData.txt";

	@Override
	public OperationHistoryPOJO solve(int operationNum) {
		this.setAndDisplayHeading(operationNum);

		System.out.print("Enter the number of operations you want to generate: ");
		String snumOfOperations = Read.in.next();

		inputList.add("Number of operation entered: " + snumOfOperations);

		int numOfOperations = this.checkInteger(snumOfOperations, 10);

		if (numOfOperations > 100000) {
			System.out.println("Number of operations cannot exceed 100000");
			System.out.println("Number of operations set to 100000");
			numOfOperations = 100000;
			outputList.add("User entered a value of more than 100000...restricting the value to 100000!");
		} else if (numOfOperations < 1) {
			System.out.println("Number of operations cannot be zero or less");
			System.out.println("Number of operations set to 10");
			numOfOperations = 10;
			outputList.add("User entered a value less than 1...setting the value to 10!");

		} else {
			outputList.add("Valid number of operations entered");
		}

		System.out.println("Hang on while we generate random operations...");
		try {
			generateRandomOperations(numOfOperations);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(
				"Done! Random " + numOfOperations + " operations were generated and stored in AutomtedData.txt");

		outputList.add("Random " + numOfOperations + " operations were generated and stored in AutomtedData.txt");

		this.addIOListAndClear();

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

	public void generateRandomOperations(int numOfOperations) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));
		ArrayList<Integer> choices = new ArrayList<>();
		for (int i = 1; i < 8; i++) {
			choices.add(i);
		}
		bw.write("m\n");

		for (int i = 0; i < numOfOperations; i++) {

			int finalChoice = choices.get(numberGenerator.nextInt(7));
			bw.write(String.valueOf(finalChoice));
			bw.append("\n");

			ManageOperations.getUtilityList()[finalChoice - 1].dummyOperationInput(bw);
			bw.write("m\n");

		}
		bw.write(String.valueOf(-1));

		bw.close();
	}

	@Override
	public void dummyOperationInput(BufferedWriter bw) throws IOException {
		// TODO Auto-generated method stub

	}
}
