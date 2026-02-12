package com.learn;

public class Program {
	public boolean isPalindrome(String str) {
		String rev = new StringBuilder(str).reverse().toString();
		
		return rev.equals(str);
		
	}
	
	public int add(int a,int b) {
		return a+b;
	}

}
