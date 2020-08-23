package com.sapient.week2.calculator.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public class Operation4 implements CalculatorUtil {

	public static HashMap<String, Integer> phrasesMap = new HashMap<>();

	ArrayList<String> inputList = new ArrayList<>();
	ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	public static void initializePhraseMap() {
		phrasesMap.put("today", 0);
		phrasesMap.put("tomorrow", 1);
		phrasesMap.put("day-after-tomorrow", 2);
		phrasesMap.put("yesterday", -1);
		phrasesMap.put("day-before-yesterday", -2);
		phrasesMap.put("last-week", -7);
		phrasesMap.put("previous-week", -7);
		phrasesMap.put("next-week", 7);
		phrasesMap.put("next-month", 30);
		phrasesMap.put("next-year", 365);
		phrasesMap.put("last-month", -30);
		phrasesMap.put("last-year", -365);
		phrasesMap.put("month-after", 30);
		phrasesMap.put("month-before", -30);

//		TODO: add more phrases 
//		phrasesMap.put("n weeks from now, n days from now, n months from now, n years
//		from now, n days earlier, n weeks earlier, n months earlier, n years earlier 

	}

	@Override
	public OperationHistoryPOJO solve() {

		initializePhraseMap();

		String operationHeading = ManageOperations.operationsList[3];

		Display.heading(operationHeading);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Show list of available phrases(Y|N): ");
		String choice = Read.in.next();

		inputList.add("Choice entered: " + choice);

		choice = checkValidChoice(choice);

		outputList.add("User entered valid choice: " + choice);

		ioMap.put(inputList, outputList);

		inputList = new ArrayList<>();
		outputList = new ArrayList<>();

		showPhrases(choice);

		System.out.print("\nEnter phrase: ");
		String phrase = Read.in.next();

		inputList.add("Phrase entered by user: " + phrase);

		phrase = checkValidPhrase(phrase);

		outputList.add("Valid phrase entered: " + phrase);

		ioMap.put(inputList, outputList);

		inputList = new ArrayList<>();
		outputList = new ArrayList<>();

		inputList.add(operationHeading);

		Operation2 op2 = new Operation2();
		LocalDate finalDate = op2.getFinalDate(LocalDate.now(), 1, phrasesMap.get(phrase.toLowerCase()), 0, 0);

		System.out.println("Date from the phrase is: " + finalDate.format(formatter));
		outputList.add("Final Date: " + finalDate.format(formatter));

		ioMap.put(inputList, outputList);

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);

	}

	public String checkValidPhrase(String phrase) {

		while (!phrasesMap.containsKey(phrase.toLowerCase())) {
			System.out.println("Invalid phrase..Try Again!");
			outputList.add("User entered invalid phrase");
			outputList.add("User was given an option to select available phrases");

			ioMap.put(inputList, outputList);
			inputList = new ArrayList<>();
			outputList = new ArrayList<>();

			System.out.println("Show list of available phrases(Y|N): ");
			String choice = Read.in.next();

			inputList.add("Choice entered: " + choice);

			choice = checkValidChoice(choice);

			outputList.add("User entered valid choice: " + choice);

			showPhrases(choice);

			ioMap.put(inputList, outputList);
			inputList = new ArrayList<>();
			outputList = new ArrayList<>();

			System.out.print("Enter phrase again: ");
			phrase = Read.in.next();

			inputList.add("Phrase entered by user: " + phrase);

		}
		return phrase;
	}

	public String checkValidChoice(String choice) {

		while (!choice.toLowerCase().equals("y") && !choice.toLowerCase().equals("n")) {

			System.out.println("Invalid choice! Try Again");
			outputList.add("User entered invalid choice");
			outputList.add("User was asked to enter valid choice");

			ioMap.put(inputList, outputList);
			inputList = new ArrayList<>();
			outputList = new ArrayList<>();

			System.out.print("Enter your choice again: ");
			choice = Read.in.next();
			inputList.add("Choice entered: " + choice);

		}

		return choice;
	}

	public void showPhrases(String choice) {

		if (choice.toLowerCase().equals("y")) {

			System.out.println("Available phrases\n");
			phrasesMap.forEach((key, value) -> System.out.println(key));

		}

	}

}
