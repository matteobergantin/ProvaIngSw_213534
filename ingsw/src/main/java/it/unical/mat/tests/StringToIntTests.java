package it.unical.mat.tests;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import it.unical.mat.ingsw.FunnyAlgorithms;

public class StringToIntTests {
	public static FunnyAlgorithms _instance = null;
	
	@BeforeClass
	public static void initialize() {
		_instance = new FunnyAlgorithms();
	}
	
	@AfterClass
	public static void cleanup() {
		_instance = null;
	}

	@Test (expected = IllegalArgumentException.class)
	public void floatNumbersNotAllowed() {
		_instance.stringToIntConverter("11.23");
	}
	
	@Test
	public void negativeNumbersWork() {
		assertEquals(_instance.stringToIntConverter("-12"), -12);
		assertEquals(_instance.stringToIntConverter("-123"), -123);
		assertEquals(_instance.stringToIntConverter("-334"), -334);
		assertEquals(_instance.stringToIntConverter("-156"), -156);
	}

	@Test (expected = NumberFormatException.class)
	public void numberInRange() {
		_instance.stringToIntConverter("1000000");
	}
}