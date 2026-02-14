package com.onetomanymapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	
	
	@Id
	private int clgId;
	private String name;
	private String location;
	private String pincode;
	@OneToMany
	private List<Student> stu;
	
	
	public List<Student> getStu() {
		return stu;
	}
	public void setStu(List<Student> stu) {
		this.stu = stu;
	}
	@Override
	public String toString() {
		return "College [clgId=" + clgId + ", name=" + name + ", location=" + location + ", pincode=" + pincode
				+ ", stu=" + stu + "]";
	}
	public int getClgId() {
		return clgId;
	}
	public void setClgId(int clgId) {
		this.clgId = clgId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
