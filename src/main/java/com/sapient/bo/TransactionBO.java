package com.sapient.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.sapient.week2.assignment2.TransactionPOJO;

public class TransactionBO {

	private static HashMap<String, Integer> buySecurityMap = new HashMap<>();
	private static HashMap<String, Integer> sellSecurityMap = new HashMap<>();

	private static ArrayList<TransactionPOJO> finalTransactionList = new ArrayList<>();

	public static ArrayList<TransactionPOJO> processTransactionDetails(ArrayList<String[]> transactionDetailsList) {

		System.out.println("Please wait...processing the contents of file.");

		int count = 0;

		System.out.println("Calculating fees for normal transactions..");

		for (String[] element : transactionDetailsList) {
			TransactionPOJO tempOBJ = new TransactionPOJO(element[0], element[1], element[2], element[3], element[4],
					new BigDecimal(element[5]), element[6]);

			String key = tempOBJ.getClientId() + "|" + tempOBJ.getSecurityId() + "|" + tempOBJ.getTransactionDate();
			if (tempOBJ.getTransactionType().equals("SELL")) {
				sellSecurityMap.put(key, count);
			}
			if (tempOBJ.getTransactionType().equals("BUY")) {
				buySecurityMap.put(key, count);
			}
			count++;
			int processingFee = processNormalTransactions(tempOBJ);
			tempOBJ.addProcessingFee(processingFee);

			finalTransactionList.add(tempOBJ);
		}

		processIntraDayTransactions();

		System.out.println("Sorting the transaction details..");

		Collections.sort(finalTransactionList, new CustomComparator());

		System.out.println("Done processing!");

		return finalTransactionList;

	}

	private static int processNormalTransactions(TransactionPOJO tempOBJ) {

		if (tempOBJ.getPriorityFlag().equals("Y")) {
			return 500;

		} else {
			if (tempOBJ.getTransactionType().equals("SELL") || tempOBJ.getTransactionType().equals("WITHDRAW")) {
				return 100;
			}
		}
		return 50;
	}

	public static void processIntraDayTransactions() {

		System.out.println("Checking for Intra-Day transactions...");

		int intraDayProcessingFee = 10;

		buySecurityMap.forEach((key, value) -> {

			if (sellSecurityMap.containsKey(key)) {
				finalTransactionList.get(value).addProcessingFee(intraDayProcessingFee);
				finalTransactionList.get(sellSecurityMap.get(key)).addProcessingFee(intraDayProcessingFee);
			}

		});

	}

}
