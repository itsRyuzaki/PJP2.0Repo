package com.sapient.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.sapient.week2.assignment2.IncomeDetailsPOJO;

public class IncomeDAO {

	public static ArrayList<String[]> readInputFile(String inputFilePath, String delimiter)
			throws FileFormatNotAvailableException {

		System.out.print("Reading input file....");

		ArrayList<String[]> incomeDetailsList = new ArrayList<>();

		String typeOfFile = inputFilePath.substring(inputFilePath.length() - 3);

		if (typeOfFile.equals("csv")) {
			ReaderUtil.readCSV(incomeDetailsList, inputFilePath, delimiter);
		} else {
			System.out.println("Error reading file!");
			throw new FileFormatNotAvailableException(
					typeOfFile + " format is not available. Currently available formats are: .csv");
		}

		System.out.println("Done");

		return incomeDetailsList;

	}

	public static void generateReport(String outputFilePath, ArrayList<IncomeDetailsPOJO> finalIncomeList) {

		System.out.println("Generating final report...");
		String entry = "";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

			for (IncomeDetailsPOJO dataElement : finalIncomeList) {
				if (dataElement.getCountry().equals("")) {
					entry += dataElement.getCity();

				}
				entry += dataElement.getCountry();
				entry += "," + dataElement.getGender() + "," + dataElement.getAmount() + "\n";
			}
			bw.write(entry);

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Final report generated at 'incomeReport.csv' in the same folder!");
	}

}
