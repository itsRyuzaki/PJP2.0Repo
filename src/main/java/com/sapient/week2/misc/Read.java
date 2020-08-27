package com.sapient.week2.misc;

public class Read {

	public static CustomScanner in = new CustomScanner(false, "");

	public static void setIN(boolean typeFlag, String filePath) {
		in = new CustomScanner(typeFlag, filePath);
	}

}
