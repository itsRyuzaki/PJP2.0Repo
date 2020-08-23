package com.sapient.week2.calculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.sapient.week2.calculator.dao.OperationHistoryPOJO;
import com.sapient.week2.calculator.dao.SessionHistoryPOJO;

public class ManageSessions {

	public static void writeSessionHistory(SessionHistoryPOJO sessionHistory) {

		System.out.println("\nTerminating....");
		LinkedList<SessionHistoryPOJO> sessionHistoryList = new LinkedList<>();

		if (checkFileExists()) {
			sessionHistoryList = readSessionHistory();
			if (sessionHistoryList != null && sessionHistoryList.size() == 100) {
				sessionHistoryList.removeFirst();
			}
		}

		try (FileOutputStream fout = new FileOutputStream(SessionHistoryPOJO.getPath());
				ObjectOutputStream oos = new ObjectOutputStream(fout)) {

			sessionHistory.setEndingTimeStamp(LocalDateTime.now());

			sessionHistoryList.add(sessionHistory);

			oos.writeObject(sessionHistoryList);
			sessionHistory.setIsSessionLive(false);

			System.out.println("Done");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {
			System.out.println("Bye!!");

		}

	}

	public static boolean checkFileExists() {

		return new File(SessionHistoryPOJO.getPath()).exists();
	}

	@SuppressWarnings("unchecked")
	public static LinkedList<SessionHistoryPOJO> readSessionHistory() {

		if (!checkFileExists()) {

			System.out.println("No Previous sessions!");
			return null;

		}

		LinkedList<SessionHistoryPOJO> sessionHistoryList = new LinkedList<>();

		try (FileInputStream fis = new FileInputStream(SessionHistoryPOJO.getPath());
				ObjectInputStream ois = new ObjectInputStream(fis)) {

			sessionHistoryList = (LinkedList<SessionHistoryPOJO>) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sessionHistoryList;
	}

	public static void readCurrentSessionHistory(ArrayList<OperationHistoryPOJO> operationHistoryList) {
		int i = 1;
		for (OperationHistoryPOJO operationHistoryElement : operationHistoryList) {

			System.out.println("Operation #" + i + ": " + operationHistoryElement.getOperationHeading());
			i++;
			System.out.println("Timestamp: " + operationHistoryElement.getExceutionDateTime());

			HashMap<ArrayList<String>, ArrayList<String>> temp_ioMap = operationHistoryElement.getIoMap();

			temp_ioMap.forEach((key, value) -> {
				System.out.println("\nUser Input:");
				key.forEach((data) -> System.out.println(data));

				System.out.println("\nProgram Output:");
				value.forEach((data) -> System.out.println(data));

			});

			System.out.println("\n                    --xx--\n");

		}
	}

}
