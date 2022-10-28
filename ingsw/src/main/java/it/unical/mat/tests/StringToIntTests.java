package it.unical.mat.tests;

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
	

}
