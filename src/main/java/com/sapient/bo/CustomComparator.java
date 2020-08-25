package com.sapient.bo;

import java.util.Comparator;

import com.sapient.week2.assignment2.TransactionPOJO;

public class CustomComparator implements Comparator<TransactionPOJO> {

	@Override
	public int compare(TransactionPOJO obj1, TransactionPOJO obj2) {

		if (obj1.getClientId().equals(obj2.getClientId())) {

			if (obj1.getTransactionType().equals(obj2.getTransactionType())) {

				if (obj1.getTransactionDate().equals(obj2.getTransactionDate())) {

					return obj1.getPriorityFlag().compareTo(obj2.getPriorityFlag());
				}
				return obj1.getTransactionDate().compareTo(obj1.getTransactionDate());
			}
			return obj1.getTransactionType().compareTo(obj1.getTransactionType());
		}

		return obj1.getClientId().compareTo(obj2.getClientId());
	}

}
