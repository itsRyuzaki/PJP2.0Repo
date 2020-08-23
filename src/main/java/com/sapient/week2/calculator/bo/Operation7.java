package com.sapient.week2.calculator.bo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.ManageSessions;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.calculator.dao.SessionHistoryPOJO;
import com.sapient.week2.misc.Display;

public class Operation7 implements CalculatorUtil {

	ArrayList<String> inputList = new ArrayList<>();
	ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	@Override
	public OperationHistoryPOJO solve() {

		String operationHeading = ManageOperations.operationsList[6];
		Display.heading(operationHeading);
		LinkedList<SessionHistoryPOJO> sessionHistoryList = ManageSessions.readSessionHistory();

		inputList.add("User requested for history of last 100 sessions ");

		if (sessionHistoryList == null) {
			outputList.add("No previous sessions found!!");
			ioMap.put(inputList, outputList);
			return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);

		}

		int i = 1;
		for (SessionHistoryPOJO sessionHistoryElement : sessionHistoryList) {
			System.out.println("Session #" + i);
			i++;
			showDetailedHistory(sessionHistoryElement);
		}

		outputList.add("History of last " + sessionHistoryList.size() + " Sessions displayed!!");
		ioMap.put(inputList, outputList);

		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);

	}

	public void showDetailedHistory(SessionHistoryPOJO sessionHistoryElement) {

		System.out.println("Session Starting Time: " + sessionHistoryElement.getStartingTimeStamp() + "\n");

		ArrayList<OperationHistoryPOJO> operationHistoryList = sessionHistoryElement.getOperationHistoryList();

		ManageSessions.readCurrentSessionHistory(operationHistoryList);

		System.out.println("Session ending Time: " + sessionHistoryElement.getEndingTimeStamp());
		System.out.println("           ---------xxxxxx--------\n");
	}

}
