package com.basic_of_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
		
		Person person = ioc.getBean("person",Person.class);
		System.out.println(person);
		person.message();
		
		Employee emp = ioc.getBean("employee",Employee.class);
//		emp.setId(101);
//		emp.setName("hamsa");
//		emp.setSalary(120.0);
		System.out.println(emp);
		
	}
}
