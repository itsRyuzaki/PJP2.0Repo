package com.sapient.week2.misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomScanner {

	public boolean typeFlag = false;
	public Scanner in = new Scanner(System.in);
	public String filePath;
	public Scanner in2 = null;

	public String next() {
		if (!typeFlag) {
			return in.next();
		} else {

			return in2.nextLine();
		}

	}

	public CustomScanner(boolean typeFlag, String filePath) {
		super();
		this.typeFlag = typeFlag;
		this.filePath = filePath;
		if (typeFlag) {
			try {
				in2 = new Scanner(new File(filePath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
