package com.sapient.week2.calculator.bo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.ManageSessions;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;

public class Operation5 implements CalculatorUtil {
	ArrayList<String> inputList = new ArrayList<>();
	ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	@Override
	public OperationHistoryPOJO solve() {

		String operationHeading = ManageOperations.operationsList[4];
		Display.heading(operationHeading);
		inputList.add(operationHeading);

		ArrayList<OperationHistoryPOJO> currentSessionHistory = ManageOperations.curresntSessionHistory;

		if (currentSessionHistory.size() == 0) {

			outputList.add("No operations performed in the current session");

		} else {

			ManageSessions.readCurrentSessionHistory(currentSessionHistory);

			outputList.add("History of all the operations in the current session was shown.");
		}

		ioMap.put(inputList, outputList);
		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

}
