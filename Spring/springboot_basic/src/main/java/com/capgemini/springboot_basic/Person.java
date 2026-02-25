package com.capgemini.springboot_basic;

import java.util.List;

public class Person {
	private List<String> name;

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	public Person(List<String> name) {
		
		this.name = name;
	}
	

}
