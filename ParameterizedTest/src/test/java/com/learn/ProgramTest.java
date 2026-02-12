package com.learn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.learn.Program;

public class ProgramTest {
//	@ParameterizedTest
//	@ValueSource(strings= {"tenet","radar","mam"})
//	public void isPalindromeTest(String str) {
//		Program p = new Program();
//		assertTrue(p.isPalindrome(str));
//	}
	
//	@ParameterizedTest
//	@CsvSource({
//		"1,2,3",
//		"2,3,5",
//		"10,5,15"
//	})
//	public void addTest(int a, int b, int expectedResult) {
//		Program p = new Program();
//		int actualres = p.add(a, b);
//		assertEquals(expectedResult, actualres);
//	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/capgemini.csv",numLinesToSkip = 1)
	public void evenorodd(String input,String expected) {
		EvenOrOdd obj = new EvenOrOdd();
		int num = Integer.parseInt(input);
		String actualres = obj.evenOrOdd(num);
		assertEquals(expected,actualres);
	}

}
