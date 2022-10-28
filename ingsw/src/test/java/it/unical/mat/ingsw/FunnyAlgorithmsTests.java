package it.unical.mat.ingsw;

import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.junit.*;

public class FunnyAlgorithmsTests {
	public static FunnyAlgorithms _instance = null;
	public static long unixts = 0;
	
	@Before
	public void printStartTime() {
		DateTime startdt = new DateTime();
		int month = startdt.getMonthOfYear();
		int year = startdt.getYear();
		int day = startdt.getDayOfMonth();
		int hour = startdt.getHourOfDay();
		int minute = startdt.getMinuteOfHour();
		int second = startdt.getSecondOfMinute();
		int milli = startdt.getMillisOfSecond();
		String ts = day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second + "." + milli;
		unixts = startdt.getMillis();
		System.out.println("Test initial timestamp: " + ts);
	}
	
	@After
	public void printEndTime() {
		DateTime dt = new DateTime();
		int month = dt.getMonthOfYear();
		int year = dt.getYear();
		int day = dt.getDayOfMonth();
		int hour = dt.getHourOfDay();
		int minute = dt.getMinuteOfHour();
		int second = dt.getSecondOfMinute();
		int milli = dt.getMillisOfSecond();
		String ts = day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second + "." + milli;
		
		System.out.println("Test final timestamp: " + ts);
		System.out.println("Elapsed: " + (dt.getMillis() - unixts) + " ms\n");
	}
	
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
	
	@Test
	public void selectionSortWithOrder1Works() {
		int[][] unsortedArrays = {
			{ 3, 1, 2, 4 },
			{ 10, 11, 12 },
			{ 13, 11, 10 },
			{ 1000, 1, -50 },
			{ 6, 5 }
		};

		int[][] sortedArrays = {
			{ 1, 2, 3, 4 },
			{ 10, 11, 12 },
			{ 10, 11, 13 },
			{ -50, 1, 1000 },
			{ 5, 6 }
		};
		
		if (sortedArrays.length != unsortedArrays.length)
			throw new RuntimeException("JUNIT TESTING: sortedArrays length != unsortedArrays length");
		
		for (int i = 0; i < unsortedArrays.length; i++) {
			_instance.selectionSort(unsortedArrays[i], 1);
			
			for (int j = 0; j < unsortedArrays[i].length; ++j)
				assertEquals(unsortedArrays[i][j], sortedArrays[i][j]);
		}
	}
	
	@Test
	public void selectionSortWithOrder0Works() {
		int[][] unsortedArrays = {
			{ 3, 1, 2, 4 },
			{ 10, 11, 12 },
			{ 13, 11, 10 },
			{ 1000, 1, -50 },
			{ 6, 5 }
		};

		int[][] sortedArrays = {
			{ 4, 3, 2, 1 },
			{ 12, 11, 10 },
			{ 13, 11, 10 },
			{ 1000, 1, -50 },
			{ 6, 5 }
		};
		
		if (sortedArrays.length != unsortedArrays.length)
			throw new RuntimeException("JUNIT TESTING: sortedArrays length != unsortedArrays length");
		
		for (int i = 0; i < unsortedArrays.length; i++) {
			_instance.selectionSort(unsortedArrays[i], 0);
			
			for (int j = 0; j < unsortedArrays[i].length; ++j)
				assertEquals(unsortedArrays[i][j], sortedArrays[i][j]);
		}
	}
}
