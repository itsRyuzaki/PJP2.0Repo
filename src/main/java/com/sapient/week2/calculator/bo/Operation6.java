package com.sapient.week2.calculator.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public class Operation6 implements CalculatorUtil {

	ArrayList<String> inputList = new ArrayList<>();
	ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	static HashMap<String, String> languageMap = new HashMap<>();

	static {
		languageMap.put("fr", "French");
		languageMap.put("sp", "spanish");
		languageMap.put("hi", "Hindi");
	}

	@Override
	public OperationHistoryPOJO solve() {

		String operationHeading = ManageOperations.operationsList[5];
		Display.heading(operationHeading);

		System.out.println("List of available languages: ");
		languageMap.forEach((key, value) -> System.out.println(value));

		inputList.add(operationHeading);

		outputList.add("User was shown available languages.");
		ioMap.put(inputList, outputList);

		inputList = new ArrayList<>();
		outputList = new ArrayList<>();

		System.out.print("Enter the first 2 letters of the language to proceed: ");
		String choice = Read.in.next();

		inputList.add("Language entered: " + choice);

		checkValidLanguage(choice);

		outputList.add("User entered valid language: " + languageMap.get(choice));

		String finalOutput = "Application changed to use " + languageMap.get(choice) + " as default language.";
		System.out.println(finalOutput);

		outputList.add(finalOutput);

		ioMap.put(inputList, outputList);

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

	public void checkValidLanguage(String choice) {

		int maxTries = 5;

		while (!languageMap.containsKey(choice.toLowerCase())) {

			if (maxTries == 0) {
				System.out.println("Invalid Choice!!");
				System.out.println("Maximum Tries reached...taking default language(french)");
				outputList.add("User entered invalid choice");
				outputList.add("Application took default language(french)");

				ioMap.put(inputList, outputList);
				inputList = new ArrayList<>();
				outputList = new ArrayList<>();
				choice = "fr";
			} else {
				System.out.println("Invalid choice..Try Again");
				outputList.add("User entered invalid choice");
				outputList.add("User was again asked to enter the language!");
				ioMap.put(inputList, outputList);
				inputList = new ArrayList<>();
				outputList = new ArrayList<>();
				System.out.print("Enter the first 2 letters of the language to proceed: ");
				choice = Read.in.next();
				inputList.add("Language entered: " + choice);

			}
			maxTries--;

		}

	}

}
