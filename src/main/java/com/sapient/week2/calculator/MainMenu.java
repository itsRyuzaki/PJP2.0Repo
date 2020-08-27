package com.sapient.week2.calculator;

import com.sapient.week2.calculator.dao.SessionHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public class MainMenu {

	public static boolean showUI(SessionHistoryPOJO sessionHistory) {

		Display.heading("Date Time Calculator");

		ManageOperations.showOperations();

		System.out.print("\nEnter your choice: ");
		String schoice = Read.in.next();
		int choice = Integer.parseInt(schoice);
		System.out.println();

		return isValidChoice(choice, sessionHistory);

	}

	public static boolean isValidChoice(int choice, SessionHistoryPOJO sessionHistory) {

		if (choice == -1) {
			ManageSessions.writeSessionHistory(sessionHistory);
			return false;

		} else if (choice < 1 || choice > ManageOperations.operationsList.size()) {

			System.out.println("Invalid choice!! Try Again.");
			System.out.print("\nEnter your choice again: ");
			String schoiceAgain = Read.in.next();
			int choiceAgain = Integer.parseInt(schoiceAgain);
			System.out.println();
			return isValidChoice(choiceAgain, sessionHistory);

		} else {
			return ManageOperations.process(choice, sessionHistory);

		}
	}

}
