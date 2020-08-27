package com.sapient.week2.calculator.bo;

import java.io.BufferedWriter;
import java.io.IOException;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Read;

public class BulkProcessing extends CalculatorUtil {

	@Override
	public OperationHistoryPOJO solve(int operationNum) {

		this.setAndDisplayHeading(operationNum);

		inputList.add("User requested for bulk processing of data");

		System.out.println("Hang on..while the program is processing the operations.");

		String inputFilePath = "./AutomatedData.txt";

		Read.setIN(true, inputFilePath);

		ioMap.put(inputList, outputList);
		outputList.add("Successfully completed bulk processing of operations.");
		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

	@Override
	public void dummyOperationInput(BufferedWriter bw) throws IOException {

	}

}
