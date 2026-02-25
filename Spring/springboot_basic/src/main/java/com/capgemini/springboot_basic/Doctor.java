package com.capgemini.springboot_basic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class Doctor {
	public void display() {
		System.out.println("hello");
	}

}
