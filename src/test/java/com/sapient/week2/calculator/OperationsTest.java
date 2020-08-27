package com.sapient.week2.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import com.sapient.week2.calculator.bo.ArithmeticOperations;
import com.sapient.week2.calculator.bo.DateFromPhrase;
import com.sapient.week2.calculator.bo.LanguageSelection;

public class OperationsTest {

	@Before
	public void setUp() {

	}

	@Test
	public void testArithmeticOperations() {

		System.out.println("Testing Arithmetic Operations functions");

		ArithmeticOperations tempOBJ = new ArithmeticOperations();

		assertEquals("add", tempOBJ.checkIfChoiceIsValid("add"));
		assertEquals("subtract", tempOBJ.checkIfChoiceIsValid("subtract"));

	}

	@Test
	public void testDateFromPhrase() {
		System.out.println("Testing Date from phrase functions");

		DateFromPhrase tempOBJ = new DateFromPhrase();

		assertEquals("n", tempOBJ.checkValidChoice("n"));
		assertNotEquals("n", tempOBJ.checkValidChoice("y"));

		assertEquals("today", tempOBJ.checkValidPhrase("today"));
		assertEquals("tomorrow", tempOBJ.checkValidPhrase("tomorrow"));

	}

	@Test
	public void testLanguageSelection() {
		System.out.println("Testing Language Selection functions");

		LanguageSelection tempOBJ = new LanguageSelection();

		assertEquals("fr", tempOBJ.checkValidLanguage("fr"));
		assertNotEquals("hi", tempOBJ.checkValidLanguage("sp"));

	}

}
