package it.unical.mat.ingsw;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class FunnyAlgorithmsTests {
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
		_instance.stringToIntConverter("11.2344");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void emptyStringNotAllowed() {
		_instance.stringToIntConverter("");
	}
	
	@Test
	public void negativeNumbersWork() {
		// Basic static tests
		
		assertEquals(_instance.stringToIntConverter("-12"), -12);
		assertEquals(_instance.stringToIntConverter("-123"), -123);
		assertEquals(_instance.stringToIntConverter("-334"), -334);
		assertEquals(_instance.stringToIntConverter("-156"), -156);
		
		for (int i = 0; i < 100; ++i) {
			Integer num = (int)(Math.random() * -32768);
			String strNum = num.toString();
			assertEquals(_instance.stringToIntConverter(strNum), num.intValue());
		}
	}
	
	@Test
	public void positiveNumbersWork() {
		// Static tests
		assertEquals(_instance.stringToIntConverter("10"), 10);
		assertEquals(_instance.stringToIntConverter("20"), 20);
		assertEquals(_instance.stringToIntConverter("30"), 30);
		assertEquals(_instance.stringToIntConverter("40"), 40);
		assertEquals(_instance.stringToIntConverter("10000"), 10000);
		
		// Dynamic tests
		for (int i = 0; i < 100; ++i) {
			Integer num = (int)(Math.random() * 32767);
			String strNum = num.toString();
			assertEquals(_instance.stringToIntConverter(strNum), num.intValue());
		}
	}

	@Test (expected = NumberFormatException.class)
	public void numberInRange() {
		_instance.stringToIntConverter("1000000");
	}
	
	@Test (expected = NumberFormatException.class)
	public void numberInRange2() {
		_instance.stringToIntConverter("-1000000");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void selectionSortDoesNotAcceptInvalidOrder() {
		int[] arrayTest = {1, 2, 3};
		_instance.selectionSort(arrayTest, -10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void selectionSortDoesNotAcceptInvalidOrder2() {
		int[] arrayTest = {1, 2, 3};
		_instance.selectionSort(arrayTest, 10);
	}
	
	
}
