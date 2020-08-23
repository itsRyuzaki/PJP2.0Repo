package com.sapient.week2.calculator.dao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class OperationHistoryPOJO implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDateTime exceutionDateTime;
	private String operationHeading;
//	private HashMap<String[], String[]> ioMap;
	private LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap;

	public LinkedHashMap<ArrayList<String>, ArrayList<String>> getIoMap() {
		return ioMap;
	}

	public void setIoMap(LinkedHashMap<ArrayList<String>, ArrayList<String>> ioMap) {
		this.ioMap = ioMap;
	}

	public String getOperationHeading() {
		return operationHeading;
	}

	public void setOperationHeading(String operationHeading) {
		this.operationHeading = operationHeading;
	}
//
//	public HashMap<String[], String[]> getIoMap() {
//		return ioMap;
//	}
//
//	public void setIoMap(HashMap<String[], String[]> ioMap) {
//		this.ioMap = ioMap;
//	}

	public LocalDateTime getExceutionDateTime() {
		return exceutionDateTime;
	}

	public void setExceutionDateTime(LocalDateTime exceutionDateTime) {
		this.exceutionDateTime = exceutionDateTime;
	}

	public OperationHistoryPOJO(String operationHeading, LocalDateTime exceutionDateTime) {
		super();
		this.operationHeading = operationHeading;
		this.exceutionDateTime = exceutionDateTime;
	}

}
