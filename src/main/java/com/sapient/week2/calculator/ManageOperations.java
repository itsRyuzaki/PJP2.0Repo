package com.sapient.week2.calculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.bo.CalculatorUtil;
import com.sapient.week2.calculator.bo.Operation1;
import com.sapient.week2.calculator.bo.Operation2;
import com.sapient.week2.calculator.bo.Operation3;
import com.sapient.week2.calculator.bo.Operation4;
import com.sapient.week2.calculator.bo.Operation5;
import com.sapient.week2.calculator.bo.Operation6;
import com.sapient.week2.calculator.bo.Operation7;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.calculator.dao.SessionHistoryPOJO;
import com.sapient.week2.misc.Read;

public class ManageOperations {

	public static String operationsList[] = new String[8];
	public static ArrayList<OperationHistoryPOJO> curresntSessionHistory = new ArrayList<>();

	static {
		/*
		 * List of possible Calculator Operations.
		 */

		operationsList[0] = "Difference between dates";
		operationsList[1] = "Arithmetic Operations on a given date";
		operationsList[2] = "Day/Week Number for a given date";
		operationsList[3] = "Date from the given phrase";
		operationsList[4] = "History for all the operations in the current session";
		operationsList[5] = "Select language";
		operationsList[6] = "History for the last 100 sessions";
		operationsList[7] = "Bulk processing and operations(max 100,000 operations)";
	}

	public static void showOperations() {

		System.out.println("\nBelow list shows the possible operations in the calculator");
		System.out.println("Enter a digit to start(-1 to terminate)\n");

		for (int i = 1; i <= operationsList.length; i++) {
			System.out.println("" + i + ". " + operationsList[i - 1]);
		}

	}

	public static boolean process(int choice, SessionHistoryPOJO sessionHistory) {
		CalculatorUtil operation1 = new Operation1();
		CalculatorUtil operation2 = new Operation2();
		CalculatorUtil operation3 = new Operation3();
		CalculatorUtil operation4 = new Operation4();
		CalculatorUtil operation5 = new Operation5();
		CalculatorUtil operation6 = new Operation6();
		CalculatorUtil operation7 = new Operation7();

		CalculatorUtil[] utilityList = { operation1, operation2, operation3, operation4, operation5, operation6,
				operation7 };

		OperationHistoryPOJO operationHistory = utilityList[choice - 1].solve();
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

		} else if (choice.equals("m")) {

		} else {
			System.out.println("Invalid choice...Going Back to main menu");
		}

		return true;

	}

}
