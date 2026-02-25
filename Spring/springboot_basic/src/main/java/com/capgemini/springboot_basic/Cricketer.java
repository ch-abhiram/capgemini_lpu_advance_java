package com.capgemini.springboot_basic;

import org.springframework.stereotype.Component;


public class Cricketer {
	private String name;
	private String role;
	private int runs;
	private int matches;
	private double avg;
	public Cricketer(String name, String role, int runs, int matches, double avg) {
		super();
		this.name = name;
		this.role = role;
		this.runs = runs;
		this.matches = matches;
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	@Override
	public String toString() {
		return "Cricketer [name=" + name + ", role=" + role + ", runs=" + runs + ", matches=" + matches + ", avg=" + avg
				+ "]";
	}
	
	
}
