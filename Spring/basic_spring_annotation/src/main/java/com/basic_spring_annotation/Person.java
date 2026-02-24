package com.basic_spring_annotation;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	@Autowired  //dependency injection
	private Mobile mobile;
	
	@Autowired
	private Scanner scan;
	
	public Scanner getScan() {
		return scan;
	}


	public void setScan(Scanner scan) {
		this.scan = scan;
	}


	public Mobile getMobile() {
		return mobile;
	}


	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}


	public void message() {
		System.out.println("huka");
	}
}
