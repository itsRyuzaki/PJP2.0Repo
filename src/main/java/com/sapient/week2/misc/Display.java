package com.sapient.week2.misc;

import java.time.LocalDateTime;

public class Display {

	public static void heading(String title) {
		System.out.println("--------------  " + title + "  --------------");
		System.out.println("\nCurrent Date and Time: " + LocalDateTime.now());
		System.out.println();

	}

}
