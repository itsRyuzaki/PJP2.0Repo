package com.sapient.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderUtil {

	public static void readCSV(ArrayList<String[]> incomeDetailsList, String inputFilePath, String delimiter) {
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {

			while ((line = br.readLine()) != null) {

				String[] inputElement = line.split(delimiter);
				incomeDetailsList.add(inputElement);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
