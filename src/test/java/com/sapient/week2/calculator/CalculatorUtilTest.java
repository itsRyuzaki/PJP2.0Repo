package com.sapient.week2.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sapient.week2.calculator.bo.ArithmeticOperations;
import com.sapient.week2.calculator.bo.CalculatorUtil;

public class CalculatorUtilTest {

	CalculatorUtil calcUtilOBJ = new ArithmeticOperations();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testSetAndDisplayHeading() {

		System.out.println("Testing Operation heading");
		calcUtilOBJ.setAndDisplayHeading(1);
		assertEquals(ManageOperations.operationsList.get(1), calcUtilOBJ.operationHeading);
		assertNotEquals(ManageOperations.operationsList.get(5), calcUtilOBJ.operationHeading);
	}

	@Test
	public void testGenerateRandomDate() {

		System.out.println("Testing Random date generator");
		String minDate = "01/01/1500";
		String maxDate = "31/12/9000";

		assertTrue("Generated date should be greater than " + minDate,
				compareStrings(minDate, calcUtilOBJ.generateRandomDate()));
		assertTrue("Generated date should be less than " + maxDate,
				compareStrings(calcUtilOBJ.generateRandomDate(), maxDate));

	}

	@Test
	public void testCheckInteger() {

		System.out.println("Testing for Integer type variable");
		assertEquals(5, calcUtilOBJ.checkInteger(String.valueOf("5"), 5));
		assertNotEquals(23, calcUtilOBJ.checkInteger(String.valueOf("10"), 1));
	}

	@After
	public void tearDown() throws Exception {
	}

	private boolean compareStrings(String s1, String s2) {
		if (s1.compareTo(s2) <= 0) {
			return true;
		}
		return false;

	}
}
