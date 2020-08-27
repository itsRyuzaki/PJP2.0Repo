package com.sapient.week2.calculator.bo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.ManageSessions;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;

public class CurrentSessionHistory extends CalculatorUtil {

	@Override
	public OperationHistoryPOJO solve(int operationNum) {

		this.setAndDisplayHeading(operationNum);

		inputList.add(operationHeading);

		ArrayList<OperationHistoryPOJO> currentSessionHistory = ManageOperations.curresntSessionHistory;

		if (currentSessionHistory.size() == 0) {

			outputList.add("No operations performed in the current session");
			System.out.println("No operations performed in the current session!!");

		} else {

			ManageSessions.readCurrentSessionHistory(currentSessionHistory);

			outputList.add("History of all the operations in the current session was shown.");
		}

		ioMap.put(inputList, outputList);
		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

	@Override
	public void dummyOperationInput(BufferedWriter bw) throws IOException {
		// TODO Auto-generated method stub

	}

}
