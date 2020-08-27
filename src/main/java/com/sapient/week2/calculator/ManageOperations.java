package com.sapient.week2.calculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.bo.ArithmeticOperations;
import com.sapient.week2.calculator.bo.AutomationOfData;
import com.sapient.week2.calculator.bo.BulkProcessing;
import com.sapient.week2.calculator.bo.CalculatorUtil;
import com.sapient.week2.calculator.bo.CurrentSessionHistory;
import com.sapient.week2.calculator.bo.DateFromPhrase;
import com.sapient.week2.calculator.bo.DayOrWeekNumber;
import com.sapient.week2.calculator.bo.DifferenceInDates;
import com.sapient.week2.calculator.bo.LanguageSelection;
import com.sapient.week2.calculator.bo.LastSessionsHistory;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.calculator.dao.SessionHistoryPOJO;
import com.sapient.week2.misc.Read;

public class ManageOperations {

	public static ArrayList<String> operationsList = new ArrayList<>();
	public static ArrayList<OperationHistoryPOJO> curresntSessionHistory = new ArrayList<>();

	static {
		/*
		 * List of possible Calculator Operations.
		 */

		operationsList.add("Difference between dates");
		operationsList.add("Arithmetic Operations on a given date");
		operationsList.add("Day/Week Number for a given date");
		operationsList.add("Date from the given phrase");
		operationsList.add("History for all the operations in the current session");
		operationsList.add("Select language");
		operationsList.add("History for the last 100 sessions");
		operationsList.add("Bulk processing of operations(max 100,000 operations)");
		operationsList.add("Automation of data-creation(max 100,000 operations)");
	}

	public static void showOperations() {

		System.out.println("\nBelow list shows the possible operations in the calculator");
		System.out.println("Enter a digit to start(-1 to terminate)\n");

		for (int i = 1; i <= operationsList.size(); i++) {
			System.out.println("" + i + ". " + operationsList.get(i - 1));
		}

	}

	public static CalculatorUtil[] getUtilityList() {
		CalculatorUtil operation1 = new DifferenceInDates();
		CalculatorUtil operation2 = new ArithmeticOperations();
		CalculatorUtil operation3 = new DayOrWeekNumber();
		CalculatorUtil operation4 = new DateFromPhrase();
		CalculatorUtil operation5 = new CurrentSessionHistory();
		CalculatorUtil operation6 = new LanguageSelection();
		CalculatorUtil operation7 = new LastSessionsHistory();
		CalculatorUtil operation8 = new BulkProcessing();
		CalculatorUtil operation9 = new AutomationOfData();

		CalculatorUtil[] utilityList = { operation1, operation2, operation3, operation4, operation5, operation6,
				operation7, operation8, operation9 };

		return utilityList;

	}

	public static boolean process(int choice, SessionHistoryPOJO sessionHistory) {

		CalculatorUtil[] utilityList = getUtilityList();

		OperationHistoryPOJO operationHistory = utilityList[choice - 1].solve(choice - 1);
		curresntSessionHistory.add(operationHistory);
		return endCurrentOperation(operationHistory, sessionHistory);

	}

	public static OperationHistoryPOJO saveCurrentOperationHistory(String operationHeading,
			LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap) {

		LocalDateTime timestamp = LocalDateTime.now();

		OperationHistoryPOJO operationHistory = new OperationHistoryPOJO(operationHeading, timestamp);

		operationHistory.setIoMap(ioMap);

		return operationHistory;

	}

	public static boolean endCurrentOperation(OperationHistoryPOJO operationHistory,
			SessionHistoryPOJO sessionHistory) {

		sessionHistory.addOperationHistoryObj(operationHistory);

		System.out.println("\nPress 'q' to quit or 'm' for main menu");
		String choice = Read.in.next();
		if (choice.equals("q")) {
			ManageSessions.writeSessionHistory(sessionHistory);
			return false;

		} else if (!choice.equals("m")) {
			System.out.println("Invalid choice...Going Back to main menu");
		}

		return true;

	}

}
