package com.connectdb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ProgramTest {
	
//	@ParameterizedTest
//	@ValueSource(strings = {"tenet", "radar", "abba", "naman"})
//	public void isPalindrome(String str) { // for parameter another dependency
//		Program p = new Program();
//		assertTrue(p.isPalindrome(str));
//	}
//	
//	@ParameterizedTest
//	@CsvSource({
//		"1,2,3",
//		"2,3,5",
//		"5,5,10"
//	})
//	public void addTest(int a, int b, int expRes) {
//		Program p = new Program();
//		assertEquals(expRes, p.add(a, b));
//	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/capgemini.csv", numLinesToSkip = 1)
	public void evenOrOdd(String a, String expRes) {
		Program p = new Program();
		assertEquals(expRes.trim(), p.evenOrOdd(Integer.valueOf(a))); // in csv everything read as String that's y we are converting this to int
	}
}
