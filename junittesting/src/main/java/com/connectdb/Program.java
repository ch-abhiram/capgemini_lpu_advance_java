package com.connectdb;

public class Program {

	public static boolean isPalindrome(String str) {
		String original = str;
		StringBuilder strb = new StringBuilder(str);
		String rev = strb.reverse().toString();
		
		if(original.equalsIgnoreCase(rev)) {
			return true;
		}
		return false;	
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public static String evenOrOdd(int a) {
		return (a % 2 == 0) ? ("even") : ("odd");
	}
	
}
