package com.sapient.week2.calculator.bo;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.sapient.week2.calculator.ManageOperations;
import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.misc.Display;

public class Operation6 implements CalculatorUtil {

	ArrayList<String> inputList = new ArrayList<>();
	ArrayList<String> outputList = new ArrayList<>();
	LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap = new LinkedHashMap<>();

	@Override
	public OperationHistoryPOJO solve() {

		String operationHeading = ManageOperations.operationsList[5];
		Display.heading(operationHeading);

		ioMap.put(inputList, outputList);
		return ManageOperations.saveCurrentOperationHistory(operationHeading, ioMap);
	}

}
