package com.practice;

public class MathService {
	
	Cal obj;
	public MathService(Cal obj) {
		this.obj = obj;
	}
	
	public int doubleAdd(int a,int b) {
		return 2*obj.add(a, b);
	}
	

}
