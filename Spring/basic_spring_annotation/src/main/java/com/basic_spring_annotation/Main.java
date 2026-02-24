package com.basic_spring_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		Employee emp = ioc.getBean(Employee.class);
		System.out.println(emp);
		
		Person p = ioc.getBean(Person.class);
		System.out.println(p.getMobile());
		System.out.println(p.getScan());
		
	}
}
