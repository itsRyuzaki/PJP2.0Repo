package com.sapient.week2.assignment2;

import java.util.ArrayList;

import com.sapient.bo.TransactionBO;
import com.sapient.dao.FileFormatNotAvailableException;
import com.sapient.dao.TransactionDAO;

public class App {
	public static void main(String[] args) throws FileFormatNotAvailableException {
		String inputFilePath = args[0];
		String delimiter = ",";
		String outputFilePath = args[1];

		ArrayList<String[]> transactionDetailsList = TransactionDAO.readInputFile(inputFilePath, delimiter);
		ArrayList<TransactionPOJO> finalTransactionList = TransactionBO
				.processTransactionDetails(transactionDetailsList);
		TransactionDAO.generateReport(outputFilePath, finalTransactionList);
	}
}
