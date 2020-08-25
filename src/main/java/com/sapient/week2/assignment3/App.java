package com.sapient.week2.assignment2;

import java.util.ArrayList;

import com.sapient.bo.IncomeBO;
import com.sapient.dao.FileFormatNotAvailableException;
import com.sapient.dao.IncomeDAO;

public class App {
	public static void main(String[] args) throws FileFormatNotAvailableException {

		String inputFilePath = args[0];
		String delimiter = ",";
		String outputFilePath = args[1];

		ArrayList<String[]> incomeDetailsList = IncomeDAO.readInputFile(inputFilePath, delimiter);

		ArrayList<IncomeDetailsPOJO> finalIncomeList = IncomeBO.processIncomeDetails(incomeDetailsList);

		IncomeDAO.generateReport(outputFilePath, finalIncomeList);
	}
}
