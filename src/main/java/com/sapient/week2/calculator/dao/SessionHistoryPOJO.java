package com.sapient.week2.calculator.dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SessionHistoryPOJO implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<OperationHistoryPOJO> operationHistoryList;
	private LocalDateTime startingTimeStamp;
	private LocalDateTime endingTimeStamp;
	private boolean isSessionLive;
	private static String path;

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		SessionHistoryPOJO.path = path;
	}

	public LocalDateTime getStartingTimeStamp() {
		return startingTimeStamp;
	}

	public void setStartingTimeStamp(LocalDateTime startingTimeStamp) {
		this.startingTimeStamp = startingTimeStamp;
	}

	public LocalDateTime getEndingTimeStamp() {
		return endingTimeStamp;
	}

	public void setEndingTimeStamp(LocalDateTime endingTimeStamp) {
		this.endingTimeStamp = endingTimeStamp;
	}

	public boolean getIsSessionLive() {
		return isSessionLive;
	}

	public void setIsSessionLive(boolean isSessionLive) {
		this.isSessionLive = isSessionLive;
	}

	public ArrayList<OperationHistoryPOJO> getOperationHistoryList() {
		return operationHistoryList;
	}

	public void addOperationHistoryObj(OperationHistoryPOJO operationHistory) {
		operationHistoryList.add(operationHistory);
	}

	public SessionHistoryPOJO(LocalDateTime startingTimeStamp) {
		super();
		this.startingTimeStamp = startingTimeStamp;
		operationHistoryList = new ArrayList<>();
		isSessionLive = true;
	}

}
