package com.sapient.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sapient.week2.assignment2.TransactionPOJO;

public class TransactionDAO {

	public static String header;

	public static ArrayList<String[]> readInputFile(String inputFilePath, String delimiter)
			throws FileFormatNotAvailableException {

		System.out.print("Reading input file....");

		ArrayList<String[]> transactionDetailsList = new ArrayList<>();

		String typeOfFile = inputFilePath.substring(inputFilePath.length() - 3);

		if (typeOfFile.equals("csv")) {
			header = ReaderUtil.readCSV(transactionDetailsList, inputFilePath, delimiter);
		} else {
			System.out.println("Error reading file!");
			throw new FileFormatNotAvailableException(
					typeOfFile + " format is not available. Currently available formats are: .csv");
		}

		System.out.println("Done");

		return transactionDetailsList;

	}

	public static void generateReport(String outputFilePath, ArrayList<TransactionPOJO> finalTransactionList) {

		System.out.println("Generating final report...");
		String entry = "Client Id,Transaction Type,Transaction Date,Priority Flag,Processing Fee(in USD)" + "\n";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

			for (TransactionPOJO transactionOBJ : finalTransactionList) {
				entry += transactionOBJ.getClientId() + "," + transactionOBJ.getTransactionType() + ","
						+ transactionOBJ.getTransactionDate() + "," + transactionOBJ.getPriorityFlag() + ","
						+ transactionOBJ.getProcessingFee() + "\n";
			}

			bw.write(entry);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Final report generated at 'transactionReport.csv' in the same folder!");
	}

}
