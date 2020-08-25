package com.sapient.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderUtil {

	public static String readCSV(ArrayList<String[]> transactionDetailsList, String inputFilePath, String delimiter) {
		String line = "";
		String header = "";

		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {

			header = br.readLine();

			while ((line = br.readLine()) != null) {

				String[] inputElement = line.split(delimiter);
				transactionDetailsList.add(inputElement);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return header;
	}

}
