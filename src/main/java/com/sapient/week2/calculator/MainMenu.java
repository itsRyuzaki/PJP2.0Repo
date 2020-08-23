package com.sapient.week2.calculator;

import com.sapient.week2.calculator.dao.SessionHistoryPOJO;
import com.sapient.week2.misc.Display;
import com.sapient.week2.misc.Read;

public class MainMenu {

	public static boolean showUI(SessionHistoryPOJO sessionHistory) {

		Display.heading("Date Time Calculator");

		ManageOperations.showOperations();

		System.out.print("\nEnter your choice: ");
		int choice = Read.in.nextInt();
		System.out.println();

		return isValidChoice(choice, sessionHistory);

	}

	public static boolean isValidChoice(int choice, SessionHistoryPOJO sessionHistory) {

		if (choice == -1) {

			ManageSessions.writeSessionHistory(sessionHistory);
			return false;

		} else if (choice < 1 || choice > 7) {

			System.out.println("Invalid choice!! Try Again.");
			System.out.print("\nEnter your choice again: ");
			int choiceAgain = Read.in.nextInt();
			System.out.println();
			return isValidChoice(choiceAgain, sessionHistory);

		} else {
			return ManageOperations.process(choice, sessionHistory);

		}
	}

}
