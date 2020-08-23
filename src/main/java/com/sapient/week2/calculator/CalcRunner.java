package com.sapient.week2.calculator;

import java.time.LocalDateTime;

import com.sapient.week2.calculator.dao.SessionHistoryPOJO;

public class CalcRunner {

	public static void main(String[] args) {

		String filePath = "./SessionHistory/sessions.ser";

		LocalDateTime sessionStartingTime = LocalDateTime.now();
		SessionHistoryPOJO sessionHistory = new SessionHistoryPOJO(sessionStartingTime);
		SessionHistoryPOJO.setPath(filePath);

		while (MainMenu.showUI(sessionHistory)) {
		}

	}

}
